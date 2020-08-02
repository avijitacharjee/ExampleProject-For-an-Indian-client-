package com.example.exampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Vegetables2 extends AppCompatActivity {
    private static final String TAG = "Fruits";
    AppDatabase database;

    @SuppressLint({"SetTextI18n", "ResourceType"})

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables2);
        database = new AppDatabase(this);
        Intent intent = getIntent();
        final String text = intent.getStringExtra(Vegetables.EXTRA_TEXT);

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
                    Toast.makeText(Vegetables2.this, "Added to favorites", Toast.LENGTH_SHORT).show();
                }
                else {
                    buttonView.setButtonDrawable(R.drawable.ic_favorite_default);
                    database.delete(text);
                    Toast.makeText(Vegetables2.this, "Removed from favorites", Toast.LENGTH_SHORT).show();
                }
                Log.d(TAG, "onCheckedChanged: "+database.getData());
            }
        });


        assert text != null;
        switch (text) {
            case "tomato":
                title.setText("Tomato");
                info.setText("Tomatoes are fruits that are considered vegetables by nutritionists. Botanically, a fruit is a ripened flower ovary and contains seeds. ... Thus, roots, tubers, stems, flower buds, leaves, and certain botanical fruits, including green beans, pumpkins, and of course tomatoes, are all considered vegetables by nutritionists.");
                break;
            case "potato":
                title.setText("Potato");
                info.setText("A potato is a root vegetable, the Solanum tuberosum. It is a small plant with large leaves. The part of the potato that people eat is a tuber that grows under the ground. A potato contains a lot of starch and other carbohydrates.");
                break;
            case "onion":
                title.setText("Onion");
                info.setText("The onion (Allium cepa L., from Latin cepa \"onion\"), also known as the bulb onion or common onion, is a vegetable that is the most widely cultivated species of the genus Allium. Its close relatives include the garlic, scallion, shallot, leek, chive, and Chinese onion.");
                break;
            case "carrot":
                title.setText("Carrot");
                info.setText("The carrot (Daucus carota subsp. sativus) is a root vegetable, usually orange in colour, though purple, black, red, white, and yellow cultivars exist. ... The carrot is a biennial plant in the umbellifer family Apiaceae. At first, it grows a rosette of leaves while building up the enlarged taproot.");
                break;
            case "cabbage":
                title.setText("Cabbage");
                info.setText("Cabbage (comprising several cultivars of Brassica oleracea) is a leafy green, red (purple), or white (pale green) biennial plant grown as an annual vegetable crop for its dense-leaved heads. It is descended from the wild cabbage (B. oleracea var. ... Cabbage weights generally range from 500 to 1,000 grams (1 to 2 lb).");
                break;
        }
    }
}
