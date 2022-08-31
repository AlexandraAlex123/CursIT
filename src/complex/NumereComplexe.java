package complex;

public class NumereComplexe {
    public static void main(String[] args) {
        Complex c = new Complex(2, 4);//2 + 4i
        Complex x2 = new Complex(4, 10);
        Complex xx = new Complex(2, 2);
        Complex xx1 = new Complex(2, 2);
        Complex xx2 = new Complex(6, 14);
        if ((x2.add(c)) == xx) {
            System.out.println("Numerele sunt egale");
        } else {
            System.out.println("Numerele nu sunt egale");
        }
        x2.equals(c);
        c.negate();
        xx.equals(xx1);
        x2.toString();
        c.multiply(xx);
    }

    // ! c --> ! ( c ) --> ! true/false --> rezultat
    // a  + b --> 2  + 4  ->  rezultat (6)
    // apelMetoda1(apelMetoda())
    // expresii +++ stack/heap
}
