package bibliotecaDeJocuri;

import java.io.IOException;
import java.util.Scanner;


public class TemaFisier {
    public static void main(String[] args) throws IOException {
        Scanner key = new Scanner(System.in);
        Biblioteca b2 = new Biblioteca();
        while (true) {
            System.out.println(" ");
            System.out.println("Meniu principal :");
            System.out.println("1 - Afisare si incarcare fisier");
            System.out.println("2 - Adaugare produs");
            System.out.println("3 - Stergere produs");
            System.out.println("4 - Salvare in fisier");
            System.out.println("5 - Citire fisier");
            System.out.println("6 - Iesire din meniu");
            System.out.println("Introduceti comanda :");
            String comanda = key.nextLine();
            while (b2.verificareValoareInt(comanda) == false) {
                System.out.println("Comanda invalida. Introdu din nou :");
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
                while (b2.verificareValoareInt(tipProdus) == false) {
                    System.out.println("Comanda invalida. Introdu din nou :");
                    tipProdus = key.nextLine();
                }
                int tipProdus2 = Integer.parseInt(tipProdus);
                if (tipProdus2 == 1) {
                    System.out.println("Ai ales sa introduci un film.");
                    Filme f = new Filme();
                    System.out.println("Introdu numele filmului :");
                    String nume = key.nextLine();
                    while (b2.verificareValoareString(nume) == false) {
                        System.out.println("Comanda invalida. Introdu din nou :");
                        nume = key.nextLine();
                    }
                    f.setNume(nume);
                    System.out.println("Introdu pretul filmului :");
                    String pret = key.nextLine();
                    while (b2.verificareValoareDouble(pret) == false) {
                        System.out.println("Comanda invalida. Introdu din nou :");
                        pret = key.nextLine();
                    }
                    double pret2 = Double.parseDouble(pret);
                    f.setPret(pret2);
                    System.out.println("Introdu data de lansare a filmului :");
                    String date = key.nextLine();
                    while (b2.verificareValoareString(date) == false) {
                        System.out.println("Comanda invalida. Introdu din nou :");
                        date = key.nextLine();
                    }
                    f.setDate(date);
                    int test2 = 1;
                    while (test2 == 1) {
                        System.out.println("Introdu numele actorului :");
                        String aNume = key.nextLine();
                        while (b2.verificareValoareString(aNume) == false) {
                            System.out.println("Comanda invalida. Introdu din nou :");
                            aNume = key.nextLine();
                        }
                        System.out.println("Introdu prenumele actorului :");
                        String aPrenume = key.nextLine();
                        while (b2.verificareValoareString(aPrenume) == false) {
                            System.out.println("Comanda invalida. Introdu din nou :");
                            aPrenume = key.nextLine();
                        }
                        System.out.println("Introdu cnp-ul actorului :");
                        String aCnp = key.nextLine();
                        while (b2.verificareValoareString(aCnp) == false) {
                            System.out.println("Comanda invalida. Introdu din nou :");
                            aCnp = key.nextLine();
                        }
                        Actori a = new Actori(aNume, aPrenume, aCnp);
                        System.out.println("Introduceti varsta actorului :");
                        String varsta = key.nextLine();
                        while (b2.verificareValoareInt(varsta) == false) {
                            System.out.println("Comanda invalida. Introdu din nou :");
                            varsta = key.nextLine();
                        }
                        int varsta2 = Integer.parseInt(tipProdus);
                        a.setVarsta(varsta2);
                        f.getActori().add(a);
                        System.out.println("Vrei sa mai introduci un actor?");
                        System.out.println("1 - Da");
                        System.out.println("2 - Nu");
                        String test = key.nextLine();
                        while (b2.verificareValoareInt(test) == false) {
                            System.out.println("Comanda invalida. Introdu din nou :");
                            test = key.nextLine();
                        }
                        test2 = Integer.parseInt(test);
                    }
                    System.out.println("Introdu genul filmului :");
                    String gender = key.nextLine();
                    while (b2.verificareValoareString(gender) == false) {
                        System.out.println("Comanda invalida. Introdu din nou :");
                        gender = key.nextLine();
                    }
                    f.setGender(gender);
                    System.out.println("Introdu durata filmului :");
                    String durata = key.nextLine();
                    while (b2.verificareValoareDouble(durata) == false) {
                        System.out.println("Comanda invalida. Introdu din nou :");
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
                    while (b2.verificareValoareString(nume) == false) {
                        System.out.println("Comanda invalida. Introdu din nou :");
                        nume = key.nextLine();
                    }
                    j.setNume(nume);
                    System.out.println("Introdu pretul jocului :");
                    String pret = key.nextLine();
                    while (b2.verificareValoareDouble(pret) == false) {
                        System.out.println("Comanda invalida. Introdu din nou :");
                        pret = key.nextLine();
                    }
                    double pret2 = Double.parseDouble(pret);
                    j.setPret(pret2);
                    System.out.println("Introdu data de lansare a jocului :");
                    String date = key.nextLine();
                    while (b2.verificareValoareString(date) == false) {
                        System.out.println("Comanda invalida. Introdu din nou :");
                        date = key.nextLine();
                    }
                    j.setDate(date);
                    System.out.println("Introdu tipul jocului :");
                    String tipJoc = key.nextLine();
                    while (b2.verificareValoareString(tipJoc) == false) {
                        System.out.println("Comanda invalida. Introdu din nou :");
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
                    while (b2.verificareValoareString(nume) == false) {
                        System.out.println("Comanda invalida. Introdu din nou :");
                        nume = key.nextLine();
                    }
                    c.setNume(nume);
                    System.out.println("Introdu pretul cartii :");
                    String pret = key.nextLine();
                    while (b2.verificareValoareDouble(pret) == false) {
                        System.out.println("Comanda invalida. Introdu din nou :");
                        pret = key.nextLine();
                    }
                    double pret2 = Double.parseDouble(pret);
                    c.setPret(pret2);
                    System.out.println("Introdu data de lansare a cartii :");
                    String date = key.nextLine();
                    while (b2.verificareValoareString(date) == false) {
                        System.out.println("Comanda invalida. Introdu din nou :");
                        date = key.nextLine();
                    }
                    c.setDate(date);
                    System.out.println("Introdu numarul de carti :");
                    String nrCarti = key.nextLine();
                    while (b2.verificareValoareInt(nrCarti) == false) {
                        System.out.println("Comanda invalida. Introdu din nou :");
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
                while (b2.verificareValoareString(numeProdus) == false) {
                    System.out.println("Comanda invalida. Introdu din nou :");
                    numeProdus = key.nextLine();
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
                System.out.println("Comanda nu exista. Introdu din nou comanda.");
            }
        }
    }


}
