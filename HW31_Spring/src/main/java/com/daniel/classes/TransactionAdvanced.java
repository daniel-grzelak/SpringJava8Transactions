package com.daniel.classes;

public class TransactionAdvanced extends TransactionBasic{
	
	@Override
	public Double payment(Customers k) {
		if(k.countCartTotalWorth() > 1000.0) {
			return k.countCartTotalWorth() + k.countCartTotalWorth() * 0.05;
		}
		else{
			return k.countCartTotalWorth();
		}
	}

}
