package com.daniel.classes;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CustomersManual implements Customers {

	private Set<Customer> set = new TreeSet<Customer>((o1,o2) -> Double.compare(o1.cartWorth(), o2.cartWorth()));

	
	
	public Set<Customer> getSet() {
		return set;
	}

	public void setSet(Set<Customer> set) {
		this.set = set;
	}

	public CustomersManual() {
		Product p1 = new Product("Aubergine", 2.5, 2);
		Product p2 = new Product("Windex", 12, 1);
		Product p3 = new Product("Lemon", 3.5, 4);
		Product p4 = new Product("Eggs", 12, 12);
		Set<Product> set1 = new HashSet<>();
		set1.add(p1);
		set1.add(p2);
		Set<Product> set2 = new HashSet<>();
		set2.add(p3);
		set2.add(p4);
		Set<Product> set3 = new HashSet<>();
		set3.add(p1);
		set3.add(p4);
		set.add(new Customer("John", "Bucek", 30.0, set1));
		set.add(new Customer("Mark", "Czubek", 30.0, set2));
		set.add(new Customer("Magda", "Bak", 30.0, set3));
	}

	@Override
	public void addCustomer(Customer K) {
		set.add(K);

	}

	@Override
	public void deleteCustomer(Customer K) {
		set.remove(K);

	}

	@Override
	public void searchCustomerName(String name) {
		System.out.println(set.stream().filter(k -> k.getName().equals(name)).findFirst());

	}

	@Override
	public void searchCustomerSurname(String surname) {
		System.out.println(set.stream().filter(k -> k.getSurname().equals(surname)).findFirst());

	}

	@Override
	public void searchCustomerCash(String cash) {
	
		System.out.println(set.stream().filter(c -> c.getCash().equals(Double.parseDouble(cash))).findFirst().get());

	}

	@Override
	public void sortCustomersByName() {
		Set<Customer> set1 = new TreeSet<Customer>((o1,o2) -> o1.getName().compareTo(o2.getName()));
		set.stream().sorted((k, k1) -> k.getName().compareTo(k1.getName())).forEach(k -> set1.add(k));
		setSet(set1);
	}

	@Override
	public void sortCustomersBySurname() {
		Set<Customer> set1 = new TreeSet<Customer>((o1,o2) -> o1.getSurname().compareTo(o2.getSurname()));
		set.stream().sorted((k, k1) -> k.getName().compareTo(k1.getSurname())).forEach(k -> set1.add(k));
		setSet(set1);

	}

	@Override
	public void sortCustomersByCash() {
		Set<Customer> set1 = new TreeSet<Customer>((o1,o2) -> Double.compare(o1.getCash(), o2.getCash()));
		set.stream().sorted((k, k1) -> Double.compare(k.getCash(), k1.getCash())).forEach(k -> set1.add(k));
		setSet(set1);

	}

	@Override
	public Double countCartTotalWorth() {
		return set.stream().mapToDouble(k -> k.cartWorth()).sum();
		
		

	}

	@Override
	public String toString() {
		return "CustomersManual [set=" + set + "]";
	}
	
	

}
