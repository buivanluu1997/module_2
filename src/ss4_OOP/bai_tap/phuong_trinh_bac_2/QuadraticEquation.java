package ss4_OOP.bai_tap.phuong_trinh_bac_2;

public class QuadraticEquation {
    private double a, b, c;
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public double getC() {
        return this.c;
    }
    public double getDiscriminant() {
        double delta = Math.pow(this.b, 2) - (4 * this.a * this.c);
        return delta;
    }
    public double getRoot1() {
        if (getDiscriminant() >= 0) {
            double r1 = (-this.b + Math.pow((Math.pow(this.b, 2) - (4 * this.a * this.c)), 0.5)) / (2 * this.a);
            return r1;
        } else {
            return 0;
        }
    }
    public double getRoot2() {
        if (getDiscriminant() >= 0) {
            double r2 = (-this.b - Math.pow((Math.pow(this.b, 2) - (4 * this.a * this.c)), 0.5)) / (2 * this.a);
            return r2;
        } else {
            return 0;
        }
    }
}
