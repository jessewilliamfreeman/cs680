package edu.umb.cs680.hw15;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class APFSDirectory extends APFSElement {
	
	private LinkedList<APFSElement> children;

	public APFSDirectory(APFSDirectory parent, String name, LocalDateTime creationTime, String owner) {
		super(parent, name, 0, creationTime, owner);
		children = new LinkedList<APFSElement>();
	}
	
	public LinkedList<APFSElement> getChildren() {
		return this.getChildren(Comparator.comparing(APFSElement::getName));
	}
	
	public LinkedList<APFSElement> getChildren(Comparator<APFSElement> c) {
		Collections.sort(this.children, c);
		return this.children;
	}
	
	public void appendChild(APFSElement child) {
		this.children.add(child);
	}
	
	public int countChildren() {
		return children.size();
	}

	public LinkedList<APFSDirectory> getSubDirectories() {
		return this.getSubDirectories(Comparator.comparing(APFSElement::getName));
	}
	
	public LinkedList<APFSDirectory> getSubDirectories(Comparator<APFSElement> c) {
		
		LinkedList<APFSDirectory> subDirectories = new LinkedList<APFSDirectory>(); 
		
		for (FSElement child : children) {
			if (child.isDirectory()) {
				subDirectories.add((APFSDirectory) child);
			}
		}
		
		Collections.sort(subDirectories, c);
		
		return subDirectories;
	}
	
	public LinkedList<APFSFile> getFiles() {
		return this.getFiles(Comparator.comparing(APFSElement::getName));
	}
	
	public LinkedList<APFSFile> getFiles(Comparator<APFSElement> c) {
		
		LinkedList<APFSFile> files = new LinkedList<APFSFile>(); 
		
		for (APFSElement child : children) {
			if (child instanceof APFSFile) {
				files.add((APFSFile) child);
			}
		}
		
		Collections.sort(files, c);
		
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
