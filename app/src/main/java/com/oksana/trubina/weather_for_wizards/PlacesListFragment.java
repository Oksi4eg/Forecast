package com.oksana.trubina.weather_for_wizards;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class PlacesListFragment extends Fragment {
    private boolean isExistPlaceInfo;
    private Parcel currentParcel;


    // При создании фрагмента, укажем его макет
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_places_list, container, false);
    }

    private OnClick onClickListener = new OnClick() {
        @Override
        public void onListItemClick(int position, String place) {
            Toast.makeText(getContext(), "tag " + position, Toast.LENGTH_SHORT).show();
            currentParcel = new Parcel(position, place);
            showPlaceInfo(currentParcel);
        }
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] places = getActivity().getResources().getStringArray(R.array.places);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_places);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        PlacesAdaptor adapter = new PlacesAdaptor(places, onClickListener);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isExistPlaceInfo = getActivity().findViewById(R.id.fragment_place_info) != null;

        if (savedInstanceState != null) {
            currentParcel = (Parcel) savedInstanceState.getSerializable("CurrentPlace");
        } else {
            currentParcel = new Parcel(0, getResources().getTextArray(R.array.places)[0].toString());
        }

        if (isExistPlaceInfo) {
            showPlaceInfo(currentParcel);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("CurrentPlace", currentParcel);
    }


    private void showPlaceInfo(Parcel parcel) {
        if (isExistPlaceInfo) {

            PlaceInfoFragment placeInfoFragment = (PlaceInfoFragment)
                    getFragmentManager().findFragmentById(R.id.fragment_place_info);

            if (placeInfoFragment == null || placeInfoFragment.getParcel().getIdOfPlace() != parcel.getIdOfPlace()) {

                placeInfoFragment = PlaceInfoFragment.init(parcel);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_place_info, placeInfoFragment);
                ft.commit();
            }
        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), PlaceInfoActivity.class);
            intent.putExtra(Parcel.PARCEL_PLACE, parcel);
            startActivity(intent);
        }
    }

    interface OnClick {

        void onListItemClick(int position, String place);
    }

}
