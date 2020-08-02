package com.example.exampleproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avijit Acharjee on 8/2/2020 at 4:04 PM.
 * Email: avijitach@gmail.com.
 */
public class AppDatabase {
    MyDbHelper dbHelper;
    public AppDatabase(Context context){
        dbHelper = new MyDbHelper(context);
    }
    public long insertFavorite(String name){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDbHelper.NAME,name);
        return db.insert(MyDbHelper.TABLE_NAME,null,contentValues);
    }
    public List<String> getData(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] columns = {MyDbHelper.NAME};
        Cursor cursor = db.query(MyDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        List<String> favList = new ArrayList<>();
        while (cursor.moveToNext()){
            favList.add(cursor.getString(cursor.getColumnIndex(MyDbHelper.NAME)));
        }
        return favList;
    }
    public int delete(String name){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] whereArgs = {name};
        return db.delete(MyDbHelper.TABLE_NAME,MyDbHelper.NAME + " = ?",whereArgs);
    }
    static class MyDbHelper extends SQLiteOpenHelper {
        private static final String TAG = "MyDbHelper";
        public static final String DATABASE_NAME="my_database";
        public static final String TABLE_NAME = "favorites";
        public static final int DATABASE_VERSION = 1;
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String CREATE_TABLE = "CREATE TABLE '"+TABLE_NAME+"' (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + NAME + " VARCHAR(255));";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        private Context context;
        public MyDbHelper(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
            }catch (Exception e ){
                Log.d(TAG, "onCreate: "+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(TAG, "onUpgrade: ");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
    }
}
