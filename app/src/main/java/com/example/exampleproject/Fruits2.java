package com.example.exampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Fruits2 extends AppCompatActivity {
    private static final String TAG = "Fruits2";
    private AppDatabase database;

    @SuppressLint({"SetTextI18n", "ResourceType"})

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits2);
        database = new AppDatabase(this);
        Intent intent = getIntent();
        final String text = intent.getStringExtra(Fruits.EXTRA_TEXT);

        TextView title = findViewById(R.id.title);
        TextView info = findViewById(R.id.info);
        CheckBox stateCheckBox = findViewById(R.id.checkbox_favorite);
        List<String> favs = database.getData();
        if(favs.contains(text)){
            stateCheckBox.setButtonDrawable(R.drawable.ic_favorite_active);
            stateCheckBox.setChecked(!stateCheckBox.isChecked());
        }
        else {
            stateCheckBox.setButtonDrawable(R.drawable.ic_favorite_default);
        }
        stateCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    buttonView.setButtonDrawable(R.drawable.ic_favorite_active);
                    database.insertFavorite(text);
                    Toast.makeText(Fruits2.this, "Added to favorites", Toast.LENGTH_SHORT).show();
                }
                else {
                    buttonView.setButtonDrawable(R.drawable.ic_favorite_default);
                    database.delete(text);
                    Toast.makeText(Fruits2.this, "Removed from favorites", Toast.LENGTH_SHORT).show();
                }
                Log.d(TAG, "onCheckedChanged: "+database.getData());
            }
        });

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
