package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class Them_phan_tu_vao_mang {
    public static void main(String[] args) {
        int [] array = {10, 4, 6, 7, 8, 0, 0, 0, 0, 0};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số cần chèn: ");
        int number = scanner.nextInt();
        System.out.print("Nhập vị trí cần chèn: ");
        int index = scanner.nextInt();
        if (index <= -1 || index > array.length-1) {
            System.out.println("Không chèn được phần tử vào mảng");
        } else {
            int[] newArr = new int[array.length+1];
            for (int i = 0; i < index; i++) {
                newArr[i] = array[i];
            }
            newArr[index] = number;
            for (int i = index+1; i < newArr.length; i++) {
                newArr[i] = array[i-1];
            }
            System.out.println("Mảng mới là: ");
            for (int i = 0; i < newArr.length; i++) {
                System.out.print(newArr[i] + " ");
            }
        }
    }
}
