package com.oksana.trubina.weather_for_wizards;

import java.io.Serializable;

final class ParcelFirst implements Serializable {

//    Resources res = Resources.getSystem(); не работает со статикой :(

    final static Integer[] characters = {
            R.string.evilMagician, R.string.kindMagician, R.string.witch};
    final static Integer[] charactersTitle = {
            R.string.evilMagicianTitle, R.string.kindMagicianTitle, R.string.witchTitle};
    final static Integer[] charactersImage = {
            R.drawable.character_evil_magician, R.drawable.character_kind_magician,
            R.drawable.character_witch};
    final static Integer[] charactersTheme = {
            R.style.ThemeEvil, R.style.ThemeKind, R.style.ThemeWitch};

    public static final String PARCEL_CHARACTER = "parcelCharacter";
    private final int idOfCharacter;


    public ParcelFirst(int idOfCharacter) {
        this.idOfCharacter = idOfCharacter;
    }



    int getIdOfCharacter() {
        return idOfCharacter;
    }

}
//        int[] arrayBackgrounds = getResources().getIntArray(R.array.backgroundsImage);
//
//        Integer[] backgroundForWizard = new Integer[arrayBackgrounds.length];
//        int i = 0;
//        for (int value : arrayBackgrounds) {
//            backgroundForWizard[i++] = value;
//        }