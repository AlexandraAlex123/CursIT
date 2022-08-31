package bibliotecaDeJocuri;

import java.io.IOException;
import java.util.Scanner;


public class TemaFisier {
    public static void main(String[] args) throws IOException {
        Scanner key = new Scanner(System.in);
        Biblioteca b2 = new Biblioteca();
        while (true){
            System.out.println(" ");
            System.out.println("Meniu principal :");
            System.out.println("1 - Afisare si incarcare fisier");
            System.out.println("2 - Adaugare produs");
            System.out.println("3 - Stergere produs");
            System.out.println("4 - Salvare in fisier");
            System.out.println("5 - Citire fisier");
            System.out.println("6 - Iesire din meniu");
            System.out.println("Introduceti comanda :");
            int comanda = key.nextInt();
            if(comanda == 1){
                System.out.println("Lista de produse initiala :");
                b2.afisareProduse(b2);
            }else if(comanda == 2){
                System.out.println("Alege tipul de produs pe care vrei sa il introduci :");
                System.out.println("1 - Film");
                System.out.println("2 - Joc");
                System.out.println("3 - Carte");
                int tipProdus = key.nextInt();
                if (tipProdus == 1) {
                    Filme f = new Filme();
                    System.out.println("Introdu numele filmului :");
                    String nume = key.nextLine();
                    f.setNume(nume);
                    System.out.println("Introdu pretul filmului :");
                    String pret = key.nextLine();
                    double pret2 = Double.parseDouble(pret);
                    f.setPret(pret2);
                    System.out.println("Introdu data de lansare a filmului :");
                    String date = key.nextLine();
                    f.setDate(date);
                    System.out.println("Introdu numele actorului :");
                    String aNume = key.nextLine();
                    System.out.println("Introdu prenumele actorului :");
                    String aPrenume = key.nextLine();
                    System.out.println("Introdu cnp-ul actorului :");
                    String aCnp = key.nextLine();
                    Actori a = new Actori(aNume, aPrenume, aCnp);
                    f.getActori().add(a);
                    System.out.println("Introdu genul filmului :");
                    String gender = key.next();
                    f.setGender(gender);
                    System.out.println("Introdu durata filmului :");
                    String durata = key.nextLine();
                    double durata2 = Double.parseDouble(durata);
                    f.setDurata(durata2);
                    b2.addProdus(f);
                } else if (tipProdus == 2) {
                    Jocuri j = new Jocuri();
                    System.out.println("Introdu numele jocului :");
                    String nume = key.nextLine();
                    j.setNume(nume);
                    System.out.println("Introdu pretul jocului :");
                    String pret = key.nextLine();
                    double pret2 = Double.parseDouble(pret);
                    j.setPret(pret2);
                    System.out.println("Introdu data de lansare a jocului :");
                    String date = key.nextLine();
                    j.setDate(date);
                    System.out.println("Introdu tipul jocului :");
                    String tipJoc = key.nextLine();
                    j.setTipDeJoc(tipJoc);
                    b2.addProdus(j);
                } else if (tipProdus == 3) {
                    Carti c = new Carti();
                    System.out.println("Introdu numele cartii :");
                    String nume = key.nextLine();
                    c.setNume(nume);
                    System.out.println("Introdu pretul cartii :");
                    String pret = key.nextLine();
                    double pret2 = Double.parseDouble(pret);
                    c.setPret(pret2);
                    System.out.println("Introdu data de lansare a cartii :");
                    String date = key.nextLine();
                    c.setDate(date);
                    System.out.println("Introdu numarul de carti :");
                    String nrCarti = key.nextLine();
                    int nrCarti2 = Integer.parseInt(nrCarti);
                    c.setNrCarti(nrCarti2);
                    b2.addProdus(c);
                }
            }else if(comanda == 3){
                System.out.println("Numele produsului pe care vrei sa-l stergi :");
                String numeProdus = key.next();
                b2.removeProdus(numeProdus);
                System.out.println("Produsul a fost sters.");
            }else if(comanda == 4){
                b2.salvareFisier();
                System.out.println("Modificarile au fost salvate.");
            }else if(comanda == 5){
                System.out.println("Lista de produse actualizata :");
                b2.citireFisier();
            }else if(comanda == 6){
                break;
            }
        }
    }


}
