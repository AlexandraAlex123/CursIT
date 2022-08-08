package bibliotecaDeJocuri;

public class Biblioteca {
    Jocuri[] joc = new Jocuri[3];
    String nume;

    void addGame(Jocuri j) {
        boolean test = false;
        for (int i = 0; i <= joc.length; i++) {
            if (i == joc.length) {
                Jocuri[] temp = new Jocuri[joc.length * 2];
                for (i = 0; i < joc.length; i++) {
                    temp[i] = joc[i];
                    test = true;
                }
                joc = temp;
            }
            if (joc[i] == null) {
                joc[i] = j;
                test = true;
                break;
            }
        }
    }

    void remove(String numeJocSters) {
        boolean test = false;
        int j = 0;
        for (int i = 0; i < joc.length; i++) {
            if (joc[i] != null) {
                if (numeJocSters.equals(joc[i].getNumeJoc())) {
                    joc[i] = null;
                    for (j = i; j < joc.length; j++) {
                        joc[i] = joc[i + 1];
                    }
                    test = true;
                    break;
                }

            }
        }
        if (test) {
            System.out.println("Jocul a fost sters");
        } else {
            System.out.println("Jocul nu a fost gasit");
        }
    }

    void found(String numeTipDeJoc) {
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




}

