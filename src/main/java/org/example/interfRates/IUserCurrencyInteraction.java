package org.example.interfRates;

public interface IUserCurrencyInteraction {

    String askForCurrency();
    double askForAmount();
    void showResult(double amount, String fromCurrency, double convertedAmount);
}
