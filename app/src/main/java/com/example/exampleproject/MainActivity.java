package com.example.exampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void toFruits (View view) {
        Intent intent = new Intent(getApplicationContext(), Fruits.class);
        startActivity(intent);
    }
    public void toVegetables (View view) {
        Intent intent = new Intent(getApplicationContext(), Vegetables.class);
        startActivity(intent);
    }
    public void toFavorites (View view) {
        Intent intent = new Intent(getApplicationContext(), Favorites.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
