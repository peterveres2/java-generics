package com.epam.generics.strategy.advanced;

public interface TaxStrategy <T extends TaxPayer<T>> {
	long calculateTax(T p);
}
