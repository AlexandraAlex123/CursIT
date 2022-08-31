package bibliotecaDeJocuri;

import java.io.*;
import java.util.Scanner;


public class TemaInherence {
    public static void main(String[] args) throws IOException {
        Biblioteca b = new Biblioteca();
        Jocuri j = new Jocuri();
        j.setNume("Sims");
        j.setMultiplayer(false);
        j.setTipDeJoc("JDF");
        j.setDate("21.03.2003");
        j.setPret(22.33);
        b.addProdus(j);

        System.out.println(j);

        Jocuri j1 = new Jocuri();
        j1.setNume("Fifa");
        j1.setMultiplayer(true);
        j1.setTipDeJoc("RPG");
        j1.setDate("25.04.2018");
        j1.setPret(29.99);
        b.addProdus(j1);

        Jocuri j2 = new Jocuri();
        j2.setNume("XOX");
        j2.setMultiplayer(true);
        j2.setPret(30.12);
        j2.setDate("15.06.2021");
        j2.setTipDeJoc("FPS");
        b.addProdus(j2);

        Jocuri j3 = new Jocuri();
        j3.setNume("Nascar");
        j3.setMultiplayer(true);
        j3.setPret(19.99);
        j3.setDate("15.08.2019");
        j3.setTipDeJoc("RTP");
        b.addProdus(j3);


        Filme f = new Filme();
        Actori a = new Actori("Leonardo", "DiCaprio", "1478");
        Actori a1 = new Actori("Kate", "Winslet", "2147");
        f.setNume("Titanic");
        f.setDate("25.06.2017");
        f.setPret(28.73);
        f.setDurata(1.50);
        f.setGender("Romantic");
        f.getActori().add(a);
        a.setVarsta(35);
        f.getActori().add(a1);
        a1.setVarsta(32);
        b.addProdus(f);

        Filme f1 = new Filme();
        Actori a2 = new Actori("Naomi", "Watts", "2148");
        Actori a3 = new Actori("David", "Dorfman", "1596");
        f1.setNume("The Ring");
        f1.setPret(25.33);
        f1.setDate("14.05.2011");
        f1.setDurata(1.46);
        f1.setGender("Thriller");
        f1.getActori().add(a2);
        a2.setVarsta(33);
        f1.getActori().add(a3);
        a3.setVarsta(39);
        b.addProdus(f1);

        Filme f2 = new Filme();
        Actori a4 = new Actori("Jennifer", "loveHewitt", "2589");
        Actori a5 = new Actori("Paul", "Nicholls", "1547");
        f2.setNume("If Only");
        f2.setDate("12.09.2018");
        f2.setPret(29.99);
        f2.setDurata(1.36);
        f2.setGender("Drama");
        f2.getActori().add(a4);
        a4.setVarsta(36);
        f2.getActori().add(a5);
        a5.setVarsta(40);
        b.addProdus(f2);

        Carti c = new Carti();
        c.setNume("Cartea Mea");
        c.setPret(26.99);
        c.setDate("11.08.2019");
        c.setNrCarti(3);
        b.addProdus(c);

        Carti c1 = new Carti();
        c1.setNume("Winnie Poo");
        c1.setPret(45.63);
        c1.setDate("30.12.2020");
        c1.setNrCarti(10);
        b.addProdus(c1);

        Carti c2 = new Carti();
        c2.setNume("Ali Baba");
        c2.setDate("14.05.2021");
        c2.setPret(30.66);
        c2.setNrCarti(8);
        b.addProdus(c2);

        b.getFilme();
        System.out.println(" ");
        b.getCarti();
        System.out.println(" ");
        b.getJocuri();

        b.salvareFisier();


//        try {
//            FileOutputStream fisier = new FileOutputStream("C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\bibliotecaDeJocuri\\BibliotecaMea" );
//            File fisier = new File("C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\bibliotecaDeJocuri\\BibliotecaMea");
//            FileWriter fisierScris = new FileWriter(fisier);
//            BufferedWriter bfisier = new BufferedWriter(fisier1);
//            for (Produse p : b.getP()) {
//                if (p instanceof Jocuri) {
//                    fisierScris.write(p.toString() + "\n");
//                } else if (p instanceof Filme) {
//                    fisierScris.write(p.toString() + "\n");
//                } else if (p instanceof Carti) {
//                    fisierScris.write(p.toString() + "\n");
//                }
//            }
//            fisierScris.close();
//        } catch (IOException e) {
//            System.out.println("Error : " + e.getMessage());
//        }


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

        // FileReader in  = new FileReader("BibliotecaMea.txt");

    }


//      private static Produse[] getP() {
//          return new Produse[0];
//          }
}




