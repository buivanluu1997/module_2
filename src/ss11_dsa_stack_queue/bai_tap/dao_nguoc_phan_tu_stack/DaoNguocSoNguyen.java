package ss11_dsa_stack_queue.bai_tap.dao_nguoc_phan_tu_stack;

import java.util.Stack;

public class DaoNguocSoNguyen {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Mảng ban đầu là: ");
        for (int item : array) {
            System.out.print(item + " ");
        }

        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            if (!stack.empty()) {
                array[i] = stack.pop();
            }
        }

        System.out.println("Mảng sau khi lấy ra từ stack và đưa trở lại:");
        for (int item : array) {
            System.out.print(item + " ");
        }

    }
}
