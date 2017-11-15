package com.epam.generics.typesystem.overloading;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("rawtypes") 
public final class OverloadingLegacy {

	public void overloadedMethod(Collection o) {
		System.out.println(" overloadedMethod (Collection)");
	}

	public void overloadedMethod(List s) {
		System.out.println(" overloadedMethod (List)");
	}

	public void overloadedMethod(ArrayList i) {
		System.out.println(" overloadedMethod (ArrayList)");
	}

	public void method(List t) {
		overloadedMethod(t);
	}

	public static void main(String[] args) {
		OverloadingLegacy test = new OverloadingLegacy();
		test.method(new ArrayList());
	}
}
