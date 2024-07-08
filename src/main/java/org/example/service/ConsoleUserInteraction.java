package org.example.service;

import org.example.provider.UserInteractionProvider;

import java.util.Scanner;

public class ConsoleUserInteraction implements UserInteractionProvider {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String askForCurrency() {
        return scanner.nextLine().toUpperCase();
    }

    @Override
    public double askForAmount() {
        double amount = scanner.nextDouble();
        scanner.nextLine();
        return amount;
    }

    @Override
    public void showResult(double amount, String fromCurrency, double convertedAmount) {
        System.out.printf("Вы можете поменять %.2f %s %n", convertedAmount, fromCurrency);

    }
}