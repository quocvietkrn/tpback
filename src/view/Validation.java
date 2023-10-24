package view;

import java.util.regex.Pattern;

public class Validation {
    public static boolean isValidAccountNumber(String accountNumber) {
        return Pattern.matches("\\d{10}", accountNumber);
    }

    public static boolean isValidPassword(String password) {
        return Pattern.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$", password);
    }

    public static boolean isValidCaptcha(String captchaInput, String captchaGenerated) {
        return captchaGenerated.equals(captchaInput);
    }
}

