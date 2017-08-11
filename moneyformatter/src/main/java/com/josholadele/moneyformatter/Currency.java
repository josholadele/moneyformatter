package com.josholadele.moneyformatter;

/**
 * Created by Oladele on 7/26/17.
 */

public enum Currency {
    //    public static final String USDOLLAR = "USD";
//    public static final String NIGERIANNAIRA = "NGN";
//    public static final String JAPANESEYEN = "JPY";
//
    DEFAULT("", "", "Default", -1),
    NIGERIANNAIRA("₦", "NGN", "Nigerian Naira", 566),
    USDOLLAR("$", "USD", "US Dollar", 0),
    YUAN("$", "CNY", "Chinese Yuan", 0),
    BAHAMIANDOLLAR("$", "BSD", "Bahamian Dollar", 0),
    GBPOUND("£", "GBP", "Great Britain Pound", 0);


    private String symbol;
    private String shortCode;
    private String fullName;
    private int numberCode;

    Currency(String symbol, String shortCode, String fullName, int numberCode) {
        this.symbol = symbol;
        this.shortCode = shortCode;
        this.numberCode = numberCode;
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

    public int getNumberCode() {
        return numberCode;
    }

    public static Currency getCurrencyByShortCode(String shortCode) {
        for (Currency currency : Currency.values()) {
            if (currency.getShortCode().equalsIgnoreCase(shortCode))
                return currency;
        }
        return null;
    }

    public static Currency getCurrencyByNumberCode(int numberCode) {
        for (Currency currency : Currency.values()) {
            if (currency.getNumberCode() == numberCode)
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

