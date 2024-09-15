package ss6_tinh_ke_thua.bai_tap.triangle_mo_rong_shape;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài cạnh thứ nhất của tam giác: ");
        double size1 = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập độ dài cạnh thứ hai của tam giác: ");
        double size2 = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập độ dài cạnh thứ ba của tam giác: ");
        double size3 = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập màu cho tam giác: ");
        String color = scanner.nextLine();
        System.out.print("Nhập đầy cho tam giác true or false :");
        boolean filled = Boolean.parseBoolean(scanner.nextLine());

        Triangle triangle = new Triangle(size1, size2, size3, color, filled);
        System.out.println(triangle);
    }
}
