package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.banking.model.Account;
import com.banking.util.DBConnection;

public class AccountDAO {

    // ADD ACCOUNT
    public void addAccount(Account account) {

        String sql = "INSERT INTO accounts "
                + "(customer_name, account_number, balance) "
                + "VALUES (?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, account.getCustomerName());
            ps.setString(2, account.getAccountNumber());
            ps.setDouble(3, account.getBalance());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Account Added Successfully!");
            }

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    // VIEW ALL ACCOUNTS
    public void viewAccounts() {

        String sql = "SELECT * FROM accounts";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- ACCOUNT DETAILS ---");

            while (rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("account_id")
                        + " | Name: " + rs.getString("customer_name")
                        + " | Account No: "
                        + rs.getString("account_number")
                        + " | Balance: "
                        + rs.getDouble("balance")
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    // DEPOSIT MONEY
    public void deposit(String accountNumber, double amount) {

        String sql =
                "UPDATE accounts SET balance = balance + ? "
                + "WHERE account_number = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setString(2, accountNumber);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Amount Deposited Successfully!");
            } else {
                System.out.println("Account Not Found!");
            }

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    // WITHDRAW MONEY
    public void withdraw(String accountNumber, double amount) {

        String checkSql =
                "SELECT balance FROM accounts "
                + "WHERE account_number = ?";

        String updateSql =
                "UPDATE accounts SET balance = balance - ? "
                + "WHERE account_number = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement check =
                    con.prepareStatement(checkSql);

            check.setString(1, accountNumber);

            ResultSet rs = check.executeQuery();

            if (rs.next()) {

                double balance = rs.getDouble("balance");

                if (balance >= amount) {

                    PreparedStatement update =
                            con.prepareStatement(updateSql);

                    update.setDouble(1, amount);
                    update.setString(2, accountNumber);

                    update.executeUpdate();

                    System.out.println(
                            "Amount Withdrawn Successfully!"
                    );

                    update.close();

                } else {

                    System.out.println(
                            "Insufficient Balance!"
                    );
                }

            } else {

                System.out.println("Account Not Found!");
            }

            rs.close();
            check.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
