package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM implements ATMInterface
{
    Scanner sc = new Scanner(System.in);
    private Card currentCard;
    private Bank currentUser;
    private int remainingPinAttempts;
    private boolean next = false;
    static public ArrayList<Card> cards = new ArrayList<Card>();
    static public ArrayList<Bank> bankAccounts = new ArrayList<>();
    public Card card1 = new Card(478149,2718,113);
    public Card card2 = new Card(623712,4437,532);
    public Card card3 = new Card(139514,9302,222);
    public Card card4 = new Card(131414,1001,414);
    public Card card5 = new Card(757832,2222,659);

    public Bank user1 = new Bank("Danila",1,100, 75954233 ,card1);
    public Bank user2 = new Bank("Vitya",2,1000000000, 745245352,card2);
    public Bank user3 = new Bank("Valera",3,650, 745234246,card3);
    public Bank user4 = new Bank("Vlada",4,1570938, 79533481,card4);
    public Bank user5 = new Bank("Maria",5,99999999, 734241414,card5);
    CheckingExceptions cti = new CheckingExceptions();
    private int checkMethod()
    {
        System.out.println("Для просмотра баланса введите - 1");
        System.out.println("Что бы положить деньги введите - 2");
        System.out.println("Для снятия денег введите - 3");
        System.out.println("Для выхода с терминала введите - 4");
        int method = cti.nextInt();
        return method;

    }
    private int checkPinCode()
    {
        System.out.println("Введите пин-код:");
        int pinCode = cti.nextInt();
        return pinCode;
    }
    private double checkMethodsTwo()
    {
        System.out.println("Введите сумму которую хотите положить:");
        double sum = sc.nextDouble();
        return sum;
    }
    private double checkMethodsThree()
    {
        System.out.println("Введите сумму которую хотите снять:");
        double sum = sc.nextDouble();
        return sum;
    }
    public void system()
    {
        Registion registion = new Registion();
        registion.menu();

        cards.add(card1);
        cards.add(card2);
        bankAccounts.add(user1);
        bankAccounts.add(user2);
        System.out.println("Введите номер карты:");
        int card = cti.nextInt();
        if (card > 0) {
            insertCard(card);
            next = true;
        } else if (card == -1)
        {
            System.out.println("Неправильный ввод данных");
            system();
        }

        for (int i = 0; i <= remainingPinAttempts; i++)
        {
            int pinCode = checkPinCode();
            boolean x = false;
            if(pinCode > 0)
            {
                x = enterPin(pinCode);
            }
            if (x == true) {
                while (currentCard != null)
                {
                    int method = checkMethod();
                    if(method == -1){
                        System.out.println("Неправильный ввод данных");
                        method = checkMethod();
                    }
                    if (method == 1)
                    {
                        System.out.println(checkBalance());
                    } else if (method == 2) {
                        double sum = checkMethodsTwo();
                        if(sum == -1)
                        {
                            System.out.println("Неправильный ввод данных");
                            sum = checkMethodsTwo();
                        }else {
                            deposit(sum);
                        }
                    } else if (method == 3)
                    {
                        double sum = checkMethodsThree();
                        if(sum == -1)
                        {
                            System.out.println("Неправильный ввод данных");
                            sum = checkMethodsThree();
                        }else {
                            withdraw(sum);
                        }
                    } else if (method == 4)
                    {
                        System.out.println("Вы вышли из терминала");
                        ejectCard();
                    }
                }
                return;
            }else
            {
                System.out.println("Неправильный ввод данных");
                pinCode = checkPinCode();
            }
        }
    }
    @Override
    public void insertCard(int cardNumber)
    {
        for(int i = 0; i < cards.size(); i++)
        {
            if(cards.get(i).getCardNumber() == cardNumber)
            {
                currentCard = cards.get(i);
            };
        }
        remainingPinAttempts = 3;
    }

    @Override
    public boolean enterPin(int pin)
    {
        if (currentCard != null && pin == currentCard.getPinCode() && remainingPinAttempts > 0)
        {
            for(int i =0; i < bankAccounts.size(); i++)
            {
                if (bankAccounts.get(i).getUserCard() == currentCard)
                {
                    currentUser = bankAccounts.get(i);
                    System.out.println("Вы успешно вошли в систему");
                    getUser();
                }
            }
            return true;
        } else
        {
            remainingPinAttempts--;
            if (remainingPinAttempts == 0)
            {
                blockCard();
            }
            return false;
        }
    }

    @Override
    public BankInterface getUser()
    {
        System.out.println("Имя: " + currentUser.getUserName());
        return currentUser;
    }

    @Override
    public double checkBalance()
    {
        if (currentUser != null)
        {
            return currentUser.getAccountBalance();
        }
        return 0.0;
    }

    @Override
    public void deposit(double amount)
    {
        double x =currentUser.getAccountBalance();
        if (amount > 0) {
            currentUser.setAccountBalance(x += amount);
            System.out.println("Успешное пополнение " + amount + "На счету: " + x);
        }else {
            System.out.println("Вы ввели недопустимую сумму");
        }
    }

    @Override
    public void withdraw(double amount)
    {
        double x = currentUser.getAccountBalance();
        if (amount > 0 && amount <= x)
        {

            currentUser.setAccountBalance(x -= amount);
            System.out.println("Успешное снятие " + amount + "На счету стало: " + x);
        }else {
            System.out.println("Вы ввели недопустимую сумму");
        }
    }

    @Override
    public void ejectCard()
    {
        currentCard = null;
        currentUser = null;
    }

    @Override
    public void blockCard()
    {
        System.out.println("Вас заблокировали");
        currentCard.setIsBlocked(true);
    }
}