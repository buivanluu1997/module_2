package ss4_oop.test.test_ptb2;

public class PhuongTrinhBac2 {
    private double a;
    private double b;
    private double c;
    public PhuongTrinhBac2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    public double getDiscriminant() {
        return b*b - 4*a*c;
    }
    public double getRoot1() {
        if (getDiscriminant() >= 0) {
            return (-this.b + Math.pow((Math.pow(this.b, 2) - (4 * this.a * this.c)), 0.5)) / (2 * this.a);
        } else {
            return 0;
        }
    }
    public double getRoot2() {
        if (getDiscriminant() >= 0) {
            return (-this.b - Math.pow((Math.pow(this.b, 2) - (4 * this.a * this.c)), 0.5)) / (2 * this.a);
        } else {
            return 0;
        }
    }
}
