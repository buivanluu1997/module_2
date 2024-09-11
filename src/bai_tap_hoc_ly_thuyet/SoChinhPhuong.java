package bai_tap_hoc_ly_thuyet;

import java.util.Scanner;

public class SoChinhPhuong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhap so a: ");
        int a = input.nextInt();
        System.out.println("nhap so b: ");
        int b = input.nextInt();
        int sum = 0;
        if (a < b) {
            for (int i = a; i <= b; i++) {
                sum += i;
            }
            System.out.println("tong = " + sum);
        } else {
            System.out.println("a phai nho hon b");
        }
    }
}
