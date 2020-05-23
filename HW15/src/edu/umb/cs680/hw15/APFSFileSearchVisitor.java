package edu.umb.cs680.hw15;

import java.util.LinkedList;

public class APFSFileSearchVisitor implements APFSVisitor {
	
	private String               fileName;
	private LinkedList<APFSFile> foundFiles;


	public APFSFileSearchVisitor(String fileName) {
		this.fileName = fileName;
		foundFiles = new LinkedList<APFSFile>();
	}

	@Override
	public void visit(APFSLink link) {
	}

	@Override
	public void visit(APFSDirectory dir) {
	}

	@Override
	public void visit(APFSFile file) {
		if(file.getName().equals(fileName)){
			foundFiles.add(file);
		}
	}
	
	public LinkedList<APFSFile> getFoundFiles() {
		return foundFiles;
	}

}
