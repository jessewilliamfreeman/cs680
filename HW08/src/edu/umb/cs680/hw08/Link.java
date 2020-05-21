package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class Link extends FSElement {
	
	private FSElement target;

	public Link(Directory parent, String name, LocalDateTime creationTime, FSElement target) {
		super(parent, name, 0, creationTime);
		this.target = target;
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

	public FSElement getTarget() {
		return target;
	}


}
