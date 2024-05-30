package app;

import java.util.Scanner;

public class Main {

    static double balance;

    public static void main(String[] args) {
        balance = getBalance();
        double withdrawalAmount = getAmount();
        validateAmount(balance, withdrawalAmount);
    }

    private static double getBalance() {
        return 1000.00;
    }

    private static double getAmount() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Balance is USD %.2f.%n" +
                    "Enter purchase amount, USD: ", balance);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException exception) {
                System.out.println("Please, try again and enter the amount: ");
            }
        }
    }

    private static void validateAmount(double balance, double withdrawal) {
        if (withdrawal > balance) {
            try {
                throw new FundsException("Insufficient funds!");
            } catch (FundsException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            balance = getBalance() - withdrawal;
            System.out.printf("Funds are OK. Purchase paid.%nBalance is USD %.2f%n", balance);
        }
    }
}