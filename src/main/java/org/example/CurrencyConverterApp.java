package org.example;

public class CurrencyConverterApp {
    private final UserInteractionInterface userInteraction;
    public final CurrencyConverter currencyConverter;
    public final  JsonFileExchangeRateProvider jsonFileExchangeRateProvider;

    public CurrencyConverterApp(UserInteractionInterface userInteraction, CurrencyConverter currencyConverter, JsonFileExchangeRateProvider jsonFileExchangeRateProvider) {
        this.userInteraction = userInteraction;
        this.currencyConverter = currencyConverter;
        this.jsonFileExchangeRateProvider = jsonFileExchangeRateProvider;
    }

    public void run() {
        var amount = userInteraction.askForAmount("Введите сумму которую хотите поменять: ");

        var fromCurrency = userInteraction.askForCurrency("Введиту валюту Например usd : ");

        userInteraction.showResult(amount, fromCurrency, currencyConverter.convect(amount,jsonFileExchangeRateProvider.getRate(fromCurrency)));
    }

}
