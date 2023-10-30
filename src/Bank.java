package org.example;

public class Bank implements BankInterface
{
    private String userName;
    private int accountId;
    private double accountBalance;
    private long numberPhone;
    private Card userCard;
    public Bank(String userName, int accountId, double accountBalance, long numberPhone , Card userCard)
    {
        this.userName = userName;
        this.accountId = accountId;
        this.accountBalance = accountBalance;
        this.userCard = userCard;
        this.numberPhone = numberPhone;
    }

    @Override
    public String getUserName()
    {
        return userName;
    }

    @Override
    public int getAccountId()
    {
        return accountId;
    }

    @Override
    public double getAccountBalance()
    {
        return accountBalance;
    }
    @Override
    public Card getUserCard()
    {
        return userCard;
    }
    @Override
    public void setAccountBalance(double accountBalance)
    {
        this.accountBalance = accountBalance;
    }
}