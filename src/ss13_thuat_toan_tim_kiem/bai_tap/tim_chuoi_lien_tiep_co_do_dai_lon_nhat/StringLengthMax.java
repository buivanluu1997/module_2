package ss13_thuat_toan_tim_kiem.bai_tap.tim_chuoi_lien_tiep_co_do_dai_lon_nhat;

import java.util.ArrayList;
import java.util.List;

public class StringLengthMax {
    public static void main(String[] args) {
        String str = "dababcdgabxy";

        List<String> list = new ArrayList<>();

        int index = 0;

        while (index < str.length()) {
            String newStr = "";
            newStr += str.charAt(index);

            for (int i = index; i < str.length(); i++) {
                if (i == str.length() - 1) {
                    index = str.length();
                    break;
                }

                if (str.charAt(i) > str.charAt(i + 1)) {
                    index = i + 1;
                    break;
                }
                newStr += str.charAt(i + 1);
            }
            list.add(newStr);
        }

        String max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() > max.length()) {
                max = list.get(i);
            }
        }

        System.out.println("chuỗi con được sắp xếp theo thứ tự có độ dài lớn nhất là: " + max);
    }
}
