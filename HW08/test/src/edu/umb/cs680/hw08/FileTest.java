package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.File;

class FileTest {
	
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
	
	private static File fileA;
	
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
		
		fileA = new File(applications, "a", appFileSize, ld3);
		new File(applications, "b", appFileSize, ld3);
		
		home = new Directory(root, "home", ld2);
		
		new File(home, "c", homeFileSize, ld3);
		new File(home, "d", homeFileSize, ld3);
		
		code = new Directory(home, "code", ld3);
		
		new File(code, "e", codeFileSize, ld4);
		new File(code, "f", codeFileSize, ld4);
	}
	
	private static String[] fileToStringArray(File f){
		ArrayList<String> dirInfo = new ArrayList<String>();
		
		dirInfo.add(f.getName());
		dirInfo.add(Integer.toString(f.getSize()));
		dirInfo.add(f.getCreationTime().toString());
		
		Directory parent = f.getParent();
		
		dirInfo.add(parent != null ? parent.getName() : "null");
		
		String[] result = dirInfo.toArray(new String[dirInfo.size()]);
		
		return result; 
	}

	@Test
	void isDirectory() {
		boolean expected = false;
		
		assertEquals(expected, fileA.isDirectory());
		
	}
	
	@Test
	public void verifyFileEqualityA(){
		String[] expected = {
				"a",
				"100",
				ld3.toString(),
				"applications"
		};
		
		assertArrayEquals(expected, fileToStringArray(fileA));
	}

}
