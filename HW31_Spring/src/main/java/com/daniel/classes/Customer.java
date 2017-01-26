package com.daniel.classes;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Customer {
	private String name;
	private String surname;
	private Double cash;
	private Set<Product> cart = new HashSet<Product>();
	private static double reduction = 0.4;
	
	public Double cartWorth() {
		
		return cart.stream().map(x -> x.getPrice() * x.getAmount()).reduce((acc, x) -> (acc + x)).get();
		
	}

	

	public Customer(String name, String surname, double cash, Set<Product> cart) {
		super();
		this.name = name;
		this.surname = surname;
		this.cash = cash;
		this.cart = cart;
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



	public Double getCash() {
		return cash;
	}



	public void setCash(Double cash) {
		this.cash = cash;
	}



	public Set<Product> getCart() {
		return cart;
	}



	public void setCart(Set<Product> cart) {
		this.cart = cart;
	}



	public static double getReduction() {
		return reduction;
	}



	public static void setReduction(double reduction) {
		Customer.reduction = reduction;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cash);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Customer other = (Customer) obj;
		if (Double.doubleToLongBits(cash) != Double.doubleToLongBits(other.cash))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Customer [name=" + name + ", surname=" + surname + ", cash=" + cash + ", cart=" + cart + "]";
	}




}
