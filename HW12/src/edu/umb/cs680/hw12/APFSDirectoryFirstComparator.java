package edu.umb.cs680.hw12;

import java.util.Comparator;

public class APFSDirectoryFirstComparator implements Comparator<APFSElement>{

	@Override
	public int compare(APFSElement element1, APFSElement element2) {
		return (element1.isDirectory() ? 0 : 1) - (element2.isDirectory() ? 0 : 1);
	}

}