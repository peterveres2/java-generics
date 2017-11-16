package com.epam.generics.strategy.simple;

public interface TaxStrategy<T extends TaxPayer> {
	long calculateTax(T t);
}
