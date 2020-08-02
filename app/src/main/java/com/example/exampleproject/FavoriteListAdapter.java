package com.example.exampleproject;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * Created by Avijit Acharjee on 8/2/2020 at 7:16 PM.
 * Email: avijitach@gmail.com.
 */
public class FavoriteListAdapter extends ArrayAdapter<String> {
    private Activity activity;
    private List<String> stringList;
    AppDatabase database;
    public FavoriteListAdapter(Activity activity, List<String> stringList){
        super(activity,R.layout.item_favorite_list,stringList);
        this.activity = activity;
        this.stringList = stringList;
        database = new AppDatabase(activity);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rootView = activity.getLayoutInflater().inflate(R.layout.item_favorite_list,null,true);
        final TextView textView = rootView.findViewById(R.id.name_text_view);
        textView.setText(stringList.get(position));
        final TextView button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setBackground(getContext().getResources().getDrawable(R.drawable.ic_favorite_default));
                database.delete(database.getData().get(position));
                stringList.remove(position);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        notifyDataSetChanged();
                        Toast.makeText(activity, textView.getText().toString() + " was removed from favorites.", Toast.LENGTH_SHORT).show();
                    }
                },500);
            }
        });
        return rootView;
    }
}
