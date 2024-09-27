package ss15_xu_li_ngoai_le_debug;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Chon chuc nang: \n" +
                        "1. them \n" +
                        "2. sua \n" +
                        "3. xoa \n" +
                        "4. thoat");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("da them thanh cong");
                        break;
                    case 2:
                        System.out.println("sua thanh cong");
                        break;
                    case 3:
                        System.out.println("Sua thanh cong");
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Ban phai nhap tu 1 den 4");
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Ban nhap sai vi khong phai la so nguyen");
            }
        }
    }
}
