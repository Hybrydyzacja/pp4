package pl.azieba.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pl.azieba.creditcard.CreditCantBeModifiedException;
import pl.azieba.creditcard.CreditCard;
import pl.azieba.creditcard.NotEnoughFoundsException;

import java.math.BigDecimal;


public class CreditCardTest {

    @Test
    void itAllowsToAssignCreditLimit() {
        //Arrange
        CreditCard card = new CreditCard("1234644");
        //Act
        card.assignCreditLimit(BigDecimal.valueOf(1000));
        //Assert
        assert BigDecimal.valueOf(1000).equals(card.getBalance());

    }

    @Test
    void itAllowsToAssignCreditLimit2() {
        //Arrange
        CreditCard card = new CreditCard("1234644");
        //Act
        card.assignCreditLimit(BigDecimal.valueOf(2000));
        //Assert
        assertEquals(BigDecimal.valueOf(2000),card.getBalance(), "Card balance not match expected value");
//        assert BigDecimal.valueOf(2000).equals(card.getBalance());

    }
//    @Test
//    void isDenyToChangeAlreadyAssignedCredit() {
//        CreditCard card = new CreditCard("1234-56789");
//        card.assignCreditLimit(BigDecimal.valueOf(1000));
//
//        try {
//            card.assignCreditLimit(BigDecimal.valueOf(2000));
//            fail("Exception should be thrown");
//        } catch (CreditCantBeModifiedException a){
//            assertTrue(true);
//        }
//    }


    @Test
    void isDenyToChangeAlreadyAssignedCreditV2() {
        CreditCard card = thereIsExampleCreditCard();
        card.assignCreditLimit(BigDecimal.valueOf(1000));

        // lambda
        // java // (x) -> x * 2
        assertThrows(
                CreditCantBeModifiedException.class,
                () -> card.assignCreditLimit(BigDecimal.valueOf(2000)));
    }

    @Test
    void isAllowsToPayBills() {
        CreditCard card = thereIsExampleCreditCard();
        card.assignCreditLimit(BigDecimal.valueOf(1000));
        card.withdraw(BigDecimal.valueOf(550));

        assertEquals(
                BigDecimal.valueOf(450),
                card.getBalance());
    }

    @Test
    void denyWithdrawBellowCurrentBalance() {
        CreditCard card = thereIsExampleCreditCard();
        card.assignCreditLimit(BigDecimal.valueOf(1000));
        card.withdraw(BigDecimal.valueOf(900));

        assertThrows(
                NotEnoughFoundsException.class,
                () -> card.withdraw(BigDecimal.valueOf(200)));
    }



    private static CreditCard thereIsExampleCreditCard() {
        CreditCard card = new CreditCard("1234-56789");
        return card;
    }

}
