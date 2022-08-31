package bibliotecaDeJocuri;

public class Actori {
    private String nume;
    private String prenume;
    private String cnp;
    private int varsta;
    //.... aici mai sunt cateva atribute

    public Actori(String num, String prenume, String cnp) {

        nume = num;
        this.prenume = prenume;
        this.cnp = cnp;

    }

    public String getNume() {
        return this.nume;
    }

    public void setNume(String nume) {
        this.prenume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String toString() {
        return "." + this.nume + "." + this.prenume + "." + this.cnp + "." + this.varsta + "." ;
    }
}
