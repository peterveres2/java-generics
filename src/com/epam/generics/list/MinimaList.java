package com.epam.generics.list;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinimaList<T> implements Iterable<T> {
	private final T[] myArray;
	private int myElementCount = 0;
	private final Class<T> type;
	
	
	@SuppressWarnings("unchecked")
	public MinimaList(Class<T> type) {
		super();
		this.type = type;
		myArray = (T[]) Array.newInstance(type, 100);
	}

	public void add(T o) {
		myArray[myElementCount] = o;
		myElementCount++;
	}

	public void clear() {
		myElementCount = 0;
	}

	public void addAll(MinimaList<? extends T> otherList) {
		for (Iterator<? extends T> iterator = otherList.iterator(); iterator.hasNext();) {
			T o = iterator.next();
			add(o);
		}
	}

	public boolean isEmpty() {
		return myElementCount == 0;
	}

	public int size() {
		return myElementCount;
	}

	public T get(int position) {
		return myArray[position];
	}

	@Override
	public Iterator<T> iterator() {
		return new SimpleIterator();
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("[");
		Iterator<T> i = iterator();
		while (i.hasNext()) {
			s.append(i.next());
			if (i.hasNext()) {
				s.append(", ");
			}
		}
		s.append("]");
		return s.toString();
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] copy = (T[]) Array.newInstance(type, myElementCount);
		System.arraycopy(myArray, 0, copy, 0, myElementCount);
		return copy;
	}

	@Override
	public boolean equals(Object other) {
		boolean areTheSame = false;
		if (other instanceof MinimaList<?>) {
			MinimaList<?> otherList = (MinimaList<?>) other;
			areTheSame = Arrays.deepEquals(this.myArray, otherList.myArray);
		}
		return areTheSame;
	}

	@Override
	public int hashCode() {
		int hash = myElementCount;
		for (int i = 0; i < myElementCount; i++) {
			T item = myArray[i];
			if (item != null) {
				hash ^= item.hashCode();
			}
		}
		return hash;
	}

	public void sort(Comparator<T> comparator) {
		Arrays.sort(myArray, 0, myElementCount, comparator);
	}

	private class SimpleIterator implements Iterator<T> {
		private int myCurrentIndex = 0;

		@Override
		public boolean hasNext() {
			return myCurrentIndex < MinimaList.this.size();
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T item = get(myCurrentIndex);
			myCurrentIndex++;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
