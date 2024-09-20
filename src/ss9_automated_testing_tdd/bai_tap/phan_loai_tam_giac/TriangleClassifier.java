package ss9_automated_testing_tdd.bai_tap.phan_loai_tam_giac;

import ss6_tinh_ke_thua.bai_tap.triangle_mo_rong_shape.Triangle;

import java.util.Scanner;

public class TriangleClassifier {
    public String Triangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0 || a+b <= c || a+c <= b || b+c <= a) {
            return "Không phải là tam giác";
        } else {
            if (a == b && b == c) {
                return "Tam giác đều";
            } else if (a == b || a == c || b == c) {
                return "Tam giác cân";
            } else {
                return "Là 1 tam giác thường";
            }
        }
    }

}




