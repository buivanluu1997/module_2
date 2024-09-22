package ss11_dsa_stack_queue.bai_tap.check_palindrome_sd_queue;

public class Main {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        String strPalindrome = "Able was I ere I saw Elba";

        if (palindrome.isPalindrome(strPalindrome)) {
            System.out.println(strPalindrome + " là chuỗi Palindrome");
        } else {
            System.out.println(strPalindrome + " không phải là chuỗi Palindrome");
        }
    }
}
