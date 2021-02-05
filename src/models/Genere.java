package models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genere genere1 = (Genere) o;
        return Objects.equals(genere, genere1.genere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genere);
    }
}

