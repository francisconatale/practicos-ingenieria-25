package ejercicio1;
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
        this.isOpen = false;
    }
    // precondicion: amount > 0 && isOpen
    // postcondicion : cuenta con un balance valido
    @Override
    public void deposit(double amount) {
        assert(amount >= 0 && isOpen);
        balance += amount;
        assert(balance >= 0);
    }
    // precondicion: amount > 0 && amount < balance && isOpen
    // postcondicion : cuenta con un balance valido
    @Override

    public void withdraw(double amount) {
        assert(amount >= 0 && amount <= balance && isOpen);
        balance -= amount;
        assert(balance >= 0);
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
        isOpen = true;
    }
}
