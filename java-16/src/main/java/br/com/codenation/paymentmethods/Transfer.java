package br.com.codenation.paymentmethods;

public class Transfer implements PriceStrategy {
    public static final Double PERCENTAGE = 0.92;
    @Override
    public Double calculate(Double price) {
        return price * PERCENTAGE;
    }
}
