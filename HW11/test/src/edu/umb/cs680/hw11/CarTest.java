package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CarTest {
	
	
	
	private ArrayList<Car> makeUsedCars() {
		
		ArrayList<Car> usedCars = new ArrayList<Car>();
		
		usedCars.add(new Car("Toyota", "RAV4",     20000,  2019, 10000));
		usedCars.add(new Car("Toyota", "Cool",     50000,  2017, 9000));
		usedCars.add(new Car("Toyota", "RAV0",     5000,   2020, 20000));
		usedCars.add(new Car("Toyota", "RAV1",     15000,  2018, 8000));
		usedCars.add(new Car("Subaru", "TheBest",  100000, 2022, 1000000));
		usedCars.add(new Car("Subaru", "TheWorst", 10,     1900, 1000));
		
		return usedCars;
	}
	
	private String[] carToStringArray(Car car) {
		String[] carArray = {car.getMake() , car.getModel(), Integer.toString(car.getYear())};
		return carArray;
	}

	private String[] carListToMakeArray(ArrayList<Car> carList) {
		ArrayList<String> result = new ArrayList<String>();
		
		for (Car c: carList) {
			result.add(c.getModel());
		}
		
		return result.toArray(new String[result.size()]);
	}
	
	@Test
	void verifyCarEqualityWithMakeModelYear() {
		String[] expected = {"Toyota", "RAV4", "2018"};
		Car actual = new Car("Toyota", "RAV4", 20000, 2018, 10000);
		assertArrayEquals(expected,
				carToStringArray(actual));
	}
	
	@Test
	void MileageComparatorTest() {
		String[] expected = {
				"TheWorst",
				"RAV0",
				"RAV1",
				"RAV4",
				"Cool",
				"TheBest"
		};
		
		ArrayList<Car> usedCars = makeUsedCars();
		
		Collections.sort(usedCars, new MileageComparator());
		
		String[] actual = carListToMakeArray(usedCars);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void YearComparatorTest() {
		String[] expected = {
				"TheWorst",
				"Cool",
				"RAV1",
				"RAV4",
				"RAV0",
				"TheBest"
		};
		
		ArrayList<Car> usedCars = makeUsedCars();
		
		Collections.sort(usedCars, new YearComparator());
		
		String[] actual = carListToMakeArray(usedCars);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void PriceComparatorTest() {
		String[] expected = {
				"TheWorst",
				"RAV1",
				"Cool",
				"RAV4",
				"RAV0",
				"TheBest"
		};
		
		ArrayList<Car> usedCars = makeUsedCars();
		
		Collections.sort(usedCars, new PriceComparator());
		
		String[] actual = carListToMakeArray(usedCars);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void ParetoComparatorTest() {
		String[] expected = {
				"TheWorst",
				"Cool",
				"RAV0",
				"RAV1",
				"RAV4",
				"TheBest"
		};
		
		ArrayList<Car> usedCars = makeUsedCars();
		
		for(Car c: usedCars){
			c.setDominationCount(usedCars); 
		}
		
		Collections.sort(usedCars, new ParetoComparator());
		
		String[] actual = carListToMakeArray(usedCars);
		
		assertArrayEquals(expected, actual);
	}
	

}
