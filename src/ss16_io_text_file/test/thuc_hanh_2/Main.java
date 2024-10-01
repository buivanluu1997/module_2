package ss16_io_text_file.test.thuc_hanh_2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        System.out.println("Đường dẫn file cần đọc: ");
        String pathRead = "D:\\codegym\\module2\\src\\ss16_io_text_file\\test\\thuc_hanh_2\\numbers.txt";
        System.out.println(pathRead);
        List<Integer> numbers = readAndWriteFile.readFile(pathRead);
        int max = readAndWriteFile.numberMax(numbers);
        System.out.println("Đường dẫn file ghi: ");
        String pathWrite = "D:\\codegym\\module2\\src\\ss16_io_text_file\\test\\thuc_hanh_2\\result.txt";
        System.out.println(pathWrite);
        readAndWriteFile.wireFile(pathWrite, max);
    }
}
