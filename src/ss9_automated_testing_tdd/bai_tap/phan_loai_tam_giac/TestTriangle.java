package ss9_automated_testing_tdd.bai_tap.phan_loai_tam_giac;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap canh a: ");
        int a = scanner.nextInt();
        System.out.println("Nhap canh b: ");
        int b = scanner.nextInt();
        System.out.println("Nhap canh c: ");
        int c = scanner.nextInt();

        TriangleClassifier triangleClassifier = new TriangleClassifier();
        String result = triangleClassifier.Triangle(a,b,c);
        System.out.println(result);
    }
}
