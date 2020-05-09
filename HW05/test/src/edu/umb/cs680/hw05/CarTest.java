package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	
	private String[] carToStringArray(Car car) {
		String[] carArray = {car.getMake() , car.getModel(), Integer.toString(car.getYear())};
		return carArray;
	}

	@Test
	void verifyCarEqualityWithMakeModelYear() {
		String[] expected = {"Toyota", "RAV4", "2018"};
		Car actual = new Car("Toyota", "RAV4", 20000, 2018, 10000);
		assertArrayEquals(expected,
				carToStringArray(actual));
	}

}
