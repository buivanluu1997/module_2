package ss3_mang_va_phuong_thuc_trong_java.test;

import java.util.Scanner;

public class Test_xoa_ptu_vao_mang {
    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so can xoa: ");
        int num = scanner.nextInt();
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                index = i;
                break;
            }
        }
        int[] newArr = new int[arr.length-1];
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        for (int i = index; i < arr.length-1; i++) {
            newArr[i] = arr[i+1];
        }
        System.out.println("Mang moi la: ");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }
}
