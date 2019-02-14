package com.oksana.trubina.weather_for_wizards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMap extends AppCompatActivity implements View.OnClickListener {

    public static int currentParcelCharacter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentParcelCharacter = (int) getIntent().getIntExtra(ParcelCharacter.PARCEL_CHARACTER,
                currentParcelCharacter);
        setTheme(ParcelCharacter.charactersTheme[currentParcelCharacter]);
        setContentView(R.layout.activity_main_map);
        TextView t = findViewById(R.id.title_for_wizard);
        t.setText(ParcelCharacter.charactersTitle[currentParcelCharacter]);

        Button b = findViewById(R.id.button_choose_place);
        b.setOnClickListener(this);
    }

    public void onClick (View v){
        Intent intent = new Intent(MainMap.this, SecondActivity.class);
        intent.putExtra(ParcelCharacter.PARCEL_CHARACTER, currentParcelCharacter);
        startActivity(intent);

    }

}
