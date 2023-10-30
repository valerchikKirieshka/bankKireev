package org.example;

public interface ATMInterface
{
    void insertCard(int cardNumber);

    boolean enterPin(int pin);

    BankInterface getUser();

    double checkBalance();

    void deposit(double amount);

    void withdraw(double amount);

    void ejectCard();

    void blockCard();

}