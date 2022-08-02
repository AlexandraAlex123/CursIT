package bibliotecaDeJocuri;

public class Biblioteca {
    Jocuri[] joc = new Jocuri[3];
    String nume;

    void addGame( Jocuri j) {
        for (int i = 0; i <= joc.length; i++) {
            if(i==joc.length){
                // tre sa creezi un nou vector de jocuri care sa copii tot din joc
                // maresti spatiul din joc
                // si dupa copii innapoi in joc
                joc=new Jocuri[joc.length * 2];
            }
            if(joc[i]==null){
                joc[i]=j;
                break;
            }else{
                if(joc[i].numeJoc.equals(j.numeJoc)){
                    System.out.println("Jocul este introdus");
                    break;
                }
            }

        }
        System.out.println("Nu mai sunt pozitii libere");
    }

    /*
    *  if (!j.numeJoc.equals(joc[i].numeJoc) && j.nume ) {
                if (joc[i] == null) {
                    joc[i] = j;
                    break;
                }
            }else {

                System.out.println("Jocul deja exista");
                break;
            }*/
    void remove (String numeJoc){
        for(int i=0 ; i<joc.length ; i++){
            if(joc[i] != null){
                if(numeJoc==joc[i].numeJoc){
                    joc[i]=null;
                    break;
                }
            }
        }
    }
}

