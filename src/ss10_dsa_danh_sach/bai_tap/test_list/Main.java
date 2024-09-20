package ss10_dsa_danh_sach.bai_tap.test_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


public class Main {
    static ArrayList<Student> list = new ArrayList<>();
    static {
        list.add(new Student("Bui Van Luu",1));
        list.add(new Student("Nguyen An",5));
        list.add(new Student("Tran Ngoc Anh",3));
        list.add(new Student("Ho Van Khoa",2));
    }


    public static void main(String[] args) {
        System.out.println("Phan tu thu 2 la: ");
        System.out.println(list.get(2));
        System.out.println("Xoa phan tu thu 1");
        System.out.println(list.remove(1));
        System.out.println("mang da xoa con lai");
        System.out.println(list);
        System.out.println("tim kiem bui van luu");

        boolean check = false;
        for (Student student : list) {
            if (student.getName().contains("Luu")) {
                System.out.println(student);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Khong co ten trong danh sach");
        }

        boolean check1 = false;
        for (int i = 0;i < list.size(); i++) {
            if (list.get(i).getName().contains("Luu")) {
                System.out.println("Phần tử có ở trong danh sách: " + list.get(i) + " tại vị trí " + i);
                check1 = true;
            }
        }
        if (!check1) {
            System.out.println("Phan tu k co trong danh sach");
        }

        System.out.println(list + "\n");

    }
}
