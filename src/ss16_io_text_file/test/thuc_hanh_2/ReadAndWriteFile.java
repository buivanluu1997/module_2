package ss16_io_text_file.test.thuc_hanh_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("File khong ton tai hoac noi dung co loi");
        }
        return numbers;
    }

    public int numberMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public void wireFile(String filePath, int max) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Gia tri lon nhat la " + max);
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
