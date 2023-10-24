package controller;

public class TpbankController {
    
    public void displayMenu() {
        System.out.println("Tien Phong Bank's Ebank Login System");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int getUserChoice() {
        // Simulate user input here
        return 1;
    }

    public String getUserInput() {
        // Simulate user input here
        return "1234567890";
    }
}

