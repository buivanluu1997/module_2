package ss19_string_amp__regex.bai_tap.validate_phone_number;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    private static final String PHONE_NUMBER_REGEX = "^\\([0-9]{2}\\)-\\(0[0-9]{9}\\)$";

    public ValidatePhoneNumber(){}

    public static boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    private static final String[] phoneNumbers = new String[] {"(84)-(0978489648)", "(a8)-(22222222)", "(84)-(22b22222)", "(84)-(9978489648)"};

    public static void main(String[] args) {
        for (String phoneNumber : phoneNumbers) {
            boolean isValid = validate(phoneNumber);
            System.out.println("Số điện thoại: " + phoneNumber + " là hợp lệ: " + isValid);
        }
    }

}
