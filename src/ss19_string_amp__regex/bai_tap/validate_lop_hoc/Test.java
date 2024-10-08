package ss19_string_amp__regex.bai_tap.validate_lop_hoc;

import java.util.Scanner;

public class Test {
    public static String inputDay(String day) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (day.matches("\\d{2}/\\d{2}/\\d{4}")) {
                return "ok " + day;
            } else {
                System.out.println("Nhập lại ngày tháng năm");
                day = sc.nextLine();
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ngay thang nam");
        String day = scanner.nextLine();
        inputDay(day);
        System.out.println(inputDay(day));
    }
}
