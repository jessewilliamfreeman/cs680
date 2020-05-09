package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

	@Test
	void constructorBasic() {
		int from = 1;
		int to   = 100;
		PrimeGenerator pGen = new PrimeGenerator(from, to);
		assertEquals(from, pGen.from);
		assertEquals(to, pGen.to);
	}
	
	@Test
	void constructorNegativeFailure() {
		int from = -5;
		int to   = 100;
		try {
			new PrimeGenerator(from, to);
			fail("Negative Numbers Not Allowed");
		}
		catch (RuntimeException ex){
			assertEquals("Wrong input values: from=" + from + " to=" + to,
    				ex.getMessage() );
		}
		
	}

	@Test
	void constructorFromGreaterThanToFailure() {
		int from = 100;
		int to   = 1;
		try {
			new PrimeGenerator(from, to);
			fail("From Should Not Be Larger Than To");
		}
		catch (RuntimeException ex){
			assertEquals("Wrong input values: from=" + from + " to=" + to,
    				ex.getMessage() );
		}
		
	}
	
	@Test
	void isEvenTrue() {
		PrimeGenerator pGen = new PrimeGenerator(1,10);
		boolean isEven = pGen.isEven(2L);
		
		assertEquals(isEven, true);
	}
	
	@Test
	void isEvenFalse() {
		PrimeGenerator pGen = new PrimeGenerator(1,10);
		boolean isEven = pGen.isEven(3L);
		
		assertEquals(isEven, false);
	}
	
	@Test
	void isPrimeTrue() {
		PrimeGenerator pGen = new PrimeGenerator(1,10);
		boolean isPrime = pGen.isPrime(2L);
		
		assertEquals(isPrime, true);
	}
	
	@Test
	void isPrimeFalse() {
		PrimeGenerator pGen = new PrimeGenerator(1,10);
		boolean isPrime = pGen.isPrime(6L);
		
		assertEquals(isPrime, false);
	}
	
	@Test
	void generatePrimesSmall() {
		LinkedList<Long> primes_expected = new LinkedList<Long>();
		primes_expected.add(2L);
		
		PrimeGenerator pGen = new PrimeGenerator(1, 2);
		pGen.generatePrimes();
		LinkedList<Long> primes_actual = pGen.getPrimes();
		
		assertEquals(primes_expected, primes_actual);
		
	}
	
	@Test
	void generatePrimesMedium() {
		LinkedList<Long> primes_expected = new LinkedList<Long>();
		primes_expected.add(2L);
		primes_expected.add(3L);
		primes_expected.add(5L);
		primes_expected.add(7L);
		primes_expected.add(11L);
		primes_expected.add(13L);
		primes_expected.add(17L);
		primes_expected.add(19L);
		primes_expected.add(23L);
		primes_expected.add(29L);
		
		PrimeGenerator pGen = new PrimeGenerator(1, 30);
		pGen.generatePrimes();
		LinkedList<Long> primes_actual = pGen.getPrimes();
		
		assertEquals(primes_expected, primes_actual);
	}
	
	@Test
	void generatePrimesLarge() {
		LinkedList<Long> primes_expected = new LinkedList<Long>();
		primes_expected.add(2L);
		primes_expected.add(3L);
		primes_expected.add(5L);
		primes_expected.add(7L);
		primes_expected.add(11L);
		primes_expected.add(13L);
		primes_expected.add(17L);
		primes_expected.add(19L);
		primes_expected.add(23L);
		primes_expected.add(29L);
		primes_expected.add(31L);
		primes_expected.add(37L);
		primes_expected.add(41L);
		primes_expected.add(43L);
		primes_expected.add(47L);
		primes_expected.add(53L);
		primes_expected.add(59L);
		primes_expected.add(61L);
		primes_expected.add(67L);
		primes_expected.add(71L);
		primes_expected.add(73L);
		primes_expected.add(79L);
		primes_expected.add(83L);
		primes_expected.add(89L);
		primes_expected.add(97L);
		
		PrimeGenerator pGen = new PrimeGenerator(1, 100);
		pGen.generatePrimes();
		LinkedList<Long> primes_actual = pGen.getPrimes();
		
		assertEquals(primes_expected, primes_actual);
	}
	
}