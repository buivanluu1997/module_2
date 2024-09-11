package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class Chuong_trinh_chuyen_doi_nhiet_do {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double fahrenheit;
        double celsius;
        int choice = -1;
        do {
            System.out.println("Menu: ");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Fahrenheit: ");
                    fahrenheit = scanner.nextDouble();
                    double result = fahrenheitToCelsius(fahrenheit);
                    System.out.println(fahrenheit + " F = " + result + " C");
                case 2:
                    System.out.println("Enter Celsius: ");
                    celsius = scanner.nextDouble();
                    double result2 = celsiusToFahrenheit(celsius);
                    System.out.println(celsius + " C = " + result2 + " F");
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);

    }
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }
}
