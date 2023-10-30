package org.example;

public interface BankInterface
{
    String getUserName();
    int getAccountId();
    double getAccountBalance();
    void setAccountBalance(double accountBalance);
    Card getUserCard();
}
