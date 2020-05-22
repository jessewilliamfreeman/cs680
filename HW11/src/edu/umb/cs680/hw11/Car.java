package edu.umb.cs680.hw11;

import java.util.ArrayList;

public class Car {
	
	private String make, model;
	private int mileage, year, dominationCount;
	private float price;
	
	public Car(
		String make, 
		String model,
		int mileage, 
		int year,
		float price
			) {
		
		this.make    = make;
		this.model   = model;
		this.mileage = mileage;
		this.year    = year;
		this.price   = price;
		
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public float getPrice() {
		return price;
	}
	
	public int getDominationCount() {
		return dominationCount;
	}
	
	public void setDominationCount(ArrayList<Car> cars) {
		
		int dominationCount = 0;
		
		YearComparator    y = new YearComparator();
		MileageComparator m = new MileageComparator();
		PriceComparator   p = new PriceComparator();
				
		for(Car c: cars) {
			int yearC  = y.compare(this, c);
			int mileC  = m.compare(this, c);
			int priceC = p.compare(this, c);
			
			boolean notInferior = yearC >= 0 && mileC >= 0 && priceC >= 0;
			boolean isSuperior  = yearC >  0 || mileC >  0 || priceC >  0;
			
			if (isSuperior && notInferior) {
				dominationCount++;
			}
		}
		
		this.dominationCount = dominationCount;
	}

}
