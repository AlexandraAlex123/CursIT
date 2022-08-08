package bibliotecaDeJocuri;

import java.util.Scanner;

public class TemaBibliotecaJocuri {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        Biblioteca b = new Biblioteca();

        b.nume = "Jocuri sport";

        Jocuri j = new Jocuri();
        j.setNumeJoc("Fifa2022");
        j.setPret(22.99);
        j.setData("01.08.2022");
        j.setTipDeJoc("RPG");
        b.addGame(j);

        Jocuri v = new Jocuri();
        v.setNumeJoc("Sims");
        v.setPret(23.56);
        v.setData("12.03.2020");
        v.setTipDeJoc("JDF");
        b.addGame(v);

        Jocuri c = new Jocuri();
        c.setNumeJoc("Titanic");
        c.setPret(30.12);
        c.setData("15.06.2021");
        c.setTipDeJoc("FDS");
        b.addGame(c);

        Jocuri d = new Jocuri();
        d.setNumeJoc("Nascar");
        d.setPret(19.99);
        d.setData("15.08.2019");
        d.setTipDeJoc("MMV");
        b.addGame(d);

        String numeJocSters = key.nextLine();
        b.remove(numeJocSters);

        String numeTipDeJoc = key.nextLine();
        b.found(numeTipDeJoc);
    }
}
