package model;

import java.util.ResourceBundle;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Model
public class Tpbank {
    private ResourceBundle languageBundle;

    public Tpbank() {
        languageBundle = ResourceBundle.getBundle("Language");
    }

    public String changeLanguage(int choice) {
        if (choice == 1) {
            languageBundle = ResourceBundle.getBundle("ViLanguage");
            return languageBundle.getString("language_set_to_vietnamese");
        } else {
            languageBundle = ResourceBundle.getBundle("EnLanguage");
            return languageBundle.getString("language_set_to_english");
        }
    }

    public String checkAccountNumber(String accountNumber) {
        if (Pattern.matches("\\d{10}", accountNumber)) {
            return languageBundle.getString("account_valid");
        } else {
            return languageBundle.getString("account_invalid");
        }
    }

    public String checkPassword(String password) {
        if (Pattern.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$", password)) {
            return languageBundle.getString("password_valid");
        } else {
            return languageBundle.getString("password_invalid");
        }
    }

    public String generateCaptcha() {
        Random rand = new Random();
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            captcha.append((char) (rand.nextInt(26) + 'A'));
        }
        return captcha.toString();
    }

    public String checkCaptcha(String captchaInput, String captchaGenerated) {
        if (captchaGenerated.equals(captchaInput)) {
            return languageBundle.getString("captcha_valid");
        } else {
            return languageBundle.getString("captcha_invalid");
        }
    }
}

