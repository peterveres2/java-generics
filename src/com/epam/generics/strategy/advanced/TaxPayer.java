package com.epam.generics.strategy.advanced;

public abstract class TaxPayer <T extends TaxPayer<T>> {
	private final long myIncome;
	private final TaxStrategy<T> myTaxStrategy;

	protected TaxPayer(long income, TaxStrategy<T> taxStrategy) {
		myIncome = income;
		myTaxStrategy = taxStrategy;
	}

	public long getIncome() {
		return myIncome;
	}

	public long getTax() {
		return myTaxStrategy.calculateTax(getThis());
	}
	
	abstract T getThis();
}
