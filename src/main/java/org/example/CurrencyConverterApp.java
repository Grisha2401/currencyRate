package org.example;

public class CurrencyConverterApp {
    private final UserInteractionInterface userInteraction;
    private final CurrencyConverter currencyConverter;
    private  final JsonFileExchangeRateProvider jsonFileExchangeRateProvider;

    public CurrencyConverterApp(UserInteractionInterface userInteraction, CurrencyConverter currencyConverter, JsonFileExchangeRateProvider jsonFileExchangeRateProvider) {
        this.userInteraction = userInteraction;
        this.currencyConverter = currencyConverter;
        this.jsonFileExchangeRateProvider = jsonFileExchangeRateProvider;
    }

    public void run() {
        while (true) {
            System.out.print("Введите сумму которую хотите поменять: ");

            var amount = userInteraction.askForAmount();

            System.out.print("Введиту валюту Например usd : ");

            var fromCurrency = userInteraction.askForCurrency();

            userInteraction.showResult(amount, fromCurrency, currencyConverter.convectRate(amount, jsonFileExchangeRateProvider.getRate(fromCurrency)));
        }
    }

}
