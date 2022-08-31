package complex;

public class Complex {
    private double a;
    private double b;

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }



    /**
     * javadoc
     * Add two complex numbers.
     * Adds this and number and returns a new Complex instance
     **/
    public Complex add(Complex x) {
       // Complex temp = new Complex(0,0);
       // temp.a = x.a + this.a;
       // temp.b = x.b + this.b;
       // System.out.println(temp);
        //return temp;
        return new Complex(x.a + this.a , x.b + this.b );
    }

    // 3 -> -3
    // this -->cream un nou complex number
    // care este format din negarea lui this
    // returnam acest complex number
    public Complex negate() {
        Complex temp = new Complex(0,0);
        temp.a = -1*this.a;
        temp.b = -1*this.b;
        System.out.println(temp);
        return temp;
    }

    public boolean equals(Complex x) {
        if (this.a == x.a && this.b == x.b) {
            System.out.println("Numerele sunt egale");
            return true;
        }else {
            System.out.println("numerele nu sunt egale");
            return false;
        }
    }

    public Complex multiply(Complex x) {
        Complex temp = new Complex(0,0);
        temp.a = x.a * this.a - x.b * this.b;
        temp.b = x.a * this.b + x.b * this.a;
        System.out.println(temp);
        return temp;

    }


    public String toString() {
        String temp = new String();
        temp = this.a + " "+"+"+" "+ this.b + "i";
        System.out.println(temp);
        return temp;
    }

    static Complex create(double realPart, double imaginaryPart) {
        return null;
    }

}
