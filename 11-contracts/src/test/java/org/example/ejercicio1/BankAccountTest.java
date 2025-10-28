package org.example.ejercicio1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    @Test
    public void testDeposit(){}
    @Test
    void testWithdrawWithClosedAccount(){
        BankAccount bankAccount = new BankAccount("123", 500.0);
        bankAccount.close();
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(50));
    };

    @Test
    void testWithdrawWithValidConditions() {
        BankAccount bankAccount = new BankAccount("123", 500.0);
        double mountToWithdrawal = 300.0;
        double expectedBalance = bankAccount.getBalance() - mountToWithdrawal;
        bankAccount.withdraw(mountToWithdrawal);
        double actualBalance = bankAccount.getBalance();
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    void testOneWithdrawWithOpenAccountButInvalidAmount(){
        BankAccount bankAccount = new BankAccount("123", 500.0);
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-1));
    };

    @Test
    void testTwoWithdrawWithOpenAccountButInvalidAmount(){
        BankAccount bankAccount = new BankAccount("123", 500.0);
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(600.0));
    };

    @Test
    void testDepositWithOpenAccountButInvalidAmount(){
        BankAccount bankAccount = new BankAccount("123", 500.0);
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-1));
    };

    @Test
    void testDepositWithClosedAccountButInvalidAmount(){
        BankAccount bankAccount = new BankAccount("123", 500.0);
        bankAccount.close();
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(500.0));
    };

    @Test
    void testDepositWithValidConditions(){
        BankAccount bankAccount = new BankAccount("123", 500.0);
        double amountToDeposit = 500.0;
        double expectedBalance = bankAccount.getBalance() + amountToDeposit;
        bankAccount.deposit(amountToDeposit);
        assertEquals(expectedBalance, bankAccount.getBalance());
    };

    @Test
    void testGetBalance(){
        BankAccount  bankAccount = new BankAccount("123", 500.0);
        double expectedBalance = bankAccount.getBalance();
        assertEquals(expectedBalance, bankAccount.getBalance());
    }
    @Test
    void testCloseAccount(){
        BankAccount bankAccount = new BankAccount("123", 500.0);
        bankAccount.close();
        assertFalse(bankAccount.isOpen());
    }
}
