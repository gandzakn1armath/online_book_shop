package datebase;

import models.Genere;

import java.util.ArrayList;

public class GenereData {
    public static ArrayList<Genere> getGenereData(){
        ArrayList<Genere> genres = new ArrayList<>();
        genres.add(new Genere("Առակ"));
        genres.add(new Genere("Վեպ"));
        genres.add(new Genere("Արկածային"));
        genres.add(new Genere("Հեքիաթ"));
        genres.add(new Genere("Նովել"));

        return  genres;
    }
}
