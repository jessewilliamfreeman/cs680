package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public abstract class FSElement {
	
	protected String        name;
	protected int           size;
	protected LocalDateTime creationTime;
	protected Directory     parent;
	
	public FSElement(
			Directory     parent,
			String        name,
			int           size,
			LocalDateTime creationTime
			) {
		
		this.parent       = parent;
		this.name         = name;
		this.size         = size;
		this.creationTime = creationTime;
		
		if (parent != null) {
			parent.appendChild(this);
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}

	public Directory getParent() {
		return parent;
	}
	
	public abstract boolean isDirectory();
}
