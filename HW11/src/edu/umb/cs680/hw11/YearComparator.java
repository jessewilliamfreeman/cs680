package edu.umb.cs680.hw11;

import java.util.Comparator;

public class YearComparator implements Comparator<Car>{

	@Override
	public int compare(Car car1, Car car2) {
		// TODO Auto-generated method stub
		return (int) (car1.getYear() - car2.getYear());
	}

}