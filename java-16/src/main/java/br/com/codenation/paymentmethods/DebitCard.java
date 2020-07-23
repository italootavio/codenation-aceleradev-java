package br.com.codenation.paymentmethods;

public class DebitCard implements PriceStrategy{
    public static final Double PERCENTAGE = 0.95;
    @Override
    public Double calculate(Double price) {
        return price * PERCENTAGE;
    }
}
