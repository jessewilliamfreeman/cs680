package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
	
	private LinkedList<FSElement> children;

	public Directory(Directory parent, String name, LocalDateTime creationTime) {
		super(parent, name, 0, creationTime);
		children = new LinkedList<FSElement>();
	}
	
	public LinkedList<FSElement> getChildren() {
		return this.children;
	}
	
	public void appendChild(FSElement child) {
		this.children.add(child);
	}
	
	public int countChildren() {
		return children.size();
	}
	
	public LinkedList<Directory> getSubDirectories() {
		
		LinkedList<Directory> subDirectories = new LinkedList<Directory>(); 
		
		for (FSElement child : children) {
			if (child.isDirectory()) {
				subDirectories.add((Directory) child);
			}
		}
		
		return subDirectories;
	}
	
	public LinkedList<File> getFiles() {
		
		LinkedList<File> files = new LinkedList<File>(); 
		
		for (FSElement child : children) {
			if (!child.isDirectory()) {
				files.add((File) child);
			}
		}
		
		return files;
	}
	
	public int getTotalSize() {

		int totalSize = 0;
		
		for (File file : this.getFiles()) {
			totalSize += file.getSize();
		}
		
		for (Directory subDirectory : this.getSubDirectories()) {
			totalSize += subDirectory.getTotalSize();
		}
		
		return totalSize;
		
	}
	
	@Override
	public boolean isDirectory() {
		return true;
	}

}
