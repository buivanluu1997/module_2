package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class DemSoLanXuatHienKTuTrongChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String str = scanner.nextLine();
        System.out.println("Nhập ký tự cần kiểm tra: ");
        char characters = scanner.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == characters) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Kí tự " + characters + " xuất hiện " + count + " trong chuỗi " + str);
        } else {
            System.out.println("Kí tự " + characters + " không có trong chuỗi " + str);
        }
    }
}
