package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FileSystem {
	
	private static FileSystem            instance = new FileSystem();
	private static LinkedList<Directory> rootDirs = new LinkedList<Directory>();
	
	private FileSystem() {}
	
	public static FileSystem getFileSystem() {
		return instance;
	}
	
	public LinkedList<Directory> getRootDirs() {
		return rootDirs;
	}
	
	public void addRootDir(String name, LocalDateTime creationTime) {
		rootDirs.add(new Directory(null, name, creationTime));
	}

}
