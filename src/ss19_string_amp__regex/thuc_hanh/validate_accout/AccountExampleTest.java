package ss19_string_amp__regex.thuc_hanh.validate_accout;

public class AccountExampleTest {
    private static AccountExample accountExample;
    private static final String[] validAccount = new String[] {"123abc_", "_abc123", "______", "123456", "abcdefgh"};
    private static final String[] invaliidAcount = new String[] {".@", "12345", "1234_", "abcde"};

    public static void main(String[] args) {
        accountExample = new AccountExample();

        for (String account : validAccount) {
            boolean isValid = accountExample.validate(account);
            System.out.println("Account is: " + account + " is valid: " + isValid);
        }

        for (String account : invaliidAcount) {
            boolean isValid = accountExample.validate(account);
            System.out.println("Account is: " + account + " is valid: " + isValid);
        }
    }
}
