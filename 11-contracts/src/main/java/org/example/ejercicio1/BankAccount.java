package org.example.ejercicio1;
// invariante: balance >= 0
public class BankAccount implements IBankAccount {
    private double balance;
    private String accountNumber;
    private boolean isOpen;
    // precondicion: initialDeposit >= 0 && !bankAccounts.contains(accountNumber)
    // postcondicion: cuenta valida

    public BankAccount(String accountNumber, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.isOpen = true;
    }
    // precondicion: amount > 0 && isOpen
    // postcondicion : cuenta con un balance valido
    @Override
    public void deposit(double amount) {
        if(amount < 0) { throw new IllegalArgumentException("no se puede depositar un monto negativo"); }
        if(!isOpen) { throw new IllegalArgumentException("no se puede depositar en una cuenta no habilitada"); }
        balance += amount;
        assert(repOK());
    }
    // precondicion: amount > 0 && amount < balance && isOpen
    // postcondicion : cuenta con un balance valido
    @Override
    public void withdraw(double amount) {
        if(amount < 0) { throw new IllegalArgumentException("no se puede retirar un monto negativo"); }
        if(amount > balance) { throw new IllegalArgumentException("no podes retirar mas dinero que el que tenes");}
        if(!isOpen) { throw new IllegalArgumentException("no se puede retirar en una cuenta no habilitada"); }
        balance -= amount;
        assert(repOK());
    }
    // precondicion: true
    // postcondicion : balance de la cuenta
    @Override
    public double getBalance() {
        return balance;
    }
    // precondicion : true
    // postcondicion : cuenta cerrada
    @Override
    public void close() {
        isOpen = false;
    }
    @Override
    public boolean isOpen() {
        return isOpen;
    }

    public boolean repOK(){
        return balance >= 0;
    }
}
