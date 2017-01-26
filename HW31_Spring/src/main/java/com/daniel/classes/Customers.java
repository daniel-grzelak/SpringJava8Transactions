package com.daniel.classes;

public interface Customers {

	void addCustomer(Customer K);
	void deleteCustomer(Customer K);
	void searchCustomerName(String name);
	void searchCustomerSurname(String surname);
	void searchCustomerCash(String cash);
	void sortCustomersByName();
	void sortCustomersBySurname();
	void sortCustomersByCash();
	Double countCartTotalWorth();
	
}
