package bibliotecaDeJocuri;

public class Jocuri extends Produse {
    private String tipDeJoc; // RGP, FPS, RTS, JOC_DE_FETE
    static String[] posibilTipDeJoc;

    //singlePlayer/multiplayer
    private boolean multiplayer;


    static {

        posibilTipDeJoc = new String[4];
        posibilTipDeJoc[0] = "RPG";
        posibilTipDeJoc[1] = "FPS";
        posibilTipDeJoc[2] = "RTP";
        posibilTipDeJoc[3] = "JDF";
    }

    public Jocuri() {
    }

    public Jocuri(double p) {
        pret = p;
    }


    static void modificaPTD(String nouTDJ, int pos) {
        posibilTipDeJoc[pos] = nouTDJ;
    }

    void setTipDeJoc(String tdjParam) {
        for (String tdjiterator : posibilTipDeJoc) {
            if (tdjParam.equals(tdjiterator)) {
                tipDeJoc = tdjParam;
            }
        }
    }

    String getTipDeJoc() {
        return tipDeJoc;
    }

    public String[] getPosibilTipDeJoc() {
        return posibilTipDeJoc;
    }

    public void setPosibilTipDeJoc(String[] posibilTipDeJoc) {
        Jocuri.posibilTipDeJoc = posibilTipDeJoc;
    }

    public boolean isMultiplayer() {
        return multiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        this.multiplayer = multiplayer;
    }

    //overriding
    public String getNume() {
        return nume.toLowerCase();
    }
    public String toString() {
        return "Joc" + ";" + this.nume + ";" + this.pret + ";" + this.date + ";" + this.tipDeJoc + " ";
    }

//    public String toString(){
//        return getClass().getName() + ";" + Integer.toHexString(hashCode());
//   }
}