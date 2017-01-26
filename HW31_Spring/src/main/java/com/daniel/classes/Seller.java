package com.daniel.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Seller {

	private String name;
	private String surname;
	private Double dailyBalance;

	private Customers customers;

	private Transaction transaction;

	public Seller(String name, String surname, Double dailyBalance, Customers customers, Transaction transaction) {
		super();
		this.name = name;
		this.surname = surname;
		this.dailyBalance = dailyBalance;
		this.customers = customers;
		this.transaction = transaction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Double getDailyBalance() {
		return dailyBalance;
	}

	public void setDailyBalance(Double dailyBalance) {
		this.dailyBalance = dailyBalance;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Double makeTransaction() {
		return	 transaction.payment(customers);
	}

	@Override
	public String toString() {
		return "Seller [name=" + name + ", surname=" + surname + ", dailyBalance=" + dailyBalance + ", customers="
				+ customers + ", transaction=" + transaction + "]";
	}

}
