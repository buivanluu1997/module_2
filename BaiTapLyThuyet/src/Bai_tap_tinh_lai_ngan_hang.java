import java.util.Scanner;

public class Bai_tap_tinh_lai_ngan_hang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap vao so ten gui: ");
        int n = input.nextInt();
        System.out.println("Nhap vao so nam gui: ");
        int m = input.nextInt();
        double sum = n;
        for (int i = 1; i <= m; i++) {
           sum *= (1 + 0.06 );
        }
        System.out.println("tong so tien " + n + " sau " + m + " nam gui = " + sum);
    }
}
