package ss19_string_amp__regex.bai_tap.validate_lop_hoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameClass {
    private final String NAME_CLASS_REGEX = "^(C|A|P)[0-9]{4}(G|H|I|K)$";

    public NameClass(){}

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(NAME_CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
