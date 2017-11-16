package com.epam.generics.basic;

import java.util.HashMap;
import java.util.Map;

public class GenericsTypeUsageDemo {
	
	public static void main(String[] args) {
		
		Map<String, Number> numbers = new HashMap<>();
		// String -> Integer
		numbers.put("one", 1);
		// String -> Double
		numbers.put("pi", Math.PI);
		Number pi = numbers.get("pi");

		// wrong type for key
		// -> compile error: 
		//numbers.put(3, 3);
		// wrong type for value
		// -> compile error: 
		//numbers.put("pi", "3.14");
		// wrong type for returned value
		// -> compile error: 
		//LocalDate d = (LocalDate) numbers.get("pi");
		
		
		// This does not compile!
		// returns Number, not Double; solution: use a cast
		// -> compile error: 
		// Double doublePi = numbers.get("pi");
		
		// This compiles (and returns null)!
		//Number pi2 = numbers.get(Math.PI);
		
	}
}
