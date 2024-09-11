package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class TongCacSoO1Cot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row;
        int column;
        do {
            System.out.print("Nhập số hàng: ");
            row = scanner.nextInt();
            if (row > 10) {
                System.out.println("Nhập lại số hàng( số hàng <= 5)");
            }
        } while (row > 10);
        do {
            System.out.print("Nhập số cột: ");
            column = scanner.nextInt();
            if (column > 20) {
                System.out.println("Nhập lại số hàng( số hàng <= 7)");

            }
        } while (column > 20);

        int[][] array = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Nhập phần tử thứ " + j + " ở hàng " + i + " : ");
                array[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j] +" ");
            }
            System.out.println();
        }

        System.out.print("Nhập cột bạn muốn tính tổng: ");
        int numColumn = scanner.nextInt();
        int total = 0;
        for (int i = 0; i < row; i++) {
                total += array[i][numColumn];
        }
        System.out.println("Tổng của cột " + numColumn + " trong mảng 2 chiều = " + total);
    }
}
