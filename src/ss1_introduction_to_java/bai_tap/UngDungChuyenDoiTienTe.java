package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vnd = 23000;
        double quyDoi;
        System.out.println("Nhập giá trị USD: ");
        double usd = scanner.nextInt();
        quyDoi = usd * vnd;
        System.out.println(usd + " USD" + " = " + quyDoi + " VND");
    }
}
