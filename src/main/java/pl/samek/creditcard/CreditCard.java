package pl.samek.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    public static final int CREDIT_THRESHOLD = 100;
    private final String cardNumber;
    private BigDecimal creditLimit;
    private BigDecimal balance;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void assignCredit(BigDecimal creditLimit) {
        if (isCreditAlreadyAssigned()) {
            throw new CreditAlreadyAssignedException();
        }

        if (isCreditBelowThreshold(creditLimit)) {
            throw new CreditBelowThresholdException();
        }

        this.creditLimit = creditLimit;
        this.balance = creditLimit;
    }

    private boolean isCreditAlreadyAssigned() {
        return this.creditLimit != null;
    }

    private static boolean isCreditBelowThreshold(BigDecimal credit) {
        return BigDecimal.valueOf(CREDIT_THRESHOLD).compareTo(credit) > 0;
    }

    public void withdraw(BigDecimal money) {
        if (!canAfford(money)) {
            throw new NotEnoughMoneyException();
        }

        this.balance = this.balance.subtract(money);
    }

    private boolean canAfford(BigDecimal money) {
        return this.balance.subtract(money).compareTo(BigDecimal.ZERO) > 0;
    }

    public Object getNumber() {
        return cardNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
