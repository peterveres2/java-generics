package com.epam.generics.basic;

/**
 * 
 * 
 */
public class BoxDemo {
	public static void main(String[] args) {
		Box<String> stringBox = new Box<>();
		stringBox.set("Generics is fun");
		
	}
}

/**
 * Generic version of the Box class.
 * 
 * @param <T>
 *            the type of the value being boxed
 */
class Box<T> {
	// T stands for "Type"
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}
}
