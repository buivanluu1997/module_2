package ss16_io_text_file.test.bai_tap_2_doc_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCsv {
    public List<Country> readFile(String pathFile) {
        List<Country> countryList = new ArrayList<>();
        File file = new File(pathFile);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                int id = Integer.parseInt(array[0]);
                String code = array[1];
                String name = array[2];
                Country country = new Country(id, code, name);
                countryList.add(country);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("File khong ton tai hoac noi dung co loi.");
        }
        return countryList;
    }

    public void showCountry(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.println(country);
        }
    }
}
