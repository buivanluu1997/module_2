package ss13_thuat_toan_tim_kiem.bai_tap.tim_chuoi_tang_dan_co_do_dai_max;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StrLengthMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi bất kì: ");
        String str = scanner.nextLine();

        List<String> list = new ArrayList<>();

        String newString = "";

        for (int i = 0; i < str.length() - 1; i++) {
            char initialChar = str.charAt(i);
            newString += initialChar;
            for (int j = i + 1; j < str.length(); j++) {
                char nextChar = str.charAt(j);
                if (initialChar < nextChar) {
                    newString += nextChar;
                    initialChar = nextChar;
                }
            }
            list.add(newString);
            newString = "";
        }

        String max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > max.length()) {
                max = list.get(i);
            }
        }
        System.out.println("Chuỗi kí tự con được sắp xếp theo thứ tự từ bé đến lớn: " + max);
    }
}
