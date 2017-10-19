package com.epam.generics.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinimaList implements Iterable {
	private final Object[] myArray = new Object[100];
	private int myElementCount = 0;

	public void add(Object o) {
		myArray[myElementCount] = o;
		myElementCount++;
	}

	public void clear() {
		myElementCount = 0;
	}

	public void addAll(MinimaList otherList) {
		for (Iterator iterator = otherList.iterator(); iterator.hasNext();) {
			Object o = iterator.next();
			add(o);
		}
	}

	public boolean isEmpty() {
		return myElementCount == 0;
	}

	public int size() {
		return myElementCount;
	}

	public Object get(int position) {
		return myArray[position];
	}

	@Override
	public Iterator iterator() {
		return new SimpleIterator();
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("[");
		Iterator i = iterator();
		while (i.hasNext()) {
			s.append(i.next());
			if (i.hasNext()) {
				s.append(", ");
			}
		}
		s.append("]");
		return s.toString();
	}

	public Object[] toArray() {
		Object[] copy = new Object[myElementCount];
		System.arraycopy(myArray, 0, copy, 0, myElementCount);
		return copy;
	}

	@Override
	public boolean equals(Object other) {
		boolean areTheSame = false;
		if (other instanceof MinimaList) {
			MinimaList otherList = (MinimaList) other;
			areTheSame = Arrays.deepEquals(this.myArray, otherList.myArray);
		}
		return areTheSame;
	}

	@Override
	public int hashCode() {
		int hash = myElementCount;
		for (int i = 0; i < myElementCount; i++) {
			Object item = myArray[i];
			if (item != null) {
				hash ^= item.hashCode();
			}
		}
		return hash;
	}

	public void sort(Comparator comparator) {
		Arrays.sort(myArray, 0, myElementCount, comparator);
	}

	private class SimpleIterator implements Iterator {
		private int myCurrentIndex = 0;

		@Override
		public boolean hasNext() {
			return myCurrentIndex < MinimaList.this.size();
		}

		@Override
		public Object next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Object item = get(myCurrentIndex);
			myCurrentIndex++;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
