package edu.umb.cs680.hw12;

import java.time.LocalDateTime;

public abstract class APFSElement extends FSElement {
	
	protected String        owner;
	protected LocalDateTime lastModified;
	
	public abstract void accept(APFSVisitor v);

	public APFSElement(APFSDirectory parent, String name, int size, LocalDateTime creationTime, String owner) {
		super(parent, name, size, creationTime);
		
		this.owner        = owner;
		this.lastModified = creationTime;
		
		if (parent != null) {
			parent.appendChild(this);
		}
		
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

}
