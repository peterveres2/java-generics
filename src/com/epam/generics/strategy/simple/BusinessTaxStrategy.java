package com.epam.generics.strategy.simple;

public class BusinessTaxStrategy implements TaxStrategy<Business> {

	@Override
	public long calculateTax(Business b) {
		double rate;
		if (isSmall(b)) {
			rate = 0.1;
		} else {
			rate = 0.2;
		}
		return (long) (b.getIncome() * rate);
	}

	private boolean isSmall(Business b) {
		return b.getNumberOfEmployees() < 10 && b.getIncome() < 100000;
	}

}
