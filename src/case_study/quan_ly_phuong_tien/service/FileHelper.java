package case_study.quan_ly_phuong_tien.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    public List<String> readFile(String path) {
        List<String> lists = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lists.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("File không tồn tại hoặc file có lỗi!");
        }
        return lists;
    }

    public void writeFile(String path, List<String> lists) {
        try {
            FileWriter fileWriter = new FileWriter(path, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String list : lists) {
                bufferedWriter.write(list);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
