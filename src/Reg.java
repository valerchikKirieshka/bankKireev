package org.example;
import java.util.Scanner;

public class Registion
{
    org.example.ATM atm = new org.example.ATM();

    Scanner cr = new Scanner(System.in);
    public void menu()
    {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1-Зарегистрироваться");
        System.out.println("2-Войти");
        int metod = cr.nextInt();
        if (metod==1){
            System.out.println("Введите ваше имя: ");
            String name= cr.next();
            System.out.println("Введите номер телефона: ");
            numberPhone();
            System.out.println("Придумайте пароль: ");
            pasword();
        }else if (metod==2){
            System.out.println("Введите номер телефона: ");
            long number = cr.nextLong();
            org.example.Bank numberPhone;
        }

    }
    public void numberPhone()
    {
        System.out.print("+");
        long numberPhone = cr.nextLong();
    }
    public void pasword()
    {
        int pasword = cr.nextInt();
    }
}
