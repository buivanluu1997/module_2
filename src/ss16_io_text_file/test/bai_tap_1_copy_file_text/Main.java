package ss16_io_text_file.test.bai_tap_1_copy_file_text;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CopyFileText copyFileText = new CopyFileText();
        System.out.println("Đường dẫn file cần đọc: ");
        String pathFileRead = "D:\\codegym\\module2\\src\\ss16_io_text_file\\test\\bai_tap_1_copy_file_text\\source.txt";
        System.out.println(pathFileRead);
        List<String> list = copyFileText.readFile(pathFileRead);
        System.out.println("Đường dẫn file cần ghi: ");
        String pathFileWrite = "D:\\codegym\\module2\\src\\ss16_io_text_file\\test\\bai_tap_1_copy_file_text\\target.txt";
        System.out.println(pathFileWrite);
        copyFileText.writeFile(pathFileWrite, list);
    }
}
