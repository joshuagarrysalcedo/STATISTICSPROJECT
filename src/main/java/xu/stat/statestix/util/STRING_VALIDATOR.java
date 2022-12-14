package xu.stat.statestix.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class STRING_VALIDATOR {
    private STRING_VALIDATOR() {
    }
    public static boolean email_Validator(String email){
        String regex = "[A-Za-z]{1}.*@[A-Za-z]+\\.com";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        boolean b = m.matches();


        return b;
    }
}
