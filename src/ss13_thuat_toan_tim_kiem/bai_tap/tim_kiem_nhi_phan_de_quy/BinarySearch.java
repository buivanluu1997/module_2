package ss13_thuat_toan_tim_kiem.bai_tap.tim_kiem_nhi_phan_de_quy;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mảng số nguyên có độ dài 10");
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.println("Nhập số cần tìm: ");
        int number = scanner.nextInt();

        int item;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    item = array[i];
                    array[i] = array[j];
                    array[j] = item;
                }
            }
        }
        System.out.println("Mảng đã sắp xếp lại là: ");
        for (int value : array) {
            System.out.print(value + " ");
        }


        int result = binarySearch(array, array[0], array[array.length - 1], number);
        System.out.println("Số cần tìm ở vị trí: " + result);

    }

    public static int binarySearch(int[] array, int left, int right, int value) {

        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                return middle;
            }
            if (value > array[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
