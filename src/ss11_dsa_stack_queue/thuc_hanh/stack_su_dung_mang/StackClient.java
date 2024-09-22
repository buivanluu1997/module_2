package ss11_dsa_stack_queue.thuc_hanh.stack_su_dung_mang;

public class StackClient {
    public static void main(String[] args) throws Exception {
        MyStack stack = new MyStack(5);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println("kich thuoc sau khi day: " + stack.size());
        System.out.println("Lấy phần tử từ ngăn xếp:");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("kich thuoc ngan xep sau thao tac pop: " + stack.size());
    }
}
