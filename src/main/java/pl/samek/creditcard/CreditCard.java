package pl.samek.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private final String cardNumber;

    public CreditCard(String cardNumber){
        this.cardNumber = cardNumber;
    }

    public String getNumber() {
        return cardNumber;
    }

    public BigDecimal getBalance(){
        return null;
    }

    public void assignCredit(BigDecimal bigDecimal) {
    }
}
