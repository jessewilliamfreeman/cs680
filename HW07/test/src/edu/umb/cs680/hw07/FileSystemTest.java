package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class FileSystemTest {
	
	@Test
	public void addRootDir() {
		
		LocalDateTime ld1 = LocalDateTime.of(1990, 12, 20, 9, 20);
		
		FileSystem fs = FileSystem.getFileSystem();
		
		fs.addRootDir("root", ld1);
		
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		
		assertEquals("root", rootDirs.get(0).getName());
		
	}

}
