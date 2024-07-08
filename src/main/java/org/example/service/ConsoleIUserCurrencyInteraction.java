package org.example.service;

import org.example.interfRates.IUserCurrencyInteraction;

import java.util.Scanner;

public class ConsoleIUserCurrencyInteraction implements IUserCurrencyInteraction {
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
