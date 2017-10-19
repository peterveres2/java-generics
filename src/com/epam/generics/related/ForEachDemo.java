package com.epam.generics.related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class ForEachDemo {
	public static void main(String[] args) {
		
		List<String> strings = new ArrayList<>(Arrays.asList("hello", "world", "!"));
		deleteWithForEach(strings);
		System.out.println(strings);
		
		List<String> strings2 = new ArrayList<>(Arrays.asList("hello", "world", "!"));
		deleteWithIterator(strings2);
		System.out.println(strings2);
	}

	private static void deleteWithForEach(List<String> strings) {
		System.out.println("Deleting from " + strings.getClass().toString() + " with foreach");
		try {
			for (String string : strings) {
				if (string.length() == 1) {
					strings.remove(string);
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	private static void deleteWithIterator(List<String> strings) {
		System.out.println("Deleting from " + strings.getClass().toString() + " with iterator");
		for (Iterator<String> iterator = strings.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			if (string.length() == 1) {
				iterator.remove();
			}
		}
	}
}
