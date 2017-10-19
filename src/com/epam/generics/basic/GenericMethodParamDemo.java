package com.epam.generics.basic;

public class GenericMethodParamDemo<T> {
	private T value;
	
	
	
	public GenericMethodParamDemo(T value) {
		super();
		this.value = value;
	}



	public T getValue() {
		return value;
	}
	
}
