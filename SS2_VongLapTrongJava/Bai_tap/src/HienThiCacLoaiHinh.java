import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 4) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. Print the rectangle");
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 1; j <= 7; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("2. Print the square triangle");
                    System.out.println("top-left");
                    for (int i = 5; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }

                    System.out.println("top-right");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= 5; j++) {
                            if (j >= i) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }


                    System.out.println("botton right");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= 5; j++) {
                            if (i == 5 || j == 5 || j > 5 - i) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }

                    System.out.println("botton left");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j<= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("3. Print isosceles triangle");
                    for (int i = 1; i <= 4; i++) {
                        for (int k = 4; k > i; k--) {
                            System.out.print(" ");
                        }
                        //in ra số dấu * trên mỗi dòng có số lượng dấu * theo công thức i*2-1
                        for (int j = 1; j <= i*2-1; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
