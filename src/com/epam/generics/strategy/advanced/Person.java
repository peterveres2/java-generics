package com.epam.generics.strategy.advanced;

public class Person extends TaxPayer<Person> {
	private final int myNumberOfChildren;

	public Person(long income, TaxStrategy<Person> taxStrategy, int numberOfChildren) {
		super(income, taxStrategy);
		myNumberOfChildren = numberOfChildren;
	}

	public int getNumberOfChildren() {
		return myNumberOfChildren;
	}

	@Override
	Person getThis() {
		return this;
	}
	
	
}
