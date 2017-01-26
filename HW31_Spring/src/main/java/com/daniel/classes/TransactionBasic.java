package com.daniel.classes;

public class TransactionBasic implements Transaction{

	@Override
	public Double payment(Customers k) {
		return k.countCartTotalWorth();
		
	}

}
