package com.oksana.trubina.weather_for_wizards;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class CharactersInfoFragment extends Fragment {

    public static int currentParcelCharacter = 0;

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(v.getContext(), MainMap.class);

            switch (v.getId()) {

                case R.id.button_character_first:
                    currentParcelCharacter = 0;
                    break;
                case R.id.button_character_second:
                    currentParcelCharacter = 1;
                    break;
                case R.id.button_character_third:
                    currentParcelCharacter = 2;
                    break;
                case R.id.image_character_first:
                    currentParcelCharacter = 0;
                    break;
                case R.id.image_character_second:
                    currentParcelCharacter = 1;
                    break;
                case R.id.image_character_third:
                    currentParcelCharacter = 2;
                    break;
            }
            intent.putExtra(ParcelCharacter.PARCEL_CHARACTER,currentParcelCharacter);
            startActivity(intent);
        }
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_characters_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.button_character_first);
        Button button2 = view.findViewById(R.id.button_character_second);
        Button button3 = view.findViewById(R.id.button_character_third);

        button.setText(ParcelCharacter.characters[0]);
        button2.setText(ParcelCharacter.characters[1]);
        button3.setText(ParcelCharacter.characters[2]);

        ImageView image = view.findViewById(R.id.image_character_first);
        ImageView image2 = view.findViewById(R.id.image_character_second);
        ImageView image3 = view.findViewById(R.id.image_character_third);

        image.setImageResource(ParcelCharacter.charactersImage[0]);
        image2.setImageResource(ParcelCharacter.charactersImage[1]);
        image3.setImageResource(ParcelCharacter.charactersImage[2]);


        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        image.setOnClickListener(onClickListener);
        image2.setOnClickListener(onClickListener);
        image3.setOnClickListener(onClickListener);
    }


}
