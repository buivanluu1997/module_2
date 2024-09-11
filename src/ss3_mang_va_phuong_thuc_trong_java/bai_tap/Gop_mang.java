package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class Gop_mang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài mảng 1: ");
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Nhập phần tử thứ " + (i+1) + " : " );
            arr1[i] = scanner.nextInt();
        }
        System.out.println("Mảng vừa nhập là arr1: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }

        System.out.print("\nNhập độ dài mảng 2: ");
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("Nhập phần tử thứ " + (i+1) + " : ");
            arr2[i] = scanner.nextInt();
        }
        System.out.println("Mảng vừa nhập là arr2: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        int n3 = n1 + n2;
        int[] arr3 = new int[n3];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[n1+i] = arr2[i];
        }
        System.out.println("\nGộp lại 2 mảng arr1 và arr2 là:");
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
