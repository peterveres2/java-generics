package com.epam.generics.typesystem.overriding;

class WordBox<S extends CharSequence> extends Box<String> {
	public WordBox(S t) {
		super(t.toString().toLowerCase());
	}

	public void set(S t) {
		super.set(t.toString().toLowerCase());
	}
	
}
