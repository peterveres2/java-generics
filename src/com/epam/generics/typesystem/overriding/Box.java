package com.epam.generics.typesystem.overriding;

class Box<T> {
	private T theThing;

	public Box(T t) {
		theThing = t;
	}

	public void set(T t) {
		theThing = t;
	}

}
