package bibliotecaDeJocuri;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    Jocuri[] joc = new Jocuri[3];
    Filme[] film;
    Carti[] carte;


    ArrayList<Produse> produs = new ArrayList<>();

    public ArrayList<Produse> getP() {
        return produs;
    }

    public void setP(ArrayList<Produse> p) {
        this.produs = p;
    }


    void addProdus(Produse p) {
        for (int i = 0; i <= produs.size(); i++) {
            if (i == produs.size()) {
                produs.add(i, p);
                break;
            }
        }
    }

    void removeProdus(String numeProdus) {
        for (int i = 0; i <= produs.size(); i++) {
            if (numeProdus.equals(produs.get(i).getNume())) {
                produs.set(i, null);
                for (int j = i; j < produs.size() - 1; j++) {
                    produs.set(j, produs.get(j + 1));
                }
                break;
            }
        }
    }

    void addGame(Jocuri j) {
        for (int i = 0; i <= joc.length; i++) {
            if (i == joc.length) {
                Jocuri[] temp = new Jocuri[joc.length * 2];
                for (i = 0; i < joc.length; i++) {
                    temp[i] = joc[i];
                }
                joc = temp;
            }
            if (joc[i] == null) {
                joc[i] = j;
                break;
            }
        }
    }

    void removeGame(String numeJocSters) {
        boolean test = false;
        for (int i = 0; i < joc.length; i++) {
            if (joc[i] != null) {
                if (numeJocSters.equals(joc[i].getNume())) {
                    joc[i] = null;
                    for (int j = i; j < joc.length - 1; j++) {
                        joc[j] = joc[j + 1];
                    }
                    test = true;
                    break;
                }

            }

            if (test) {
                System.out.println("Jocul a fost sters");
            } else {
                System.out.println("Jocul nu a fost gasit");
            }
        }

    }

    void foundGame(String numeTipDeJoc) {
        boolean test = false;
        for (int i = 0; i < joc.length; i++) {
            if (numeTipDeJoc.equals(joc[i].getTipDeJoc())) {
                test = true;
                break;
            }

        }
        if (test) {
            System.out.println("Tipul de joc exista.");
        } else {
            System.out.println("Reintrodu tipul de joc.");
        }
    }


    public void salvareFisier() {
        try {
            File fisier = new File("C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\bibliotecaDeJocuri\\BibliotecaMea");
            FileWriter fisierScris = new FileWriter(fisier);
            for (Produse p : getP()) {
                if (p instanceof Jocuri) {
                    fisierScris.write(p.toString() + "\n");
                } else if (p instanceof Filme) {
                    fisierScris.write(p.toString() + "\n");
                } else if (p instanceof Carti) {
                    fisierScris.write(p.toString() + "\n");
                }
            }
            fisierScris.close();
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public Biblioteca afisareProduse(Biblioteca b2) {
        try {
            File citire = new File("C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\bibliotecaDeJocuri\\BibliotecaMea");
            Scanner myReader = new Scanner(citire);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] s = data.split(";");
                if (s[0].equals("Joc")) {
                    Jocuri j = new Jocuri();
                    j.setNume(s[1]);
                    j.setPret(Double.valueOf(s[2]));
                    j.setDate(s[3]);
                    j.setTipDeJoc(s[4]);
                    b2.addProdus(j);
                } else if (s[0].equals("Film")) {
                    Filme f = new Filme();
                    f.setNume(s[1]);
                    f.setPret(Double.valueOf(s[2]));
                    f.setDate(s[3]);

                    String[] actori = s[4].split(",");
                    for (String a : actori) {
                        String[] pers = a.split("\\.");
                        Actori aa = new Actori(pers[1], pers[2], pers[3]);
                        aa.setVarsta(Integer.parseInt(pers[4]));
                        f.getActori().add(aa);
                    }
                    f.setDurata(Double.valueOf(s[5]));
                    f.setGender(s[6]);
                    b2.addProdus(f);
                } else if (s[0].equals("Carte")) {
                    Carti c = new Carti();
                    c.setNume(s[1]);
                    c.setPret(Double.valueOf(s[2]));
                    c.setDate(s[3]);
                    c.setNrCarti(Integer.parseInt(s[4]));
                    b2.addProdus(c);
                }
                System.out.println(data);
            }

        } catch (IOException e) {
            System.out.println("not found");
        }
        return b2;
    }

    public Produse citireFisier() {
        try {
            File citire = new File("C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\bibliotecaDeJocuri\\BibliotecaMea");
            Scanner myReader = new Scanner(citire);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }

        } catch (IOException e) {
            System.out.println("not found");
        }
        return null;
    }

    public void getFilme() {
        for (Produse p : getP()) {
            if (p instanceof Filme) {
                System.out.println(p.getNume());
            }
        }

    }


    public void getJocuri() {
        for (Produse p : getP()) {
            if (p instanceof Jocuri) {
                System.out.println(p.getNume());
            }
        }

    }

    public void getCarti() {
        for (Produse p : getP()) {
            if (p instanceof Carti) {
                System.out.println(p.getNume());
            }
        }
    }
}

