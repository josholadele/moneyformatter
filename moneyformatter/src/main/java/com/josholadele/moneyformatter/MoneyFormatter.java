package com.josholadele.moneyformatter;

import java.text.DecimalFormat;

/**
 * Created by Oladele on 7/26/17.
 */

public class MoneyFormatter {

    static Currency sCurrency = Currency.DEFAULT;
    static double sAmount = 0;
    static String sFormatType = FormatType.SYMBOL;


    public static String format(double amount, String formatType, Currency currency) throws Exception {
        sCurrency = currency;
        sFormatType = formatType;
        sAmount = amount;
        String formattedAmount = new DecimalFormat("#,###.##").format(sAmount);
        String string;
        switch (sFormatType) {
            case FormatType.SHORT_CODE:
                string = sCurrency.getShortCode()
                        + " " + formattedAmount;
                break;
            case FormatType.SYMBOL:
                string = sCurrency.getSymbol()
                        + " " + formattedAmount;
                break;
            default:
                throw new Exception();
        }

        return string;
    }

    public static String format(double amount, String formatType, String currencyCode) throws Exception {
        sCurrency = Currency.getCurrencyByShortCode(currencyCode);
        sFormatType = formatType;
        sAmount = amount;
        String formattedAmount = new DecimalFormat("#,###.##").format(sAmount);
        String string;
        switch (sFormatType) {
            case FormatType.SHORT_CODE:
                string = sCurrency.getShortCode()
                        + " " + formattedAmount;
                break;
            case FormatType.SYMBOL:
                string = sCurrency.getSymbol()
                        + " " + formattedAmount;
                break;
            default:
                throw new Exception();
        }

        return string;
    }
    public static String format(double amount, int numberCode) throws Exception {
        sCurrency = Currency.getCurrencyByNumberCode(numberCode);
        sAmount = amount;
        String formattedAmount = new DecimalFormat("#,###.##").format(sAmount);
        String string;
        switch (sFormatType) {
            case FormatType.SHORT_CODE:
                string = sCurrency.getShortCode()
                        + " " + formattedAmount;
                break;
            case FormatType.SYMBOL:
                string = sCurrency.getSymbol()
                        + " " + formattedAmount;
                break;
            default:
                throw new Exception();
        }

        return string;
    }

    public static String format(double amount, String formatType, int numberCode) throws Exception {
        sCurrency = Currency.getCurrencyByNumberCode(numberCode);
        sFormatType = formatType;
        sAmount = amount;
        String formattedAmount = new DecimalFormat("#,###.##").format(sAmount);
        String string;
        switch (sFormatType) {
            case FormatType.SHORT_CODE:
                string = sCurrency.getShortCode()
                        + " " + formattedAmount;
                break;
            case FormatType.SYMBOL:
                string = sCurrency.getSymbol()
                        + " " + formattedAmount;
                break;
            default:
                throw new Exception();
        }

        return string;
    }
}
