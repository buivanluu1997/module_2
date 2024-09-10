import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scanner.nextInt();
        int count = 0;
        int n = 2;
        while (count < number) {
            boolean check = true;
            if (n == 2) {
                check = true;
            } else {
                for (int i = 2; i < n; i++) {
                    if (n % i == 0) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                count++;
                System.out.println(n);
            }
            n++;
        }
    }
}
