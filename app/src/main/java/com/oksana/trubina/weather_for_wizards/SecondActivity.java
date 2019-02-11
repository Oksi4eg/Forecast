package com.oksana.trubina.weather_for_wizards;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    public static int currentParcelCharacter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentParcelCharacter = (int) getIntent().getIntExtra(ParcelFirst.PARCEL_CHARACTER,
                currentParcelCharacter);
        setTheme(ParcelFirst.charactersTheme[currentParcelCharacter]);
        setContentView(R.layout.second_activity);
    }
}
