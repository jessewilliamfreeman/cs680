package edu.umb.cs680.hw10;

public class APFSCountingVisitor implements APFSVisitor{
	
	private int dirNum  = 0;
	private int fileNum = 0;
	private int linkNum = 0;

	@Override
	public void visit(APFSLink link) {
		linkNum++;
	}

	@Override
	public void visit(APFSDirectory dir) {
		dirNum++;
	}

	@Override
	public void visit(APFSFile file) {
		fileNum++;
	}

	public int getDirNum() {
		return dirNum;
	}

	public int getFileNum() {
		return fileNum;
	}

	public int getLinkNum() {
		return linkNum;
	}

}
