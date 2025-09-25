package com.oops;

public class BankAccount {
	private int balance;
	private String number;
	
	public BankAccount(String number,int balance) {
		this.number = number;
		//balance should be negetive
		if(balance >= 0) {
			this.balance = balance;
		}else {
			this.balance = 0;
		}
	}
	
	public void deposit(int amount) {
		if(amount >0) {
			balance = balance + amount;
			//System.out.println("Balance :"+balance);
		}else {
			System.out.println("amount must be reater than zero");
		}
	}
	
	public int getBalance() {
		return balance;
	}

	

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void withdraw(int amount) {
		if(amount <= balance && amount > 0) {
			balance = balance - amount;
			//System.out.println("After withdrawl "+balance);
		}
		else {
			System.out.println("Amount must greater than 0 and amount exceded");
		}
	}
	
	

}
