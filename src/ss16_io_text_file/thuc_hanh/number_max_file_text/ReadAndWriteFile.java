package ss16_io_text_file.thuc_hanh.number_max_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWriteFile {
    public List<Integer> readFile(String path) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (Exception e) {
            System.out.println("File không tồn tại hoặc nội dung có lỗi");
        }
        return numbers;
    }

    public int findMax (List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public void writeFile(String falePath, int max) {
        try {
            FileWriter fileWriter = new FileWriter(falePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Giá trị lớn nhất là " + max);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        String pathRead = "D:\\codegym\\module2\\src\\ss16_io_text_file\\thuc_hanh\\number_max_file_text\\number.txt";
        List<Integer> numbers = readAndWriteFile.readFile(pathRead);
        int max = readAndWriteFile.findMax(numbers);

        String pathWrite = "D:\\codegym\\module2\\src\\ss16_io_text_file\\thuc_hanh\\number_max_file_text\\result.txt";
        readAndWriteFile.writeFile(pathWrite, max);
    }
}
