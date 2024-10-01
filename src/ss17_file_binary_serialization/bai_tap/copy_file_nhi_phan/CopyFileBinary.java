package ss17_file_binary_serialization.bai_tap.copy_file_nhi_phan;

import ss16_io_text_file.bai_tap.copy_file_text.CopyFileText;

import java.io.*;

public class CopyFileBinary {
        public static void copyFileUsingStream(File source, File target) throws IOException {
            InputStream is = null;
            OutputStream os = null;
            int totalBytes = 0;
            try {
                is = new FileInputStream(source);
                os = new FileOutputStream(target);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                    totalBytes += length;
                }
                System.out.println("Tổng số bytes được sao chép là: " + totalBytes);

            } finally {
                if (is != null) is.close();
                if (os != null) os.close();
            }
        }

        public static void main(String[] args) {
            String sourcePath = "D:\\codegym\\module2\\src\\ss17_file_binary_serialization\\bai_tap\\copy_file_nhi_phan\\source.rar";
            System.out.println("Tệp nguồn là: \n" + sourcePath);
            String targetPath = "D:\\codegym\\module2\\src\\ss17_file_binary_serialization\\bai_tap\\copy_file_nhi_phan\\target.rar";
            System.out.println("Tệp đích là: \n" + targetPath);

            File sourceFile = new File(sourcePath);
            File targetFile = new File(targetPath);

            if (!sourceFile.exists()) {
                System.out.println("Tệp nguồn không tồn tại");
                return;
            }
            if (targetFile.exists()) {
                System.out.println("Tệp đích đã tồn tại");
            }

            try {
                copyFileUsingStream(sourceFile, targetFile);
                System.out.println("Đã sao chép tệp thành công");
            } catch (IOException e) {
                System.out.println("Xảy ra lỗi khi sao chép tệp");
            }
        }
}
