package com.banking.main;

import java.util.Scanner;

import com.banking.dao.AccountDAO;
import com.banking.model.Account;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AccountDAO accountDAO = new AccountDAO();

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println("   ONLINE BANKING SYSTEM");
            System.out.println("==============================");

            System.out.println("1. Add Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

            case 1:

                System.out.print("Enter Customer Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Account Number: ");
                String accountNumber = scanner.nextLine();

                System.out.print("Enter Initial Balance: ");
                double balance = scanner.nextDouble();

                Account account =
                        new Account(name, accountNumber, balance);

                accountDAO.addAccount(account);

                break;

            case 2:

                accountDAO.viewAccounts();

                break;

            case 3:

                System.out.print("Enter Account Number: ");

                String depositAccount =
                        scanner.nextLine();

                System.out.print("Enter Deposit Amount: ");

                double depositAmount =
                        scanner.nextDouble();

                accountDAO.deposit(
                        depositAccount,
                        depositAmount
                );

                break;

            case 4:

                System.out.print("Enter Account Number: ");

                String withdrawAccount =
                        scanner.nextLine();

                System.out.print("Enter Withdrawal Amount: ");

                double withdrawAmount =
                        scanner.nextDouble();

                accountDAO.withdraw(
                        withdrawAccount,
                        withdrawAmount
                );

                break;

            case 5:

                System.out.println(
                        "Thank You for Using Online Banking System!"
                );

                break;

            default:

                System.out.println("Invalid Choice!");

            }

        } while (choice != 5);

        scanner.close();
    }
}
