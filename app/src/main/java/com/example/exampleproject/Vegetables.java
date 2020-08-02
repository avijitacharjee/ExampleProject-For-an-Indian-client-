package com.example.exampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Vegetables extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.example.exampleproject.EXTRA_TEXT";
    public static String text = "tomato";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);

        Button button1 = findViewById(R.id.tomato);
        Button button2 = findViewById(R.id.potato);
        Button button3 = findViewById(R.id.onion);
        Button button4 = findViewById(R.id.carrot);
        Button button5 = findViewById(R.id.cabbage);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tomato();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                potato();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onion();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carrot();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cabbage();
            }
        });

    }

    public void tomato() {
        text = "tomato";
        Intent intent = new Intent(this, Vegetables2.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
    public void potato() {
        text = "potato";
        Intent intent = new Intent(this, Vegetables2.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
    public void onion() {
        text = "onion";
        Intent intent = new Intent(this, Vegetables2.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
    public void carrot() {
        text = "carrot";
        Intent intent = new Intent(this, Vegetables2.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
    public void cabbage() {
        text = "cabbage";
        Intent intent = new Intent(this, Vegetables2.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
}
