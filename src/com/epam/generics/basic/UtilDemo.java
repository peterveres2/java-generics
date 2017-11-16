package com.epam.generics.basic;

public class UtilDemo {

	public static void main(String[] args) {
		Pair<Integer, String> p1 = new OrderedPair<>(1, "apple");
		Pair<Integer, String> p2 = new OrderedPair<>(2, "pear");
		
		Pair<Integer, Integer> p3 = new OrderedPair<>(2, 23);

		boolean same = Util.compare(p1, p2);
		//won't compile: boolean same2 = Util.compare(p1, p3);
		
				
	}
}

class Util {
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}
}

