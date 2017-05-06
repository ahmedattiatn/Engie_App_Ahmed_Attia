package ahmedattia.engieapplicationbyahmedatia.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ahmed Attia on 06/05/2017.
 */

public class SignUpActivityPresenter {


    public boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }


}
