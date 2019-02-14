package com.oksana.trubina.weather_for_wizards;

import java.io.Serializable;

final class Parcel implements Serializable {


    //    вопросы для чекбоксов
    final static Integer[] evilCheckBoxes = {
            R.string.questionEvilFirst, R.string.questionEvilSecond};
    final static Integer[] kindCheckBoxes = {
            R.string.questionKindFirst, R.string.questionKindSecond};
    final static Integer[] witchCheckboxes = {
            R.string.questionWitchFirst, R.string.questionWitchSecond};

//    места

    final static Integer[] placesImage = {
            R.drawable.places_hogwarts, R.drawable.places_mordor, R.drawable.places_narnia};


    public static final String PARCEL_PLACE = "parcel";
    private final int idOfPlace;
    private final String nameOfPlace;


    public Parcel(int idOfPlace, String nameOfPlace) {

        this.idOfPlace = idOfPlace;
        this.nameOfPlace = nameOfPlace;

    }

    int getIdOfPlace() {
        return idOfPlace;
    }

    String getNameOfPlace() {
        return nameOfPlace;
    }
}
