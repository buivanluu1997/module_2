package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class Tim_gia_tri_nho_nhat_trong_mang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài của mảng: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Nhập phần tử thứ " + (i+1) + " : ");
            array[i] = scanner.nextInt();
        }
        System.out.println("Mảng vừa nhập là: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        int min = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        System.out.println("Phần tử bé nhất của mảng là " + min + " ở vị trí " + index);
    }
}
