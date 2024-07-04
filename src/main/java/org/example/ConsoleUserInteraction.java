package org.example;

import java.util.Scanner;

public class ConsoleUserInteraction implements UserInteractionInterface {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String askForCurrency(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().toUpperCase();    }

    @Override
    public double askForAmount(String prompt) {
        System.out.print(prompt);
        double amount = scanner.nextDouble();
        scanner.nextLine();
        return amount;
    }

    @Override
    public void showResult(double amount, String fromCurrency, double convertedAmount ) {
        System.out.printf("Вы можете поменять %.2f %s %n", convertedAmount, fromCurrency);

    }
}
