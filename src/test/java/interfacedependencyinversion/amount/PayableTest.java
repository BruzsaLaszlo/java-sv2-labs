package interfacedependencyinversion.amount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayableTest {

    @Test
    void amountTest() {

        Payable amount = new Amount();
        assertEquals(1111, amount.getPayableAmount(1111));

    }

    @Test
    void bankAtmTest() {

        Payable atm = new BankAtm();
        assertEquals(2000,atm.getPayableAmount(1111));

    }

    @Test
    void cashTest() {

        Payable cash = new Cash();
        assertEquals(1110,cash.getPayableAmount(1111));
        assertEquals(1235,cash.getPayableAmount(1234));
        assertEquals(5555,cash.getPayableAmount(5555));


    }

}