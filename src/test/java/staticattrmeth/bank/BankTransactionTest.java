package staticattrmeth.bank;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BankTransactionTest {

    @Test
    void testOneTransaction() {
        //Given
        BankTransaction.initTheDay();
        BankTransaction bankTransaction = new BankTransaction(10_000);
        //Then
        assertEquals(10_000L, bankTransaction.getTransactionValue());
        assertEquals(10_000L, BankTransaction.getCurrentMinValue());
        assertEquals(10_000L, BankTransaction.getCurrentMaxValue());
        assertEquals(new BigDecimal("10000"), BankTransaction.getSumOfTransactions());
        assertEquals(10_000, BankTransaction.getAverageOfTransaction());
    }

    @Test
    void testSeveralTransactions() {
        //Given
        BankTransaction.initTheDay();
        new BankTransaction(10_000);
        new BankTransaction(20_000);
        //Then
        assertEquals(10_000L, BankTransaction.getCurrentMinValue());
        assertEquals(20_000L, BankTransaction.getCurrentMaxValue());
        assertEquals(new BigDecimal("30000"), BankTransaction.getSumOfTransactions());
        assertEquals(15_000, BankTransaction.getAverageOfTransaction());
    }

    @Test
    void testZeroTransaction() {
        //Given
        BankTransaction.initTheDay();
        //Then
        assertEquals(0L, BankTransaction.getCurrentMinValue());
        assertEquals(0L, BankTransaction.getCurrentMaxValue());
        assertEquals(new BigDecimal("0"), BankTransaction.getSumOfTransactions());
    }
}