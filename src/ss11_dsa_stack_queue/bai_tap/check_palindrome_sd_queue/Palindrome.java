package ss11_dsa_stack_queue.bai_tap.check_palindrome_sd_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {

    public Boolean isPalindrome(String palindrome) {
        char[] charArray = palindrome.toLowerCase().toCharArray();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (Character character : charArray) {
            stack.push(character);
            queue.add(character);
        }

        while (!stack.empty()) {
            if (stack.pop() != queue.poll()) {
                return false;
            }
        }
        return true;
    }
}
