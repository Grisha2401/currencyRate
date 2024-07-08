package org.example.provider;

public interface UserInteractionProvider {

    String askForCurrency();
    double askForAmount();
    void showResult(double amount, String fromCurrency, double convertedAmount);
}
