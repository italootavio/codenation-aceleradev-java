package br.com.codenation.paymentmethods;

public class CreditCard implements PriceStrategy{
    public static final Double PERCENTAGE = 0.98;
    @Override
    public Double calculate(Double price) {
        return price * PERCENTAGE;
    }
}
