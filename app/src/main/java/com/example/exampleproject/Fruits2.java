package com.example.exampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Fruits2 extends AppCompatActivity {

    @SuppressLint({"SetTextI18n", "ResourceType"})

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits2);

        Intent intent = getIntent();
        String text = intent.getStringExtra(Fruits.EXTRA_TEXT);

        TextView title = findViewById(R.id.title);
        TextView info = findViewById(R.id.info);

        assert text != null;
        switch (text) {
            case "apple":
                title.setText("Apple");
                info.setText("An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today.");
                break;
            case "mango":
                title.setText("Mango");
                info.setText("A mango is a juicy stone fruit produced from numerous species of tropical trees belonging to the flowering plant genus Mangifera, cultivated mostly for their edible fruit. Most of these species are found in nature as wild mangoes. The genus belongs to the cashew family Anacardiaceae.");
                break;
            case "banana":
                title.setText("Banana");
                info.setText("A banana is an elongated, edible fruit – botanically a berry – produced by several kinds of large herbaceous flowering plants in the genus Musa. In some countries, bananas used for cooking may be called \"plantains\", distinguishing them from dessert bananas.");
                break;
            case "grapes":
                title.setText("Grapes");
                info.setText("A grape is a fruit, botanically a berry, of the deciduous woody vines of the flowering plant genus Vitis. Grapes can be eaten fresh as table grapes or they can be used for making wine, jam, grape juice, jelly, grape seed extract, raisins, vinegar, and grape seed oil.");
                break;
            case "guava":
                title.setText("Guava");
                info.setText("Guava is a common tropical fruit cultivated in many tropical and subtropical regions. Psidium guajava is a small tree in the myrtle family, native to Mexico, Central America, the Caribbean and northern South America.");
                break;
        }
    }
}
