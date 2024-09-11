package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class Tim_gia_tri_trong_mang {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sinh viên muốn tìm: ");
        String input_name = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input_name)) {
                System.out.println("Tên sinh viên " + input_name + " trong danh sách có vị trí là " + i);
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Tên sinh viên " + input_name + " không có trong danh sách");
        }
    }
}
