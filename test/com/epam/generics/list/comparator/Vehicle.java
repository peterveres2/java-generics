package com.epam.generics.list.comparator;

public abstract class Vehicle implements Comparable<Vehicle> {
	private final int maxSpeed;
	private final int horsePowers;

	protected Vehicle(int maxSpeed, int horsePowers) {
		this.maxSpeed = maxSpeed;
		this.horsePowers = horsePowers;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public int getHorsePowers() {
		return horsePowers;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ", maxSpeed: " + maxSpeed
				+ ", hp: " + horsePowers;
	}

	@Override
	public int compareTo(Vehicle o) {
		return Integer.compare(this.getMaxSpeed(), o.getMaxSpeed());
	}
}
