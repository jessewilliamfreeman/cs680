package edu.umb.cs680.hw10;

import java.time.LocalDateTime;

public class APFSFile extends APFSElement {

	public APFSFile(APFSDirectory parent, String name, int size, LocalDateTime creationTime, String owner) {
		super(parent, name, size, creationTime, owner);
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

	@Override
	public void accept(APFSVisitor v) {
		v.visit(this);
	}

}
