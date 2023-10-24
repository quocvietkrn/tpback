package view;

import java.util.Locale;
import java.util.Scanner;

import model.Login;
import model.User;

public class Main {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        // Tùy chỉnh Locale theo ngôn ngữ mong muốn
        Locale vietnameseLocale = new Locale("vi", "VN");
        login.setCurrentLocale(vietnameseLocale);

        int choice = 0;
        User user = null; // Khởi tạo đối tượng User

        while (choice != 5) {
            // Hiển thị menu ngôn ngữ
            System.out.println("Menu:");
            System.out.println("1. Set Language");
            System.out.println("2. Enter User Information");
            System.out.println("3. Check User Information");
            System.out.println("4. Generate Captcha");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter language (en/vi): ");
                    String langChoice = scanner.nextLine();
                    Locale locale = new Locale(langChoice);
                    login.setCurrentLocale(locale);
                    break;

                case 2:
                    // Nhập thông tin từ người dùng
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    String captcha = login.generateCaptcha();
                    user = new User(accountNumber, password, captcha);
                    break;

                case 3:
                    // Kiểm tra thông tin người dùng
                    if (user == null) {
                        System.out.println("Please enter user information first.");
                    } else {
                        if (login.checkValidAccountNumber(user.getAccountNumber())) {
                            System.out.println(login.getLocalizedString("account_valid"));
                        } else {
                            System.out.println(login.getLocalizedString("account_invalid"));
                        }

                        if (login.checkValidPassword(user.getPassword())) {
                            System.out.println(login.getLocalizedString("password_valid"));
                        } else {
                            System.out.println(login.getLocalizedString("password_invalid"));
                        }

                        System.out.print("Enter captcha: ");
                        String captchaInput = scanner.nextLine();
                        if (login.checkValidCaptcha(captchaInput, user.getCaptcha())) {
                            System.out.println(login.getLocalizedString("captcha_valid"));
                        } else {
                            System.out.println(login.getLocalizedString("captcha_invalid"));
                        }
                    }
                    break;

                case 4:
                    if (user != null) {
                        // Generate a new captcha for the current user
                        user = new User(user.getAccountNumber(), user.getPassword(), login.generateCaptcha());
                        System.out.println("Generated Captcha: " + user.getCaptcha());
                    } else {
                        System.out.println("Please enter user information first.");
                    }
                    break;
            }
        }

        scanner.close();
    }
}


