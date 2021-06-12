package io.codingdojo.bankaccount;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankAccount {

	private String accountNumber;
	private double checkingBalance = 0.00;
	private double savingsBalance = 0.00;

	private static int numAccounts;
	private static double totalOverallMoney = 0.00;

	private void generateAccountNumber() {
		accountNumber = String.format("%o", ((long) (Math.random()*(999_999_999L - 0000000000)+0000000000)));
	}
	private static void increaseTotal(double amount) {
		totalOverallMoney+= amount;
	}
	private static void decreaseTotal(double amount) {
		totalOverallMoney-= amount;
	}

	public BankAccount() {
		generateAccountNumber();
		numAccounts++;
	}

	public double getChecking() {
		return this.checkingBalance;
	}

	public double getSavings() {
		return this.savingsBalance;
	}

	public void depositCheckings(double amount) {
		this.checkingBalance+= amount;
		increaseTotal(amount);
	}

	public void depositSavings(double amount) {
		this.savingsBalance+= amount;
		increaseTotal(amount);
	}

	public void withdrawCheckings(double amount) {
		if (this.checkingBalance < amount) {
			System.out.println(String.format("Checkings Balance: $%.2f , Insufficient funds.", this.checkingBalance));
		} else {
			this.checkingBalance-= amount;
			decreaseTotal(amount);
			System.out.println(String.format("Withdrew: $%.2f , Checkings Balance: $%.2f", amount, this.checkingBalance));
		}
	}

	public void withdrawSavings(double amount) {
		if (this.savingsBalance < amount) {
			System.out.println(String.format("Savings Balance: $%.2f - Insufficient Funds", this.savingsBalance));
		} else {
			this.savingsBalance-= amount;
			decreaseTotal(amount);
			System.out.println(String.format("Withdrew: %.2f , Savings Balance: $%.2f", amount, this.savingsBalance));
		}
	}

	public void displayAccounts() {
		System.out.println(String.format("Account Number: %s", this.accountNumber));
		System.out.println(String.format("Checking Balance: $%.2f", this.checkingBalance));
		System.out.println(String.format("Savings Balance:  $%.2f", this.savingsBalance));
	}
}
