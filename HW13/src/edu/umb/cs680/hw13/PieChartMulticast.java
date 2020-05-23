package edu.umb.cs680.hw13;

import java.io.PrintStream;
import java.util.Observable;
import java.util.Observer;

public class PieChartMulticast implements DJIAQuoteObserver, StockQuoteObserver {
	
	// for testing
	private PrintStream printStream;
	
	public PieChartMulticast() {
		printStream = System.out;
	}
	
	// for testing
	protected void setPrintStream(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public void updateStock(StockEvent se) {
		printStream.println("PieChart Update: Ticker " + 
				se.getTicker() + " Quote " + Float.toString(se.getQuote()));
		
	}

	@Override
	public void updateDJIA(DJIAEvent de) {
		printStream.println("PieChart Update: DJIA " + Float.toString(de.getDjia()));
	}
	
}
