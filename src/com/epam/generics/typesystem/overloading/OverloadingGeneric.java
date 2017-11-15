package com.epam.generics.typesystem.overloading;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class OverloadingGeneric<T> {
	public void overloadedMethod(Collection<?> things) {
		System.out.println("overloadedMethod(Collection<?>)");
	}

	public void overloadedMethod(List<? extends Number> numbers) {
		System.out.println("overloadedMethod(List<Number>)");
	}

	public void overloadedMethod(ArrayList<Integer> integers) {
		System.out.println("overloadedMethod(ArrayList<Integer>)");
	}

	public void method(List<T> list) {
		overloadedMethod(list);
	}

	public static void main(String[] args) {
		OverloadingGeneric<Integer> test = new OverloadingGeneric<>();
		ArrayList<Integer> integers = new ArrayList<>();
		test.method(integers);
	}
}
