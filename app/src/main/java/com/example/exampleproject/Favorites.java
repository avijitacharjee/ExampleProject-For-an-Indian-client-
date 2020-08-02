package com.example.exampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Favorites extends AppCompatActivity {
    List<String> favouritesList;
    AppDatabase database;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        listView = findViewById(R.id.list_view);
        database = new AppDatabase(this);
        favouritesList = new ArrayList<>();
        favouritesList.addAll(database.getData());
        for(int i=0;i<favouritesList.size();i++){
            favouritesList.set(i,(favouritesList.get(i).substring(0,1).toUpperCase()+favouritesList.get(i).substring(1)));
        }
        ArrayAdapter<String> adapter = new FavoriteListAdapter(this,favouritesList);
        listView.setAdapter(adapter);
    }
}
