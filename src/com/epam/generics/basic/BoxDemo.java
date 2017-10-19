package com.epam.generics.basic;

/**
 * Generic version of the Box class.
 * 
 * @param <T>
 *            the type of the value being boxed
 */
public class BoxDemo {

}

class Box {
	private Object object;

	public void set(Object object) {
		this.object = object;
	}

	public Object get() {
		return object;
	}
}
