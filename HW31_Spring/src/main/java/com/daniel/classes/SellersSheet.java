package com.daniel.classes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SellersSheet {

	private List<Seller> list;

	public SellersSheet(List<Seller> list) {
		super();
		this.list = list;
	}

	public void addSeller(Seller s) {
		list.add(s);
	}

	public void updateBalance() {
		list.stream().forEach(s -> s.setDailyBalance(s.getDailyBalance() + s.makeTransaction()));
	}

	public Seller biggestBalance() {

		return list.stream().max(new Comparator<Seller>() {
			public int compare(Seller s, Seller s1) {
				return s.getDailyBalance().compareTo(s1.getDailyBalance());
			}
		}).get();
	}

	public Seller smallestBalance() {
		return list.stream().max(new Comparator<Seller>() {
			public int compare(Seller s, Seller s1) {
				return s1.getDailyBalance().compareTo(s.getDailyBalance());
			}
		}).get();
	}

	public void sortDescending() {
		this.list = list.stream().sorted(new Comparator<Seller>() {
			public int compare(Seller s, Seller s1) {
				return s1.getDailyBalance().compareTo(s.getDailyBalance());
			}
		}).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		list.stream().map(s -> s.toString()).forEach(s -> sb.append(s + "\n"));
		return sb.toString();
	}

}
