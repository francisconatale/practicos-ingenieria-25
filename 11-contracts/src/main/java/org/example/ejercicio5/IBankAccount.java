package org.example.ejercicio5;

public interface IBankAccount {
  void deposit(double amount);
  void withdraw(double amount);
  double getBalance();
  void close();
  boolean isOpen();
}
