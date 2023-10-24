package model;


public class User {
    private String accountNumber;
    private String password;
    private String captcha;

    public User(String accountNumber, String password, String captcha) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.captcha = captcha;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getCaptcha() {
        return captcha;
    }
}
