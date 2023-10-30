package org.example;
public class Card
{
    private int cardNumber;
    private int pinCode;
    private int cvv;
    private boolean isBlocked;

    public Card(int cardNumber, int pinCode, int cvv)
    {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.cvv = cvv;
    }

    public int getCardNumber()
    {
        return cardNumber;
    }

    public int getPinCode()
    {
        return pinCode;
    }

    public int getCvv()
    {
        return cvv;
    }
    public boolean getIsBlocked()
    {
        return isBlocked;
    }
    public void setIsBlocked(boolean isBlocked)
    {
        this.isBlocked = isBlocked;
    }
}