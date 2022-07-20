package hospital.utils;

import java.util.regex.Pattern;

public class RegexCheck {
    public static boolean isCorrectTypeDate(String date) {
        String FORMAT_DAY = "^(([0-2]\\d|)|(3)[0-1])/(((0)[1-9])|((1)[0-2]))/(((19)[3-9]\\d)|((20)\\d{2}))$";
        return Pattern.matches(FORMAT_DAY, date);
    }

    public static boolean isBiggerDate(String dateOut, String dateIn) {
        return HandleData.converterStringToLocalDate(dateOut).isAfter(HandleData.converterStringToLocalDate(dateIn));
    }
    public static boolean isCorrectVip(String vip) {
        return vip.equalsIgnoreCase("I") ||
                vip.equalsIgnoreCase("II") ||
                vip.equalsIgnoreCase("III");
    }

    public static boolean isCorrectIdMedical(String id) {
        String FORMAT_ID_MEDICAL = "^[Bb][aA]-\\d{3}$";
        return Pattern.matches(FORMAT_ID_MEDICAL, id);
    }

    public static boolean isCorrectIdPatient(String id) {
        String FORMAT_ID_PATIENT = "^[Bb][nN]-\\d{3}$";
        return Pattern.matches(FORMAT_ID_PATIENT, id);
    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException | NullPointerException e){
            return false;
        }
        return true;
    }
}
