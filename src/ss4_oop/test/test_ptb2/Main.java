package ss4_oop.test.test_ptb2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhap b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhap c: ");
        double c = scanner.nextDouble();

        PhuongTrinhBac2 phuongTrinhBac2 = new PhuongTrinhBac2(a, b ,c);
        if (phuongTrinhBac2.getDiscriminant() > 0) {
            System.out.println("pt co 2 nghiem x1 = " + phuongTrinhBac2.getRoot1() + " va x2 = " + phuongTrinhBac2.getRoot2());
        } else if (phuongTrinhBac2.getDiscriminant() == 0) {
            System.out.println("pt co 1 nghiem kep x = " + phuongTrinhBac2.getRoot2());
        } else {
            System.out.println("Pt vo nghiem");
        }
    }
}
