package com.josholadele.moneyformatter;

/**
 * Created by Oladele on 7/26/17.
 */

public enum Currency {
    //    public static final String USDOLLAR = "USD";
//    public static final String NIGERIANNAIRA = "NGN";
//    public static final String JAPANESEYEN = "JPY";
//
    NIGERIANNAIRA("₦", "NGN", "Nigerian Naira"),
    USDOLLAR("$", "USD", "US Dollar"),
    GBPOUND("£", "GBP", "Great Britain Pound");


    private String symbol;
    private String shortCode;
    private String fullName;

    Currency(String symbol, String shortCode, String fullName) {
        this.symbol = symbol;
        this.shortCode = shortCode;
        this.fullName = fullName;

    }

    public String getSymbol() {
        return symbol;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortCode() {
        return shortCode;
    }

    public static Currency getCurrencyByShortCode(String shortCode) {
        for (Currency currency : Currency.values()) {
            if (currency.getShortCode().equalsIgnoreCase(shortCode))
                return currency;
        }
        return null;
    }

    public static Currency getCurrencsyByShortCode(String shortCode) {
        for (Currency currency : Currency.values()) {
            if (currency.getShortCode().equalsIgnoreCase(shortCode))
                return currency;
        }
        return null;
    }

    public static String getSymbolByShortCode(String shortCode) {
        for (Currency currency : Currency.values()) {
            if (currency.getShortCode().equalsIgnoreCase(shortCode))
                return currency.symbol;
        }
        return "";
    }
}

