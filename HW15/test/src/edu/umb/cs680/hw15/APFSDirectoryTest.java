package edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

class APFSDirectoryTest {
	
	
	private static APFSDirectory     root;
	private static APFSDirectory     applications;
	private static APFSDirectory     home;
	private static APFSDirectory     code;
	private static APFSLink          x;
	private static APFSLink          y;
	private static APFSFile          a;
	private static APFSFile          b;
	private static APFSFile          c;
	private static APFSFile          d;
	private static APFSFile          e;
	private static APFSFile          f;
	private static LocalDateTime     ld1;
	private static LocalDateTime     ld2;
	private static LocalDateTime     ld3;
	private static LocalDateTime     ld4;
	
	private static String            owner;
	
	private static int appAPFSFileSize;
	private static int homeAPFSFileSize;
	private static int codeAPFSFileSize;
	
	@BeforeAll
	private static void buildMainDir() {
		
		ld1 = LocalDateTime.of(1990, 12, 20, 9, 20);
		ld2 = LocalDateTime.of(1991, 11, 21, 5, 30);
		ld3 = LocalDateTime.of(1992, 10, 15, 2, 40);
		ld4 = LocalDateTime.of(1994, 10, 15, 2, 40);
		
		appAPFSFileSize  = 100;
		homeAPFSFileSize = 200;
		codeAPFSFileSize = 20000;
		
		owner = "owner";
		
		root = new APFSDirectory(null, "root", ld1, owner);
		
		applications = new APFSDirectory(root, "applications", ld2, owner);
		
		a = new APFSFile(applications, "a", appAPFSFileSize, ld3, owner);
		b = new APFSFile(applications, "b", appAPFSFileSize, ld3, owner);
		
		home = new APFSDirectory(root, "home", ld2, owner);
		
		x = new APFSLink(home, "x", ld3, owner, applications);
		c = new APFSFile(home, "c", homeAPFSFileSize, ld3, owner);
		d = new APFSFile(home, "d", homeAPFSFileSize, ld3, owner);
		
		code = new APFSDirectory(home, "code", ld3, owner);

		y = new APFSLink(code, "y", ld4, owner, b);
		e = new APFSFile(code, "e", codeAPFSFileSize, ld4, owner);
		f = new APFSFile(code, "f", codeAPFSFileSize, ld4, owner);
	}
	
	private static String[] dirToStringArray(APFSDirectory d){
		ArrayList<String> dirInfo = new ArrayList<String>();
		
		dirInfo.add(d.getName());
		dirInfo.add(Integer.toString(d.getSize()));
		dirInfo.add(d.getCreationTime().toString());
		dirInfo.add(d.getLastModified().toString());
		dirInfo.add(d.getOwner());
		
		FSElement parent = d.getParent();
		
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
		
		for (APFSDirectory d : root.getSubDirectories()) {
			preActual.add(d.getName());
		}
		
		String[] actual = preActual.toArray(new String[preActual.size()]);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getSubDirectoriesReverse() {
		String[] expected = {
			"home",
			"applications"
		};
		
		ArrayList<String> preActual = new ArrayList<String>();
		
		for (APFSDirectory d : root.getSubDirectories(
				Comparator.comparing(APFSElement::getName,
						Comparator.reverseOrder()))) {
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
		
		for (APFSFile f : applications.getFiles()) {
			preActual.add(f.getName());
		}
		
		String[] actual = preActual.toArray(new String[preActual.size()]);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getFilesReverse() {
		String[] expected = {
			"b",
			"a"
		};
		
		ArrayList<String> preActual = new ArrayList<String>();
		
		for (APFSFile f : applications.getFiles(
				Comparator.comparing(APFSElement::getName,
						Comparator.reverseOrder()))) {
			preActual.add(f.getName());
		}
		
		String[] actual = preActual.toArray(new String[preActual.size()]);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test 
	public void getChildren() {
		String[] expected = {
				"c",
				"code",
				"d",
				"x"
		};
		
		ArrayList<String> preActual = new ArrayList<String>();
		
		for (APFSElement ele : home.getChildren()) {
			preActual.add(ele.getName());
		}
		
		String[] actual = preActual.toArray(new String[preActual.size()]);

		assertArrayEquals(expected, actual);
	}
	
	@Test 
	public void getChildrenReverse() {
		String[] expected = {
				"x",
				"d",
				"code",
				"c"
		};
		
		ArrayList<String> preActual = new ArrayList<String>();
		
		for (APFSElement ele : home.getChildren(
				Comparator.comparing(APFSElement::getName,
						Comparator.reverseOrder()))) {
			preActual.add(ele.getName());
		}
		
		String[] actual = preActual.toArray(new String[preActual.size()]);

		assertArrayEquals(expected, actual);
	}
	
	@Test 
	public void getChildrenDirectoryFirst() {
		String[] expected = {
				"code",
				"x",
				"c",
				"d"
		};
		
		ArrayList<String> preActual = new ArrayList<String>();
		
		for (APFSElement ele : home.getChildren(
				Comparator.comparing(APFSElement::isDirectory,
						Comparator.reverseOrder()))) {
			preActual.add(ele.getName());
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
	public void isAPFSDirectory() {
		boolean expected = true;
		
		assertEquals(expected, root.isDirectory());
	}
	
	
	@Test
	public void verifyAPFSDirectoryEqualityRoot(){
		APFSDirectory actual = root;
		
		String[] expected = {
				"root",
				"0",
				ld1.toString(),
				ld1.toString(),
				"owner",
				"null",
				"2",
				"applications",
				"home"
		};
		
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void verifyAPFSDirectoryEqualityHome(){
		APFSDirectory actual = home;
		
		String[] expected = {
				"home",
				"0",
				ld2.toString(),
				ld2.toString(),
				owner,
				"root",
				"4",
				"c",
				"code",
				"d",
				"x",
		};
		
		assertArrayEquals(expected, dirToStringArray(actual));
	}

}
