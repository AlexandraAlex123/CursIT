package bibliotecaDeJocuri;

public class Carti extends Produse {

    private int nrCarti;

    public int getNrCarti() {
        return nrCarti;
    }

    public void setNrCarti(int nrCarti) {
        this.nrCarti = nrCarti;
    }

    public String toString() {
        return "Carte;" + this.nume + ";" + this.pret + ";" + this.date + ";" + this.nrCarti;
    }
}