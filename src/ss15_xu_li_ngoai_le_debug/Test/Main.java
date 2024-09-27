package ss15_xu_li_ngoai_le_debug.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Nhap canh a: ");
                int a = scanner.nextInt();
                System.out.println("Nhap canh b: ");
                int b = scanner.nextInt();
                System.out.println("Nhap canh c: ");
                int c = scanner.nextInt();
                NewTriangle newTriangle = new NewTriangle(a, b, c);
                System.out.println(newTriangle.toString());
                break;
            } catch (IllegalTriangleException e) {
                System.out.println("Loi: " + e.getMessage());
            }
        }
    }
}
