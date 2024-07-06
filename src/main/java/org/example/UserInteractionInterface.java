package org.example;

public interface UserInteractionInterface {

    String askForCurrency();
    double askForAmount();
    void showResult(double amount, String fromCurrency, double convertedAmount);
}
