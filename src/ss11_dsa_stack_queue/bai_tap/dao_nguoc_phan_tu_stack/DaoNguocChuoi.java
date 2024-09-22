package ss11_dsa_stack_queue.bai_tap.dao_nguoc_phan_tu_stack;

import java.util.Stack;

public class DaoNguocChuoi {
    public static void main(String[] args) {
        Stack<String> wStack = new Stack<>();

        String str = "Hello World";
        System.out.println("Chuỗi ban đầu là: \n" + str);
        String[] mWord = str.split("");

        for (int i = 0; i < mWord.length; i++) {
            wStack.push(mWord[i]);
        }

        for (int i = 0; i < mWord.length; i++) {
            if (!wStack.empty()) {
                mWord[i] = wStack.pop();
            }
        }

        String outp = "";
        for (String item : mWord) {
            outp += item;
        }
        System.out.println("Chuỗi sau khi lấy ra ở stack: \n" + outp);

    }
}
