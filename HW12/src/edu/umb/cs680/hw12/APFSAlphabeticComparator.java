package edu.umb.cs680.hw12;

import java.util.Comparator;

public class APFSAlphabeticComparator implements Comparator<APFSElement>{

	@Override
	public int compare(APFSElement element1, APFSElement element2) {
		return element1.getName().compareTo(element2.getName());
	}

}
