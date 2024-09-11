package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class DaoNguocPhanTuCuaMang {
    public static void main(String[] args) {
        int size;
        int [] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập độ dài của chuỗi: ");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.println("Nhập lại độ dài < 20");
            }
        } while (size > 20);

        array = new int [size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhập phần tử thứ " + (i+1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("Mảng bạn vừa nhập là: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
        for (int j = 0; j < array.length/2; j++) {
            int item = array[j];
            array[j] = array[size-1-j];
            array[size-1-j] = item;
        }
        System.out.println();
        System.out.println("Mảng đảo ngược: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
    }
}
