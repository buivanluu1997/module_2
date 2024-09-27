package ss16_io_text_file.bai_tap.doc_file_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCsv {
    public List<Country> readFile(String path) {
        List<Country> countries = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                int id = Integer.parseInt(arr[0]);
                String code = arr[1];
                String name = arr[2];
                countries.add(new Country(id, code, name)); 
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("File không tồn tại hoặc file có lỗi!");
        }
        return countries;
    }

    public void ShowCountry(List<Country> countries) {
        for (Country country : countries) {
            System.out.println(country);
        }
    }

    public static void main(String[] args) {
        ReadFileCsv readFileCsv = new ReadFileCsv();
        String path = "D:\\codegym\\module2\\src\\ss16_io_text_file\\bai_tap\\doc_file_csv\\csv";
        List<Country> countryList = readFileCsv.readFile(path);
        readFileCsv.ShowCountry(countryList);
    }
}
