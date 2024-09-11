package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class TongDuongCheo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Nhập độ dài của ma trận vuông: ");
            size = scanner.nextInt();
            if (size > 10) {
                System.out.println("Nhập lại độ dài( độ dài <= 10)");
            }
        } while (size > 10);
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Nhập phần tử thứ " + j + " ở hàng " + i + " : ");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Mảng vưa nhập là: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += array[i][i];
        }
        System.out.println("Tổng đường chéo chính của ma trận vuông = " + total);
    }
}
