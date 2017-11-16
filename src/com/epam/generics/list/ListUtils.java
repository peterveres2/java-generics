package com.epam.generics.list;


public class ListUtils {
	public static Object[] reverse(Object[] array) {
		Object[] result = new Object[array.length];
		for (int i = 0; i < array.length; i++) {
			result[array.length - 1 - i] = array[i];
		}
		return result;
	}

	public static <T> MinimaList<T> reverse(MinimaList<T> list) {
		MinimaList<T> result = new MinimaList<>(list.getType());
		for (int i = 0; i < list.size(); i++) {
			result.add(list.get(list.size() - 1 - i));
		}
		return result;
	}

	public static void inPlaceReverse(MinimaList<?> list) {
		doPlaceReverse(list);
	}
	
	private static <T> void doPlaceReverse(MinimaList<T> list) {
		MinimaList<T> result = reverse(list);
		list.clear();
		list.addAll(result);
	}
	
	
	public static Object max(MinimaList items) {
		Object max = null;
		for (Object item : items) {
			if (max == null || ((Comparable) item).compareTo(max) > 0) {
				max = item;
			}
		}
		return max;
	}

}
