package bibliotecaDeJocuri;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class TemaFisier {
    public static void main(String[] args) throws IOException {
        Scanner key = new Scanner(System.in);
        Biblioteca b2 = new Biblioteca();
        while (true) {
            System.out.println(" ");
            System.out.println("Meniu principal :");
            System.out.println("1 - Afisare si incarcare fisier.");
            System.out.println("2 - Adaugare produs.");
            System.out.println("3 - Stergere produs.");
            System.out.println("4 - Salvare in fisier.");
            System.out.println("5 - Citire din fisier.");
            System.out.println("6 - Iesire din meniu.");
            System.out.println("Introduceti comanda :");
            String comanda = key.nextLine();
            while (b2.controlInt(comanda)) {
                System.out.println("Comanda invalida. Reintrodu comanda :");
                comanda = key.nextLine();
            }
            int comanda2 = Integer.parseInt(comanda);
            if (comanda2 == 1) {
                System.out.println("Lista de produse initiala :");
                b2.afisareProduse(b2);
            } else if (comanda2 == 2) {
                System.out.println("Alege tipul de produs pe care vrei sa il introduci :");
                System.out.println("1 - Film");
                System.out.println("2 - Joc");
                System.out.println("3 - Carte");
                String tipProdus = key.nextLine();
                while (b2.controlInt(tipProdus)) {
                    System.out.println("Comanda invalida. Reintrodu comanda :");
                    tipProdus = key.nextLine();
                }
                int tipProdus2 = Integer.parseInt(tipProdus);
                if (tipProdus2 == 1) {
                    System.out.println("Ai ales sa introduci un film.");
                    Filme f = new Filme();
                    System.out.println("Introdu numele filmului :");
                    String nume = key.nextLine();
                    while (b2.controlString(nume) || b2.controlDublura(nume)) {
                        if (b2.controlString(nume)) {
                            System.out.println("Comanda invalida. Reintrodu numele filmului :");
                            nume = key.nextLine();
                        } else if (b2.controlDublura(nume)) {
                            System.out.println("Acest film exista. Reintrodu numele filmului");
                            nume = key.nextLine();
                        }
                    }
                    f.setNume(nume);
                    System.out.println("Introdu pretul filmului :");
                    String pret = key.nextLine();
                    while (b2.controlDouble(pret)) {
                        System.out.println("Comanda invalida. Reintrodu pretul fimului :");
                        pret = key.nextLine();
                    }
                    double pret2 = Double.parseDouble(pret);
                    f.setPret(pret2);
                    System.out.println("Introdu data de lansare a filmului :");
                    String date = key.nextLine();
                    while (b2.controlString(date)) {
                        System.out.println("Comanda invalida. Reintrodu data de lansare a filmului :");
                        date = key.nextLine();
                    }
                    f.setDate(date);
                    String test = "Da";
                    while (test.equals("Da")) {
                        System.out.println("Introdu numele actorului :");
                        String aNume = key.nextLine();
                        while (b2.controlString(aNume)) {
                            System.out.println("Comanda invalida. Reintrodu numele actorului :");
                            aNume = key.nextLine();
                        }
                        System.out.println("Introdu prenumele actorului :");
                        String aPrenume = key.nextLine();
                        while (b2.controlString(aPrenume)) {
                            System.out.println("Comanda invalida. Reintrodu prenumele actorului :");
                            aPrenume = key.nextLine();
                        }
                        System.out.println("Introdu cnp-ul actorului :");
                        String aCnp = key.nextLine();
                        while (b2.controlString(aCnp)) {
                            System.out.println("Comanda invalida. Reintrodu cnp-ul actorului :");
                            aCnp = key.nextLine();
                        }
                        Actori a = new Actori(aNume, aPrenume, aCnp);
                        System.out.println("Introduceti varsta actorului :");
                        String varsta = key.nextLine();
                        while (b2.controlInt(varsta)) {
                            System.out.println("Comanda invalida. Reintrodu varsta actorului :");
                            varsta = key.nextLine();
                        }
                        int varsta2 = Integer.parseInt(tipProdus);
                        a.setVarsta(varsta2);
                        f.getActori().add(a);
                        System.out.println("Vrei sa mai introduci un actor?");
                        System.out.println("Da");
                        System.out.println("Nu");
                        test = key.nextLine();
                        while (!Objects.equals(test, "Da") && !Objects.equals(test, "Nu")) {
                            System.out.println("Comanda nu exista. Reintrodu comanda :");
                            test = key.nextLine();
                        }
                    }
                    System.out.println("Introdu genul filmului :");
                    String gender = key.nextLine();
                    while (b2.controlString(gender)) {
                        System.out.println("Comanda invalida. Reintrodu genul filmului :");
                        gender = key.nextLine();
                    }
                    f.setGender(gender);
                    System.out.println("Introdu durata filmului :");
                    String durata = key.nextLine();
                    while (b2.controlDouble(durata)) {
                        System.out.println("Comanda invalida. Reintrodu durata filmului :");
                        durata = key.nextLine();
                    }
                    double durata2 = Double.parseDouble(durata);
                    f.setDurata(durata2);
                    b2.addProdus(f);
                    System.out.println("Filmul a fost adaugat.");
                } else if (tipProdus2 == 2) {
                    System.out.println("Ai ales sa introduci un joc.");
                    Jocuri j = new Jocuri();
                    System.out.println("Introdu numele jocului :");
                    String nume = key.nextLine();
                    while (b2.controlString(nume) || b2.controlDublura(nume)) {
                        if (b2.controlString(nume)) {
                            System.out.println("Comanda invalida. Reintrodu numele jocului :");
                            nume = key.nextLine();
                        } else if (b2.controlDublura(nume)) {
                            System.out.println("Acest joc exista. Reintrodu numele jocului :");
                            nume = key.nextLine();
                        }
                    }
                    j.setNume(nume);
                    System.out.println("Introdu pretul jocului :");
                    String pret = key.nextLine();
                    while (b2.controlDouble(pret)) {
                        System.out.println("Comanda invalida. Reintrodu pretul jocului :");
                        pret = key.nextLine();
                    }
                    double pret2 = Double.parseDouble(pret);
                    j.setPret(pret2);
                    System.out.println("Introdu data de lansare a jocului :");
                    String date = key.nextLine();
                    while (b2.controlString(date)) {
                        System.out.println("Comanda invalida. Reintrodu data de lansare a jocului :");
                        date = key.nextLine();
                    }
                    j.setDate(date);
                    System.out.println("Introdu tipul jocului :");
                    String tipJoc = key.nextLine();
                    while (b2.controlString(tipJoc)) {
                        System.out.println("Comanda invalida. Reintrodu tipul jocului :");
                        tipJoc = key.nextLine();
                    }
                    j.setTipDeJoc(tipJoc);
                    b2.addProdus(j);
                    System.out.println("Jocul a fost adaugat.");
                } else if (tipProdus2 == 3) {
                    System.out.println("Ai ales sa introduci o carte.");
                    Carti c = new Carti();
                    System.out.println("Introdu numele cartii :");
                    String nume = key.nextLine();
                    while (b2.controlString(nume) || b2.controlDublura(nume)) {
                        if (b2.controlString(nume)) {
                            System.out.println("Comanda invalida. Reintrou numele cartii :");
                            nume = key.nextLine();
                        } else if (b2.controlDublura(nume)) {
                            System.out.println("Acesta carte exista. Reintrodu numele cartii :");
                            nume = key.nextLine();
                        }
                    }
                    c.setNume(nume);
                    System.out.println("Introdu pretul cartii :");
                    String pret = key.nextLine();
                    while (b2.controlDouble(pret)) {
                        System.out.println("Comanda invalida. Reintrodu pretu cartii :");
                        pret = key.nextLine();
                    }
                    double pret2 = Double.parseDouble(pret);
                    c.setPret(pret2);
                    System.out.println("Introdu data de lansare a cartii :");
                    String date = key.nextLine();
                    while (b2.controlString(date)) {
                        System.out.println("Comanda invalida. Reintrodu data de lansare a cartii :");
                        date = key.nextLine();
                    }
                    c.setDate(date);
                    System.out.println("Introdu numarul de carti :");
                    String nrCarti = key.nextLine();
                    while (b2.controlInt(nrCarti)) {
                        System.out.println("Comanda invalida. Reintrodu numarul de carti :");
                        nrCarti = key.nextLine();
                    }
                    int nrCarti2 = Integer.parseInt(tipProdus);
                    c.setNrCarti(nrCarti2);
                    b2.addProdus(c);
                    System.out.println("Cartea a fost adaugata.");
                }
            } else if (comanda2 == 3) {
                System.out.println("Numele produsului pe care vrei sa-l stergi :");
                String numeProdus = key.nextLine();
                while (b2.controlString(numeProdus) || !b2.controlDublura(numeProdus)) {
                    if (b2.controlString(numeProdus)) {
                        System.out.println("Comanda invalida. Reintrodu numele produsului pe care vrei sa-l stegi :");
                        numeProdus = key.nextLine();
                    } else if (!b2.controlDublura(numeProdus)) {
                        System.out.println("Acest produs nu exista. Reintrodu numele produsului pe care vrei sa-l stergi :");
                        numeProdus = key.nextLine();
                    }
                }
                b2.removeProdus(numeProdus);
                System.out.println("Produsul a fost sters.");
            } else if (comanda2 == 4) {
                b2.salvareFisier();
                System.out.println("Modificarile au fost salvate.");
            } else if (comanda2 == 5) {
                System.out.println("Lista de produse actualizata :");
                b2.citireFisier();
            } else if (comanda2 == 6) {
                break;
            } else {
                System.out.println("Comanda nu exista. Reintrodu comanda.");
            }
        }
    }
}
