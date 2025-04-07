package pl.samek.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    @Test
    void itAllowsToAssignCredit() {
        //Arrange
        var card = new CreditCard("1234-4567");
        //Act
        card.assignCredit(BigDecimal.valueOf(1000));
        //Assert
        assertEquals(
                BigDecimal.valueOf(1000),
                card.getBalance()
        );
    }

    @Test
    void itAllowsToAssignCreditV2() {
        //Arrange
        var card = new CreditCard("1234-4567");
        //Act
        card.assignCredit(BigDecimal.valueOf(1200));
        //Assert
        assert BigDecimal.valueOf(1200).equals(card.getBalance());
        assertEquals(
                BigDecimal.valueOf(1200),
                card.getBalance()
        );
    }

    @Test
    void itDenyCreditBelowThresholdV1() {
        var card = new CreditCard("1234-4567");
        try {
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Should throw exception");
        } catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }
    }

    @Test
    void itDenyCreditBelowThresholdV2() {
        var card = new CreditCard("1234-4567");
        //python // lambda x: x + 2
        //java // (x) -> x + 2

        assertThrows(
                CreditBelowThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(10))
        );
        assertDoesNotThrow(
                () -> card.assignCredit(BigDecimal.valueOf(100))
        );
    }

    @Test
    void itDenyCreditReassignment() {
        var card = new CreditCard("1234-4567");
        card.assignCredit(BigDecimal.valueOf(1000));
        assertThrows(
                CreditAlreadyAssignedException.class,
                () -> card.assignCredit(BigDecimal.valueOf(1200))
        );
    }

    @Test
    void itAllowsToWithdrawForSomething() {
        var card = new CreditCard("1234-4567");
        card.assignCredit(BigDecimal.valueOf(1000));

        card.withdraw(BigDecimal.valueOf(900));

        assertEquals(
                BigDecimal.valueOf(100),
                card.getBalance()
        );
    }

    @Test
    void itDenyWhenNotSufficientFounds() {
        var card = new CreditCard("1234-4567");
        card.assignCredit(BigDecimal.valueOf(1000));
        card.withdraw(BigDecimal.valueOf(900));

        assertThrows(
                NotEnoughMoneyException.class,
                () -> card.withdraw(BigDecimal.valueOf(200))
        );
    }


}