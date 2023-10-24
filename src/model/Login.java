package model;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Login {
    private ResourceBundle languageBundle;
    private Locale currentLocale;

    public Login() {
        currentLocale = Locale.getDefault();
        languageBundle = ResourceBundle.getBundle("Language", currentLocale);
    }

    public void setCurrentLocale(Locale locale) {
        currentLocale = locale;
        languageBundle = ResourceBundle.getBundle("Language", currentLocale);
    }

    public String getLocalizedString(String key) {
        return languageBundle.getString(key);
    }

    public boolean checkValidAccountNumber(String accountNumber) {
        return Pattern.matches("\\d{10}", accountNumber);
    }

    public boolean checkValidPassword(String password) {
        return Pattern.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$", password);
    }

    public boolean checkValidCaptcha(String captchaInput, String captchaGenerated) {
        return captchaGenerated.equals(captchaInput);
    }

    public String generateCaptcha() {
        Random rand = new Random();
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            captcha.append((char) (rand.nextInt(26) + 'A'));
        }
        return captcha.toString();
    }
}



