package ss19_string_amp__regex.bai_tap.validate_lop_hoc;

public class ValidateClassNameTest {
    private static final String[] validName = new String[] {"C0223G", "A0323K"};
    private static final String[] invalidName = new String[] {"M0318G", "P0323A"};

    public static void main(String[] args) {
        ValidateClassName nameClass = new ValidateClassName();

        for (String name : validName) {
            boolean isValid = nameClass.validate(name);
            System.out.println("Name class: " + name + " is valid: " + isValid);
        }

        for (String name : invalidName) {
            boolean isValid = nameClass.validate(name);
            System.out.println("Name class: " + name + " is valid: " + isValid);
        }
    }
}
