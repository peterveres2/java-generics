package com.epam.generics.list;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import com.epam.generics.list.comparator.Car;
import com.epam.generics.list.comparator.Lorry;
import com.epam.generics.list.comparator.LorryByLoadComparator;
import com.epam.generics.list.comparator.VehicleBySpeedComparator;



public class MinimaListTest {
	private final MinimaList listUnderTest = new MinimaList();

	@Test
	public void testNewArrayIsEmpty() {
		assertEmpty();
	}

	private void assertEmpty() {
		assertThat(listUnderTest.isEmpty(), is(true));
		assertThat(listUnderTest.size(), is(0));
	}

	@Test
	public void testAdd() {
		listUnderTest.add("hello");
		assertThat(listUnderTest.isEmpty(), is(false));
		assertThat(listUnderTest.size(), is(1));
	}

	@Test
	public void testClear() {
		listUnderTest.add("hello");
		listUnderTest.clear();
		assertEmpty();
	}

	@Test
	public void testAddAll() {
		listUnderTest.add("Hello");
		listUnderTest.add("world!");

		MinimaList more = new MinimaList();
		more.add("Java");
		more.add("is");
		more.add("cool.");

		listUnderTest.addAll(more);

		assertThat(listUnderTest.toString(),
				is("[Hello, world!, Java, is, cool.]"));
	}

	@Test
	public void testAddAllWithSubtype() {
		MinimaList numbers = new MinimaList();
		numbers.add(1);
		numbers.add(2.0f);

		MinimaList more = new MinimaList();
		more.add(3.0d);

		numbers.addAll(more);

		assertThat(numbers.toString(), is("[1, 2.0, 3.0]"));
	}

	@Test(expected = NoSuchElementException.class)
	public void testIterator() {
		listUnderTest.add("hello");
		Iterator iterator = listUnderTest.iterator();
		assertThat(iterator.hasNext(), is(true));
		assertEquals("hello", iterator.next());
		assertThat(iterator.hasNext(), is(false));
		System.out.println("Should fail: " + iterator.next());
	}

	@Test
	public void testEquals() {
		listUnderTest.add("hello");
		listUnderTest.add("world");
		MinimaList other = new MinimaList();
		other.add("hello");
		assertThat(listUnderTest.equals(other), is(false));
		other.add("world");
		assertThat(listUnderTest.equals(other), is(true));
	}

	@Test
	public void testToArray() {
		listUnderTest.add("hello");
		listUnderTest.add("world");
		Object[] array = listUnderTest.toArray();
		assertThat(array.length, is(2));
		assertEquals("hello", array[0]);
		assertEquals("world", array[1]);
	}

	@Test
	public void testSortLorriesBySpeed() {
		Lorry smallTruck = new Lorry(300, 500, 5_000);
		Lorry midTruck = new Lorry(500, 700, 8_000);
		Lorry bigTruck = new Lorry(1_000, 1_000, 12_000);
		MinimaList lorries = new MinimaList();
		lorries.add(midTruck);
		lorries.add(bigTruck);
		lorries.add(smallTruck);
		lorries.sort(new LorryByLoadComparator());
		assertEquals(smallTruck, lorries.get(0));
		assertEquals(midTruck, lorries.get(1));
		assertEquals(bigTruck, lorries.get(2));
	}

	@Test
	public void testSortCarsBySpeed() {
		Car ferrari = new Car(300, 500, 2);
		Car stone = new Car(0, 0, 0);
		Car suzuki = new Car(130, 70, 5);
		MinimaList cars = new MinimaList();
		cars.add(ferrari);
		cars.add(stone);
		cars.add(suzuki);
		cars.sort(new VehicleBySpeedComparator());
		assertEquals(stone, cars.get(0));
		assertEquals(suzuki, cars.get(1));
		assertEquals(ferrari, cars.get(2));
	}

	@Test
	public void testAddDoublesToNumberList() {
		MinimaList numbers = new MinimaList();
		numbers.add(1);
		numbers.add(2.0f);
		numbers.add(3.0d);
		assertEquals(1, numbers.get(0));
		assertEquals(2.0f, numbers.get(1));
		assertEquals(3.0d, numbers.get(2));

		MinimaList doubles = new MinimaList();
		doubles.add(4.0d);

		numbers.addAll(doubles);

		assertEquals(4.0d, numbers.get(3));
	}

}
