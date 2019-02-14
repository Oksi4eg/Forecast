package com.oksana.trubina.weather_for_wizards;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


class PlacesAdaptor extends RecyclerView.Adapter<PlacesAdaptor.PlacesViewHolder> {

    private final String[] places;
    private PlacesListFragment.OnClick onClickListener;

    PlacesAdaptor(String[] places, PlacesListFragment.OnClick onClickListener) {
        this.places = places;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_view_item, viewGroup, false);
        PlacesViewHolder placesViewHolder = new PlacesViewHolder(textView);
        return placesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesViewHolder placesViewHolder, int i) {
        placesViewHolder.textView.setText(places[i]);
    }

    @Override
    public int getItemCount() {
        return places.length;
    }


    class PlacesViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        PlacesViewHolder(@NonNull final TextView textView) {
            super(textView);
            this.textView = textView;
            this.textView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    onClickListener.onListItemClick(getLayoutPosition(), places[getLayoutPosition()]);
                }
            });
        }
    }
}

