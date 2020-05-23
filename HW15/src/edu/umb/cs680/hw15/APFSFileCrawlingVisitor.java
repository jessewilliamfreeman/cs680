package edu.umb.cs680.hw15;

import java.util.LinkedList;

public class APFSFileCrawlingVisitor implements APFSVisitor {
	
	private LinkedList<APFSFile> files;
	
	public APFSFileCrawlingVisitor() {
		files = new LinkedList<APFSFile>();
	}

	@Override
	public void visit(APFSLink link) {
	}

	@Override
	public void visit(APFSDirectory dir) {
	}

	@Override
	public void visit(APFSFile file) {
		files.add(file);
		
	}

	public LinkedList<APFSFile> getFiles() {
		return files;
	}

}
