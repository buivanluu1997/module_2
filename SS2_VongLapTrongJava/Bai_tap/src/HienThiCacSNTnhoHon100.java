public class HienThiCacSNTnhoHon100 {
    public static void main(String[] args) {
        int n = 2;
        while (n < 100) {
            boolean check = true;
            if (n == 2) {
                check = true;
            } else {
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                System.out.print(n + " ");
            }
            n++;
        }
    }
}
