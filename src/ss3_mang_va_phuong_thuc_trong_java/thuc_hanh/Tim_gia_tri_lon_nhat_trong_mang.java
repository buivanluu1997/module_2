package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class Tim_gia_tri_lon_nhat_trong_mang {
    public static void main(String[] args) {
        int size;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập độ dài của mảng: ");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.print("Nhập lại độ dài(độ dài phải <= 20): ");
            }
        } while (size > 20);

        int [] array = new int [size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Nhập phần tử thứ " + (i+1) + " : ");
            array[i] = scanner.nextInt();
        }

        System.out.print("Mảng bạn vừa nhập là: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        int max = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i + 1;
            }
        }
        System.out.println();
        System.out.print("Giá trị lớn nhất trong mảng là " + max + " ở vị trí thứ " +index);
    }
}
