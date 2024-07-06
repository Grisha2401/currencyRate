package org.example;

import java.util.List;

public class CurrencyConverter implements CurrencyRate {

    @Override
    public double convectRate(double rateIn, double rateUser) {
        return rateIn / rateUser;
    }
}
