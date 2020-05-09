package edu.umb.cs680.hw03;

import edu.umb.cs680.hw03.StudentStatus;

public class Student {
	
	private StudentStatus status;
	private float         tuition;
	private int           i20num, yrsInState;
	private String        name, usAddr, foreignAddr;
	
	protected Student(
			String        name, 
			String        usAddr, 
			int           yrsInState, 
			int           i20num,
			String        foreignAddr,
			StudentStatus status) {
		
		this.name        = name;
		this.usAddr      = usAddr;
		this.yrsInState  = yrsInState;
		this.i20num      = i20num;
		this.foreignAddr = foreignAddr;
		this.status      = status;
	}

	public StudentStatus getStatus() {
		return status;
	}

	public float getTuition() {
		return tuition;
	}

	public int getI20num() {
		return i20num;
	}

	public int getYrsInState() {
		return yrsInState;
	}

	public String getName() {
		return name;
	}

	public String getUsAddr() {
		return usAddr;
	}

	public String getForeignAddr() {
		return foreignAddr;
	}
}
