package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class Xoa_phan_tu_khoi_mang {
    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập phần tử cần xoá x: ");
        int x = scanner.nextInt();
        int index_del = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                index_del = i;
                break;
            }
        }
        if (index_del != -1) {
            for (int i = index_del; i < arr.length-1; i++) {
                arr[i] = arr[i+1];
            }
            arr[arr.length-1] = 0;
            System.out.println("Mảng mới là: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+ " ");
            }
        } else {
            System.out.println("Không tìm thấy phần tử " + x + " trong mảng");
        }


    }
}
