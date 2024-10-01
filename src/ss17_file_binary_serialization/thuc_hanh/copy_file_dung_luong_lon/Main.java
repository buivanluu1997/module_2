package ss17_file_binary_serialization.thuc_hanh.copy_file_dung_luong_lon;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException{
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
        finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {

        System.out.println("Tập tin nguồn: ");
        String pathSource = "D:\\codegym\\module2\\src\\ss17_file_binary_serialization\\bai_tap\\copy_file_nhi_phan\\source.rar";
        System.out.println(pathSource);
        System.out.println("Tệp đích: ");
        String pathDest = "D:\\codegym\\module2\\src\\ss17_file_binary_serialization\\bai_tap\\copy_file_nhi_phan\\target.rar";
        System.out.println(pathDest);

        File sourceFile = new File(pathSource);
        File destFile = new File(pathDest);

        try{
            /*copyFileUsingJava7Files(sourceFile,destFile);*/

            copyFileUsingStream(sourceFile, destFile);
        }catch (IOException ioe) {
            System.out.println("Không thể sao chép tệp tin đó");
            System.out.println(ioe.getMessage());
        }
    }
}
