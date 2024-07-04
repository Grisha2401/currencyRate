package org.example;

public class Main {
    public static void main(String[] args) {
        CurrencyConverterApp currencyConverterApp = new CurrencyConverterApp(new ConsoleUserInteraction(),
                new CurrencyConverter(),
                new JsonFileExchangeRateProvider());
        currencyConverterApp.run();
    }

}