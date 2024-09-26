package ss14_thuat_toan_sap_xep.bai_tap.minh_hoa_tt_sx_chen;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        int pos, x;
        for (int i = 1; i < array.length; i++) {
            x = array[i];
            pos = i;

            // In ra trạng thái mảng trước mỗi lần chèn
            System.out.println("Before Step " + i + ": " + Arrays.toString(array));

            // Chèn x vào đúng vị trí
            while (pos > 0 && x < array[pos - 1]) {
                array[pos] = array[pos - 1];
                pos--;
            }
            array[pos] = x;

            // In ra trạng thái mảng sau khi chèn x
            System.out.println("After Step " + i + ": " + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};
        System.out.println("Original Array: " + Arrays.toString(array));
        insertionSort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}
