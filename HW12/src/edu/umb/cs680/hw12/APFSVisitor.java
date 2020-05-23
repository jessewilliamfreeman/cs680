package edu.umb.cs680.hw12;

public interface APFSVisitor {
	
	public abstract void visit(APFSLink link);
	public abstract void visit(APFSDirectory dir);
	public abstract void visit(APFSFile file);

}