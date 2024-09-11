package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

public class TimPhanTuLonNhat {
    public static void main(String[] args) {
        double[][] array = {{1.0, 3.0, 5.0, 4.0},
                            {2.0, 4.0, 7.0, 9.0},
                            {8.0, 4.0, 12.0, 6.0}
                            };
        double max = array[0][0];
        int row = 0;
        int column = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    row = i;
                    column = j;
                }
            }
        }
        System.out.println("Phần tử lớn nhất trong mảng 2 chiều là " + max + " ở hàng " + row + " cột " + column);
    }
}
