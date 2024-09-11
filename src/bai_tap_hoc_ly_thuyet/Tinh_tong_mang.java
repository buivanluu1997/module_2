package bai_tap_hoc_ly_thuyet;

public class Tinh_tong_mang {
    public static void main(String[] args) {
        int [] number = {1,4,7,8};
        int total = 0;
        for (int item: number) {
            total += item;
        }
        System.out.println("Tổng mảng number = " + total);
    }
}
