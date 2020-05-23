package edu.umb.cs680.hw13;

import java.io.PrintStream;
import java.util.Observable;
import java.util.Observer;

public class TableObserver implements Observer {
	
	// for testing
	private PrintStream printStream;
	
	public TableObserver() {
		printStream = System.out;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof StockEvent) {
			StockEvent se = (StockEvent) arg1;
			printStream.println("Table Update: Ticker " + 
					se.getTicker() + " Quote " + Float.toString(se.getQuote()));
		} 
		else if (arg1 instanceof DJIAEvent) {
			DJIAEvent de = (DJIAEvent) arg1;
			printStream.println("Table Update: DJIA " + Float.toString(de.getDjia()));
		}
		
	}
	
	// for testing
	protected void setPrintStream(PrintStream printStream) {
		this.printStream = printStream;
	}
}
