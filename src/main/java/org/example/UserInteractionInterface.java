package org.example;

public interface UserInteractionInterface {

    String askForCurrency(String prompt);
    double askForAmount(String prompt);
    void showResult(double amount, String fromCurrency, double convertedAmount);
}
