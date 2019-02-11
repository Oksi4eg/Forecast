//package com.oksana.trubina.weather_for_wizards;
//
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class FragmentPlacesListAdapter  extends RecyclerView.Adapter <FragmentPlacesListAdapter.PlaceViewHolder>{
//
//
//    private final String[] places;
//    private FragmentPlacesList.OnClick onClickListener;
//
//    FragmentPlacesListAdapter(String[] places, FragmentPlacesList.OnClick onClickListener) {
//        this.places = places;
//        this.onClickListener = onClickListener;
//    }
//
////    @NonNull
////    @Override
////    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
////        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_view_item, viewGroup, false);
////        PlaceViewHolder placeViewHolder = new PlaceViewHolder(textView);
////        return placeViewHolder;
////    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PlaceViewHolder cityViewHolder, int i) {
//        cityViewHolder.textView.setText(places[i]);
//    }
//
//    @Override
//    public int getItemCount() {
//        return places.length;
//    }
//
//
//    class PlaceViewHolder extends RecyclerView.ViewHolder {
//
//        TextView textView;
//
//        PlaceViewHolder(@NonNull final TextView textView) {
//            super(textView);
//            this.textView = textView;
//            this.textView.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(textView.getContext(), "position " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
//                    onClickListener.onListItemClick(getLayoutPosition(), places[getLayoutPosition()]);
//                }
//            });
//        }
//    }
//}
//
//доделать)