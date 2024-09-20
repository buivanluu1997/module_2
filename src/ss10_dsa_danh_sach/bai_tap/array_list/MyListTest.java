package ss10_dsa_danh_sach.bai_tap.array_list;

import java.util.List;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add(2, "seven");
        System.out.println("Hiển thị danh sách");
        System.out.println(list.toString());
        System.out.println("Trả về giá trị tại vị trí index:");
        System.out.println(list.remove(1));
        System.out.println("Trả về số số lượng phần tử có trong danh sách:");
        System.out.println(list.size());
        System.out.println("Trả về bản sao của danh sách");
        System.out.println(list.clone());
        System.out.println("Kiểm tra danh sách có chứa phần tử o không");
        System.out.println(list.contains("One"));
        System.out.println("Trả về chỉ số của phần tử đầu tiên bằng o");
        System.out.println(list.indexOf("Three"));
        System.out.println("Thêm vào cuối danh sách");
        System.out.println(list.add("Ten"));
        System.out.println("Trả về phần tử tại vị trí index");
        System.out.println(list.get(2));


    }
}
