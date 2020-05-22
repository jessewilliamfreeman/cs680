package edu.umb.cs680.hw12;

import java.util.Comparator;

public class APFSReverseAlphabeticComparator implements Comparator<APFSElement>{

	@Override
	public int compare(APFSElement element1, APFSElement element2) {
		return element2.getName().compareTo(element1.getName());
	}

}