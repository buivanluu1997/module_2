package ss16_io_text_file.test.thuc_hanh_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReadFileExample readFileExample = new ReadFileExample();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập đường dẫn file: ");
        String path = scanner.nextLine();
        readFileExample.readFileText(path);
    }
}
