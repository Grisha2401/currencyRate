package org.example;

import java.util.List;

public class CurrencyConverter implements CurrencyRate {

    @Override
    public double convect(double rateIn, double rateUser) {
        return rateIn / rateUser;
    }
}
