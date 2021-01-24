package models;

public class Genere {
    private  String genere;

    public Genere(String genere) {
        this.genere = genere;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return  genere ;

    }
}
