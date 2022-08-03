package bibliotecaDeJocuri;

import java.util.Scanner;

public class TemaBibliotecaJocuri {
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();
        b.nume = "Jocuri sport";
        Jocuri j = new Jocuri();
        j.numeJoc = "Fifa2022";
        j.pret = 22.99;
        j.data = "01.08.2022";
        j.tipDeJoc = "Fotbal";


        b.addGame(j);
        Jocuri v = new Jocuri();
        v.numeJoc = "Sims";
        b.addGame(v);
        Jocuri c = new Jocuri();
        c.numeJoc = "Titanic";
        Jocuri d = new Jocuri();
        d.numeJoc = "Nascar";
        b.addGame(c);
        b.addGame(d);


        Scanner key = new Scanner(System.in);
        String numeJoc = key.nextLine();
        b.remove(numeJoc);

    }
}
