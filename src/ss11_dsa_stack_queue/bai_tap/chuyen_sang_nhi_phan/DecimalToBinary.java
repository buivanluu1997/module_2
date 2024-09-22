package ss11_dsa_stack_queue.bai_tap.chuyen_sang_nhi_phan;

import java.util.Stack;

public class DecimalToBinary {

    public static String convertDecimalToBinary(int decimalNumber) {
        Stack<Integer> stack = new Stack<Integer>();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            stack.push(remainder);
            decimalNumber = decimalNumber / 2;
        }

        String binaryString = "";
        while (!stack.empty()) {
            binaryString += stack.pop();
        }
        return binaryString;
    }

    public static void main(String[] args) {
        int decimalNumber = 50;
        String result = convertDecimalToBinary(decimalNumber);
        System.out.println("Số " + decimalNumber + " chuyển về chuỗi nhị phân là: " + result);
    }
}
