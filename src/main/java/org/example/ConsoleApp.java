package org.example;

import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount("Uche", "101");
        bankAccount.showMenu();
    }
}

// A class depicting a bank account
class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    // Having out constructor
    BankAccount (String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    // method to get amount deposited and current balance
    void deposit(int amount) {
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    // method to get amount withdrawn and current balance
    void withdrawal (int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    // method to get print out amount deposited and withdrawn
    void getPreviousTransaction () {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No recent transaction");
        }
    }

    void showMenu () {
        // Initializing a char variable
        char option = '\0';

        // Getting user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your customer ID is " + customerId);
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

        // A loop
        do {
            System.out.println();
            System.out.println("Enter an option");
            option = scanner.next().charAt(0);
            System.out.println(); // prints newline

            switch (option) {
                case 'A':
                    System.out.println("Balance = " + balance);
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("Enter an amount to deposit");
                    System.out.println();
                    // using the scanner method to get amount
                    int amount = scanner.nextInt();
                    // calling deposit method
                    deposit(amount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("Enter amount to withdraw");
                    System.out.println();
                    // using the scanner method to get amount
                    int amount2 = scanner.nextInt();
                    // calling withdrawal function
                    withdrawal(amount2);
                    System.out.println();
                    break;

                case 'D':
                    // calling the getPreviousTransaction method
                    getPreviousTransaction();
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("*************************************");
                    break;

                default:
                    System.out.println("Invalid option! Please enter again");
                    break;
            }

        } while (option != 'E');
        System.out.println("Thank you for trusting us!");
    }

}