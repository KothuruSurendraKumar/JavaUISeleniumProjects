package com.oops;

public class EncpasulationExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount b = new BankAccount("SBI123",5000);
		b.deposit(2000);
		System.out.println("Balance after deposit :"+b.getBalance());
		b.withdraw(5000);
		System.out.println("Balance after withdrwal :"+b.getBalance());
		b.withdraw(5000);
		

	}

}


