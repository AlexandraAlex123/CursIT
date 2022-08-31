package bibliotecaDeJocuri;

public class Produse {
    protected String nume;
    protected double pret;
    protected String date;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {

        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}