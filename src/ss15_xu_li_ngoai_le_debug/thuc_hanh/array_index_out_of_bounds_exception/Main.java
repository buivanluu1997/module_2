package ss15_xu_li_ngoai_le_debug.thuc_hanh.array_index_out_of_bounds_exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] arr = arrayExample.createRandom();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nNhập chỉ số phần tử bất kì: ");
        int x = Integer.parseInt(scanner.nextLine());
        try {
            System.out.println("Giá trị của phần tử có chỉ số " + x + " là " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Chỉ số vượt quá giới hạng của mảng");
        }
    }
}
