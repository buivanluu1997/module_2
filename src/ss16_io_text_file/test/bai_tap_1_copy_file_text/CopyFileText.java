package ss16_io_text_file.test.bai_tap_1_copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
    public List<String> readFile(String pathFile) {
        List<String> list = new ArrayList<>();
        File file = new File(pathFile);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("File khong ton tai hoac noi dung co loi");
        }
        return list;
    }

    public void writeFile(String pathFile, List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String item : list) {
                bufferedWriter.write(item);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
