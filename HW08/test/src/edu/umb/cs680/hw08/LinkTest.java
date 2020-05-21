package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.FSElement;
import edu.umb.cs680.hw08.File;

import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDateTime;
import java.util.ArrayList;

class LinkTest {

	
	private static Directory     root;
	private static Directory     applications;
	private static Directory     home;
	private static Directory     code;
	private static Link          x;
	private static Link          y;
	private static File          a;
	private static File          b;
	private static File          c;
	private static File          d;
	private static File          e;
	private static File          f;
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
		
		a = new File(applications, "a", appFileSize, ld3);
		b = new File(applications, "b", appFileSize, ld3);
		
		home = new Directory(root, "home", ld2);
		
		x = new Link(home, "x", ld3, applications);
		c = new File(home, "c", homeFileSize, ld3);
		d = new File(home, "d", homeFileSize, ld3);
		
		code = new Directory(home, "code", ld3);

		y = new Link(code, "y", ld4, b);
		e = new File(code, "e", codeFileSize, ld4);
		f = new File(code, "f", codeFileSize, ld4);
	}
	
	private static String[] linkToStringArray(Link l){
		ArrayList<String> linkInfo = new ArrayList<String>();
		
		linkInfo.add(l.getName());
		linkInfo.add(Integer.toString(l.getSize()));
		linkInfo.add(l.getCreationTime().toString());
		
		Directory parent = l.getParent();
		
		linkInfo.add(parent != null ? parent.getName() : "null");
		
		FSElement target = l.getTarget();
		
		linkInfo.add(target.getName());
		linkInfo.add(Integer.toString(target.getSize()));
		linkInfo.add(target.getCreationTime().toString());
		
		
		String[] result = linkInfo.toArray(new String[linkInfo.size()]);
		
		return result; 
	}
	
	@Test
	public void linkInfoTest1() {
		String[] expected = {
				"x",
				"0",
				ld3.toString(),
				"home",
				"applications",
				"0",
				ld2.toString()
		};
		
		assertArrayEquals(expected, linkToStringArray(x));
	}

	@Test
	public void linkInfoTest2() {
		String[] expected = {
				"y",
				"0",
				ld4.toString(),
				"code",
				"b",
				Integer.toString(appFileSize),
				ld3.toString()
		};
		
		assertArrayEquals(expected, linkToStringArray(y));
	}
	
	@Test
	public void isDirectoryTest() {
		assertEquals(false, x.isDirectory());
	}

}
