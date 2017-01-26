package com.daniel.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CustomersFile implements Customers{

	private static final String P1 = "D://Kapelusznik/OneDrive/Programowanie/Pliki tekstowe/Klienci/p1.txt";
	
	private Set<Customer> set = new TreeSet<>((k, k1) -> k.getSurname().compareTo(k1.getSurname()));

	
	
	public CustomersFile() {
		
		try {
			File f4 = new File(P1);
			Scanner p1 = new Scanner(f4);
			String[] odczyt4 = p1.nextLine().split(";");
			File f5 = new File("D://Kapelusznik/OneDrive/Programowanie/Pliki tekstowe/Klienci/p2.txt");
			Scanner p2 = new Scanner(f5);
			String[] odczyt5 = p2.nextLine().split(";");
			File f6 = new File("D://Kapelusznik/OneDrive/Programowanie/Pliki tekstowe/Klienci/p3.txt");
			Scanner p3 = new Scanner(f6);
			String[] odczyt6 = p3.nextLine().split(";");
			Set<Product> kosz1 = new HashSet<>();
			kosz1.add(new Product(odczyt4[0], Double.parseDouble(odczyt4[1]), Integer.parseInt(odczyt4[2])));
			kosz1.add(new Product(odczyt5[0], Double.parseDouble(odczyt5[1]), Integer.parseInt(odczyt5[2])));
			Set<Product> kosz2 = new HashSet<>();
			
			kosz2.add(new Product(odczyt4[0], Double.parseDouble(odczyt4[1]), Integer.parseInt(odczyt4[2])));
			kosz2.add(new Product(odczyt6[0], Double.parseDouble(odczyt6[1]), Integer.parseInt(odczyt6[2])));
			
			File f1 = new File("D://Kapelusznik/OneDrive/Programowanie/Pliki tekstowe/Klienci/k1.txt");
			Scanner k1 = new Scanner(f1);
			String[] odczyt = k1.nextLine().split(";");
			set.add(new Customer(odczyt[0], odczyt[1], Double.parseDouble(odczyt[2]), kosz1));
			File f3 = new File("D://Kapelusznik/OneDrive/Programowanie/Pliki tekstowe/Klienci/k3.txt");
			Scanner k3 = new Scanner(f3);
			String[] odczyt3 = k3.nextLine().split(";");
			set.add(new Customer(odczyt3[0], odczyt3[1], Double.parseDouble(odczyt3[2]), kosz1));
			p1.close();
			p2.close();
			p3.close();
			k1.close();
			k3.close();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public CustomersFile(Set<Customer> set) {
		super();
		this.set = set;
	}

	
	public Set<Customer> getSet() {
		return set;
	}


	public void setSet(Set<Customer> set) {
		this.set = set;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((set == null) ? 0 : set.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomersFile other = (CustomersFile) obj;
		if (set == null) {
			if (other.set != null)
				return false;
		} else if (!set.equals(other.set))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "KlienciPlik [set=" + set + "]";
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
		System.out.println(set.stream().sorted((k, k1) -> k1.getName().compareTo(k.getName())).filter(k -> k.getName().equals(name)).findFirst());

	}

	@Override
	public void searchCustomerSurname(String surname) {
		System.out.println(set.stream().sorted((k, k1) -> k1.getSurname().compareTo(k.getSurname())).filter(k -> k.getSurname().equals(surname)).findFirst());

	}

	@Override
	public void searchCustomerCash(String cash) {
		System.out.println(set.stream().mapToDouble(k -> k.getCash()).equals(Double.parseDouble(cash)));

	}

	@Override
	public void sortCustomersByName() {
		set.stream().sorted((k, k1) -> k.getName().compareTo(k1.getName())).collect(Collectors.toSet());
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

	
}
