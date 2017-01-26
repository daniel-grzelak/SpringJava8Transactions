package com.daniel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.daniel.classes.Customers;
import com.daniel.classes.CustomersManual;
import com.daniel.classes.CustomersFile;
import com.daniel.classes.Seller;
import com.daniel.classes.Transaction;
import com.daniel.classes.TransactionAdvanced;
import com.daniel.classes.TransactionBasic;
import com.daniel.classes.SellersSheet;

@Configuration
@ComponentScan
public class AppConfig {

	@Bean
	Seller seller() {
		String name = "Jan";
		String surname = "Skapy";
		Double dailyBalance = 0.0;
		Seller s = new Seller(name, surname, dailyBalance, customersManual(), transactionBasic());
		return s;
	}
	
	@Bean
	Seller seller1() {
		String name = "Jarek";
		String surname = "Szczodry";
		Double dailyBalance = 30.0;
		return new Seller(name, surname, dailyBalance, customersManual(), transactionAdvanced());
	}
	
	@Bean
	Seller seller2() {
		String name = "Marek";
		String surname = "Biedny";
		Double dailyBalance = 0.0;
		return new Seller(name, surname, dailyBalance, customersFile(), transactionBasic());
	}
	
	@Bean
	Seller seller3() {
		String name = "Czarek";
		String surname = "Biedny";
		Double dailyBalance = 0.0;
		return new Seller(name, surname, dailyBalance, customersFile(), transactionAdvanced());
	}

	@Bean
	public Transaction transactionBasic()
	{
		return new TransactionBasic();
	}
	
	@Bean
	public Transaction transactionAdvanced() 
	{
		return new TransactionAdvanced();
	}
	
	@Bean
	public Customers customersManual() {
		return new CustomersManual();
	}
	
	@Bean
	public Customers customersFile() {
		return new CustomersFile();
	}
	
	
	
	@Bean
	public SellersSheet sellersSheet() {
		List<Seller> sellers = new ArrayList<>();
		sellers.add(seller());
		sellers.add(seller1());
		sellers.add(seller2());
		sellers.add(seller3());
		return new SellersSheet(sellers);
	}
		
}
