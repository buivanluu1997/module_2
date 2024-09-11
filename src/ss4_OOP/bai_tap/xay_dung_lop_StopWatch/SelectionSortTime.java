package ss4_OOP.bai_tap.xay_dung_lop_StopWatch;

import java.util.Random;

public class SelectionSortTime {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int item = arr[i];
                    arr[i] = arr[j];
                    arr[j] = item;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        StopWatch stopWatch = new StopWatch();

        stopWatch.star();

        selectionSort(arr);

        stopWatch.stop();
        System.out.println("Thời gian thực thi thuật toán sắp xếp chọn là " + stopWatch.getElapsedTime() + " milliseconds");
    }
}
