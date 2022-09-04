package bibliotecaDeJocuri;

import java.util.ArrayList;

public class Filme extends Produse {

    private String gender;

    private double durata;


    private ArrayList<Actori> actor = new ArrayList<>();


    public ArrayList<Actori> getActor() {
        return actor;
    }


    public void setActor(ArrayList<Actori> actor) {
        this.actor = actor;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender ;
    }

    public double getDurata() {
        return durata;
    }

    public void setDurata(double durata) {
        this.durata = durata;
    }

    public ArrayList<Actori> getActori() {
        return actor;
    }

    public void setActori(ArrayList<Actori> actor) {
        this.actor = actor;
    }

    //overriding
//    public String getNume() {
//        return nume.toUpperCase();
//    }

    public String toString() {
        return "Film;" + this.nume + ";" + this.pret + ";" + this.date + ";" + actor.toString() + ";" + this.durata + ";" + this.gender + " ";
    }

}