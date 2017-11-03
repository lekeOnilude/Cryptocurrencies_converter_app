package com.example.android.cryptocurrenciesconverterapp;

/**
 * Created by GBEMILEKE on 24/10/2017.
 */
public class Cryptocurrency {
    private double mBitcoinPrice;
    private double mEnthereumPrice;
    private String mCountryName;

    public Cryptocurrency(double bitcoinPrice, double ethereumPrice, String countryName){
        mEnthereumPrice = ethereumPrice;
        mBitcoinPrice = bitcoinPrice;
        mCountryName = countryName;
    }
    /*
    return the countries short form names
     */
    public String getShortFormName(){return mCountryName;}

    public double getBitcoinPrice(){return mBitcoinPrice;}

    public double getEnthernetPrice(){return mEnthereumPrice;}

    public String getCountryName(){
        String countryName;
        switch (mCountryName){
            case "NGN":
                countryName = "Nigeria";
                break;
            case "USD":
                countryName = "USA";
                break;
            case "CAD":
                countryName = "Canada";
                break;
            case "EUR":
                countryName = "EU";
                break;
            case "PRC":
                countryName = "China";
                break;
            case "INR":
                countryName = "India";
                break;
            case "ZAR":
                countryName = "South Africa";
                break;
            case "JPY":
                countryName = "Japan";
                break;
            case "BRL":
                countryName = "Brazil";
                break;
            case "IDR":
                countryName = "Indonesia";
                break;
            case "SAR":
                countryName = "Saudi Arabia";
                break;
            case "RUB":
                countryName = "Russia";
                break;
            case "KRW":
                countryName = "South Korea";
                break;
            case "AUD":
                countryName = "Australia";
                break;
            case "TRY":
                countryName = "Turkey";
                break;
            case "ESP":
                countryName = "Spain";
                break;
            case "MXN":
                countryName = "Mexico";
                break;
            case "ARS":
                countryName = "Argentina";
                break;
            case "GBP":
                countryName = "Britain";
                break;
            case "AED":
                countryName = "UAE";
                break;
            default: countryName = "Unknown";
                break;
        }
        return countryName;}


    public int getCountryFlag(){
        int countryFlag = 0;
        switch (mCountryName){
            case "NGN":
                countryFlag = R.drawable.ng;
                break;
            case "USD":
                countryFlag = R.drawable.us;
                break;
            case "CAD":
                countryFlag = R.drawable.ca;
                break;
            case "EUR":
                countryFlag = R.drawable.eu;
                break;
            case "PRC":
                countryFlag = R.drawable.cn;
                break;
            case "INR":
                countryFlag = R.drawable.in;
                break;
            case "ZAR":
                countryFlag = R.drawable.za;
                break;
            case "JPY":
                countryFlag = R.drawable.jp;
                break;
            case "BRL":
                countryFlag = R.drawable.br;
                break;
            case "IDR":
                countryFlag = R.drawable.id;
                break;
            case "SAR":
                countryFlag = R.drawable.sa;
                break;
            case "RUB":
                countryFlag = R.drawable.ru;
                break;
            case "KRW":
                countryFlag = R.drawable.kr;
                break;
            case "AUD":
                countryFlag = R.drawable.au;
                break;
            case "TRY":
                countryFlag = R.drawable.tr;
                break;
            case "ESP":
                countryFlag = R.drawable.es;
                break;
            case "MXN":
                countryFlag = R.drawable.mx;
                break;
            case "ARS":
                countryFlag = R.drawable.ar;
                break;
            case "GBP":
                countryFlag = R.drawable.gb;
                break;
            case "AED":
                countryFlag = R.drawable.ae;
                break;
        }
        return countryFlag;}
}
