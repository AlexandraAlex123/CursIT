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
            String comanda = controlComanda(b2, key);
            int comanda2 = Integer.parseInt(comanda);
            if (comanda2 == 1) {
                System.out.println("Lista de produse initiala :");
                b2.loadingProduse(b2);
            } else if (comanda2 == 2) {
                System.out.println("Alege tipul de produs pe care vrei sa il introduci :");
                System.out.println("1 - Film");
                System.out.println("2 - Joc");
                System.out.println("3 - Carte");
                String tipProdus = controlComanda(b2, key);
                int tipProdus2 = Integer.parseInt(tipProdus);
                if (tipProdus2 == 1) {
                    System.out.println("Ai ales sa introduci un film.");
                    Filme f = new Filme();
                    System.out.println("Introdu numele filmului :");
                    String nume = controlFilm(b2, key);
                    f.setNume(nume);
                    System.out.println("Introdu pretul filmului :");
                    String pret = controlStringIntrodusD(b2, key);
                    double pret2 = Double.parseDouble(pret);
                    f.setPret(pret2);
                    System.out.println("Introdu data de lansare a filmului :");
                    String date = controlStringIntrodusS(b2, key);
                    f.setDate(date);
                    String test = "Da";
                    while (test.equals("Da")) {
                        System.out.println("Introdu numele actorului :");
                        String aNume = controlStringIntrodusS(b2, key);
                        System.out.println("Introdu prenumele actorului :");
                        String aPrenume = controlStringIntrodusS(b2, key);
                        System.out.println("Introdu cnp-ul actorului :");
                        String aCnp = controlStringIntrodusS(b2, key);
                        Actori a = new Actori(aNume, aPrenume, aCnp);
                        System.out.println("Introduceti varsta actorului :");
                        String varsta = controlStringIntrodusI(b2, key);
                        int varsta2 = Integer.parseInt(varsta);
                        a.setVarsta(varsta2);
                        f.getActori().add(a);
                        System.out.println("Actorul a fost adaugat.");
                        System.out.println("Vrei sa mai introduci un actor?");
                        System.out.println("Da");
                        System.out.println("Nu");
                        test = controlActori(key);
                    }
                    System.out.println("Introdu genul filmului :");
                    String gender = controlStringIntrodusS(b2, key);
                    f.setGender(gender);
                    System.out.println("Introdu durata filmului :");
                    String durata = controlStringIntrodusD(b2, key);
                    double durata2 = Double.parseDouble(durata);
                    f.setDurata(durata2);
                    b2.addProdus(f);
                    System.out.println("Filmul a fost adaugat.");
                } else if (tipProdus2 == 2) {
                    System.out.println("Ai ales sa introduci un joc.");
                    Jocuri j = new Jocuri();
                    System.out.println("Introdu numele jocului :");
                    String nume = controlJoc(b2, key);
                    j.setNume(nume);
                    System.out.println("Introdu pretul jocului :");
                    String pret = controlStringIntrodusD(b2, key);
                    double pret2 = Double.parseDouble(pret);
                    j.setPret(pret2);
                    System.out.println("Introdu data de lansare a jocului :");
                    String date = controlStringIntrodusS(b2, key);
                    j.setDate(date);
                    System.out.println("Introdu tipul jocului :");
                    String tipJoc = controlStringIntrodusS(b2, key);
                    j.setTipDeJoc(tipJoc);
                    b2.addProdus(j);
                    System.out.println("Jocul a fost adaugat.");
                } else if (tipProdus2 == 3) {
                    System.out.println("Ai ales sa introduci o carte.");
                    Carti c = new Carti();
                    System.out.println("Introdu numele cartii :");
                    String nume = controlCarte(b2, key);
                    c.setNume(nume);
                    System.out.println("Introdu pretul cartii :");
                    String pret = controlStringIntrodusD(b2, key);
                    double pret2 = Double.parseDouble(pret);
                    c.setPret(pret2);
                    System.out.println("Introdu data de lansare a cartii :");
                    String date = controlStringIntrodusS(b2, key);
                    c.setDate(date);
                    System.out.println("Introdu numarul de carti :");
                    String nrCarti = controlStringIntrodusI(b2, key);
                    int nrCarti2 = Integer.parseInt(nrCarti);
                    c.setNrCarti(nrCarti2);
                    b2.addProdus(c);
                    System.out.println("Cartea a fost adaugata.");
                }
            } else if (comanda2 == 3) {
                System.out.println("Numele produsului pe care vrei sa-l stergi :");
                String numeProdus = controlRemove(b2, key);
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

    static String controlJoc(Biblioteca b2, Scanner key) {
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
        return nume;
    }

    static String controlCarte(Biblioteca b2, Scanner key) {
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
        return nume;
    }

    static String controlFilm(Biblioteca b2, Scanner key) {
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
        return nume;
    }

    static String controlRemove(Biblioteca b2, Scanner key) {
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
        return numeProdus;
    }

    static String controlComanda(Biblioteca b2, Scanner key) {
        String comanda = key.nextLine();
        while (b2.controlInt(comanda)) {
            System.out.println("Comanda invalida. Reintrodu comanda :");
            comanda = key.nextLine();
        }
        return comanda;
    }

    static String controlStringIntrodusD(Biblioteca b2, Scanner key) {
        String word = key.nextLine();
        while (b2.controlDouble(word)) {
            System.out.println("Comanda invalida. Reintrodu :");
            word = key.nextLine();
        }
        return word;
    }

    static String controlActori(Scanner key) {
        String test = key.nextLine();
        while (!Objects.equals(test, "Da") && !Objects.equals(test, "Nu")) {
            System.out.println("Comanda nu exista. Reintrodu comanda :");
            test = key.nextLine();
        }
        return test;
    }

    static String controlStringIntrodusI(Biblioteca b2, Scanner key) {
        String word = key.nextLine();
        while (b2.controlInt(word)) {
            System.out.println("Comanda invalida. Reintrodu :");
            word = key.nextLine();
        }
        return word;
    }

    static String controlStringIntrodusS(Biblioteca b2, Scanner key) {
        String word = key.nextLine();
        while (b2.controlString(word)) {
            System.out.println("Comanda invalida. Reintrodu :");
            word = key.nextLine();
        }
        return word;
    }
}
