package bai_tap_hoc_ly_thuyet;

public class Tinh_tong_duong_cheo_trai_mang_2_chieu {
    public static void main(String[] args) {
        int [][] arr = {{1,4,8},
                        {2,6,8},
                        {3,2,1}
                       };
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i][i];
        }
        System.out.println("Tổng đường chéo trái = " + total);
    }
}
