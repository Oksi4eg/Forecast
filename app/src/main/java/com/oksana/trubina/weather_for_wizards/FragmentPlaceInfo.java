package com.oksana.trubina.weather_for_wizards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class FragmentPlaceInfo extends Fragment {

    int temperature = new Random().nextInt(100) - 50;
    int wind = new Random().nextInt(20);
    String temperatureValue = String.valueOf(temperature + "°C");
    String windValue = String.valueOf(wind + " м/с");
    Integer[] yesNo = {R.string.yes,R.string.no};
    int yesNoRandom = new Random().nextInt(1);

    public static FragmentPlaceInfo init(Parcel parcel) {
        FragmentPlaceInfo f = new FragmentPlaceInfo();    // создание

        // передача параметра
        Bundle args = new Bundle();
        args.putSerializable(Parcel.PARCEL_CHARACTER_AND_PLACE, parcel);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_place_info, container, false);
        Parcel parcel = getParcel();

        TextView cityName = layout.findViewById(R.id.fragment_place_info_name);
        ImageView imageView = layout.findViewById(R.id.fragment_place_info_image);

        cityName.setText(parcel.getNameOfPlace());
        imageView.setImageResource(Parcel.placesImage[parcel.getIdOfPlace()]);

        TextView questionFirst = layout.findViewById(R.id.city_info_question_1);
        TextView questionSecond = layout.findViewById(R.id.city_info_question_2);
        int character = parcel.getIdOfCharacter();

        if(character==0){
            questionFirst.setText(Parcel.evilCheckBoxes[0]);
            questionSecond.setText(Parcel.evilCheckBoxes[1]);
        } else if (character==1) {
            questionFirst.setText(Parcel.kindCheckBoxes[0]);
            questionSecond.setText(Parcel.kindCheckBoxes[1]);
        } else {
            questionFirst.setText(Parcel.witchCheckboxes[0]);
            questionSecond.setText(Parcel.witchCheckboxes[1]);
        }
        TextView result1 = layout.findViewById(R.id.city_info_result_1);
        TextView result2 = layout.findViewById(R.id.city_info_result_2);
        TextView result3 = layout.findViewById(R.id.city_info_result_3);
        TextView result4 = layout.findViewById(R.id.city_info_result_4);

        result1.setText(yesNo[yesNoRandom]);
        result2.setText(yesNo[yesNoRandom]);
        result3.setText(temperatureValue);
        result4.setText(windValue);









        return layout;

    }

    public Parcel getParcel() {
        Parcel parcel = (Parcel) getArguments().getSerializable(Parcel.PARCEL_CHARACTER_AND_PLACE);
        return parcel;
    }


}