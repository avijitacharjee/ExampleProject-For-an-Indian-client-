package com.example.exampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fruits extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.example.exampleproject.EXTRA_TEXT";
    public static String text = "apple";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        Button button1 = findViewById(R.id.apple);
        Button button2 = findViewById(R.id.mango);
        Button button3 = findViewById(R.id.banana);
        Button button4 = findViewById(R.id.grapes);
        Button button5 = findViewById(R.id.guava);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apple();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mango();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                banana();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grapes();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guava();
            }
        });
    }

    public void apple() {
        text = "apple";
        Intent intent = new Intent(this, Fruits2.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
    public void mango() {
        text = "mango";
        Intent intent = new Intent(this, Fruits2.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
    public void banana() {
        text = "banana";
        Intent intent = new Intent(this, Fruits2.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
    public void grapes() {
        text = "grapes";
        Intent intent = new Intent(this, Fruits2.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
    public void guava() {
        text = "guava";
        Intent intent = new Intent(this, Fruits2.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
}
