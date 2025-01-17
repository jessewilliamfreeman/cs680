package edu.umb.cs680.hw10;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFSDirectory extends APFSElement {
	
	private LinkedList<APFSElement> children;

	public APFSDirectory(APFSDirectory parent, String name, LocalDateTime creationTime, String owner) {
		super(parent, name, 0, creationTime, owner);
		children = new LinkedList<APFSElement>();
	}
	
	public LinkedList<APFSElement> getChildren() {
		return this.children;
	}
	
	public void appendChild(APFSElement child) {
		this.children.add(child);
	}
	
	public int countChildren() {
		return children.size();
	}
	
	public LinkedList<APFSDirectory> getSubDirectories() {
		
		LinkedList<APFSDirectory> subDirectories = new LinkedList<APFSDirectory>(); 
		
		for (FSElement child : children) {
			if (child.isDirectory()) {
				subDirectories.add((APFSDirectory) child);
			}
		}
		
		return subDirectories;
	}
	
	public LinkedList<APFSFile> getFiles() {
		
		LinkedList<APFSFile> files = new LinkedList<APFSFile>(); 
		
		for (FSElement child : children) {
			if (!child.isDirectory()) {
				files.add((APFSFile) child);
			}
		}
		
		return files;
	}
	
	public int getTotalSize() {

		int totalSize = 0;
		
		for (APFSFile file : this.getFiles()) {
			totalSize += file.getSize();
		}
		
		for (APFSDirectory subDirectory : this.getSubDirectories()) {
			totalSize += subDirectory.getTotalSize();
		}
		
		return totalSize;
		
	}
	
	@Override
	public boolean isDirectory() {
		return true;
	}

	@Override
	public void accept(APFSVisitor v) {
		v.visit(this);
		for(APFSElement e: children) {
			e.accept(v);
		}
	}

}
