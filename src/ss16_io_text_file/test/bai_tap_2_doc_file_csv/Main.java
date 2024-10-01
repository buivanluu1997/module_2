package ss16_io_text_file.test.bai_tap_2_doc_file_csv;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadFileCsv readFileCsv = new ReadFileCsv();
        System.out.println("Đường dẫn file đọc");
        String pathRead = "D:\\codegym\\module2\\src\\ss16_io_text_file\\test\\bai_tap_2_doc_file_csv\\country.csv";
        System.out.println(pathRead);
        List<Country> countries = readFileCsv.readFile(pathRead);
        readFileCsv.showCountry(countries);
    }
}
