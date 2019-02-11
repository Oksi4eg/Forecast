package com.oksana.trubina.weather_for_wizards;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentPlacesList extends Fragment {
    private Boolean isExistPlaceInfo;
    private Parcel currentParcel;
    private  Parcel currentCharacter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_places_list, container, false);

    }

    private void showPlaceInfo(Parcel parcel) {
        if (isExistPlaceInfo) {

            FragmentPlaceInfo fragmentPlaceInfo = (FragmentPlaceInfo)
                    getFragmentManager().findFragmentById(R.id.fragment_place_info);

            if (fragmentPlaceInfo == null || fragmentPlaceInfo.getParcel().getIdOfPlace() != currentParcel.getIdOfPlace()) {

                // Создаем новый фрагмент
                fragmentPlaceInfo = FragmentPlaceInfo.init(parcel);

                // Выполняем транзакцию по замене фрагмента
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_place_info, fragmentPlaceInfo);  // замена фрагмента
                ft.commit();
            }
        } else {
            // Если нельзя вывести рядом, откроем вторую активити
            Intent intent = new Intent();
            intent.setClass(getActivity(), SecondActivity.class);
            // и передадим туда параметры
            intent.putExtra(Parcel.PARCEL_CHARACTER_AND_PLACE, parcel);
            startActivity(intent);
        }
    }

    private OnClick onClickListener = new OnClick() {
        @Override
        public void onListItemClick(int currentCharacter, int position, String place) {
            currentParcel = new Parcel(currentCharacter, position, place);
            showPlaceInfo(currentParcel);
        }
    };

    interface OnClick {

        void onListItemClick(int currentCharacter, int position, String place);
    }


}
