package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.FSElement;
import edu.umb.cs680.hw08.File;

import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDateTime;
import java.util.ArrayList;

class DirectoryTest {
	
	private static Directory     root;
	private static Directory     applications;
	private static Directory     home;
	private static Directory     code;
	private static LocalDateTime ld1;
	private static LocalDateTime ld2;
	private static LocalDateTime ld3;
	private static LocalDateTime ld4;
	
	private static int appFileSize;
	private static int homeFileSize;
	private static int codeFileSize;
	
	@BeforeAll
	private static void buildMainDir() {
		
		ld1 = LocalDateTime.of(1990, 12, 20, 9, 20);
		ld2 = LocalDateTime.of(1991, 11, 21, 5, 30);
		ld3 = LocalDateTime.of(1992, 10, 15, 2, 40);
		ld4 = LocalDateTime.of(1994, 10, 15, 2, 40);
		
		appFileSize  = 100;
		homeFileSize = 200;
		codeFileSize = 20000;
		
		root = new Directory(null, "root", ld1);
		
		applications = new Directory(root, "applications", ld2);
		
		new File(applications, "a", appFileSize, ld3);
		new File(applications, "b", appFileSize, ld3);
		
		home = new Directory(root, "home", ld2);
		
		new File(home, "c", homeFileSize, ld3);
		new File(home, "d", homeFileSize, ld3);
		
		code = new Directory(home, "code", ld3);
		
		new File(code, "e", codeFileSize, ld4);
		new File(code, "f", codeFileSize, ld4);
	}
	
	private static String[] dirToStringArray(Directory d){
		ArrayList<String> dirInfo = new ArrayList<String>();
		
		dirInfo.add(d.getName());
		dirInfo.add(Integer.toString(d.getSize()));
		dirInfo.add(d.getCreationTime().toString());
		
		Directory parent = d.getParent();
		
		dirInfo.add(parent != null ? parent.getName() : "null");
		
		dirInfo.add(Integer.toString(d.countChildren()));
		
		for (FSElement e : d.getChildren()) {
			dirInfo.add(e.getName());
		}
		
		String[] result = dirInfo.toArray(new String[dirInfo.size()]);
		
		return result; 
	}
	
	@Test
	public void getSubDirectories() {
		String[] expected = {
			"applications",
			"home"
		};
		
		ArrayList<String> preActual = new ArrayList<String>();
		
		for (Directory d : root.getSubDirectories()) {
			preActual.add(d.getName());
		}
		
		String[] actual = preActual.toArray(new String[preActual.size()]);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getFiles() {
		String[] expected = {
			"a",
			"b"
		};
		
		ArrayList<String> preActual = new ArrayList<String>();
		
		for (File f : applications.getFiles()) {
			preActual.add(f.getName());
		}
		
		String[] actual = preActual.toArray(new String[preActual.size()]);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getTotalSize() {
		int expected = 40600;
		
		int actual = root.getTotalSize();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void isDirectory() {
		boolean expected = true;
		
		assertEquals(expected, root.isDirectory());
	}
	
	
	@Test
	public void verifyDirectoryEqualityRoot(){
		Directory actual = root;
		
		String[] expected = {
				"root",
				"0",
				ld1.toString(),
				"null",
				"2",
				"applications",
				"home"
		};
		
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void verifyDirectoryEqualityHome(){
		Directory actual = home;
		
		String[] expected = {
				"home",
				"0",
				ld2.toString(),
				"root",
				"3",
				"c",
				"d",
				"code"
		};
		
		assertArrayEquals(expected, dirToStringArray(actual));
	}

}
