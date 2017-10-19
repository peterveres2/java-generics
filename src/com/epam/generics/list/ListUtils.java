package com.epam.generics.list;


public class ListUtils {
	public static Object[] reverse(Object[] array) {
		Object[] result = new Object[array.length];
		for (int i = 0; i < array.length; i++) {
			result[array.length - 1 - i] = array[i];
		}
		return result;
	}

	public static MinimaList reverse(MinimaList list) {
		MinimaList result = new MinimaList();
		for (int i = 0; i < list.size(); i++) {
			result.add(list.get(list.size() - 1 - i));
		}
		return result;
	}

	public static void inPlaceReverse(MinimaList list) {
		MinimaList tmp = reverse(list);
		list.clear();
		list.addAll(tmp);
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
