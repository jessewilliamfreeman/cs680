package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StudentFactoryTest {

	@Test
	public void createInStateStudent() {
		
		String        name   = "Mike";
		String        usAddr = "Mike's House";
		StudentStatus status = StudentStatus.INSTATE;
		
		Student inStateStudent = StudentFactory.createInStateStudent(name, usAddr);
		
		assertEquals(name,   inStateStudent.getName());
		assertEquals(usAddr, inStateStudent.getUsAddr());
		assertEquals(status, inStateStudent.getStatus());
		assertEquals(status, inStateStudent.getStatus());
	}

	@Test
	public void createOutStateStudent() {

		String        name       = "Mike";
		String        usAddr     = "Mike's House";
		int           yrsInState = 4;
		StudentStatus status     = StudentStatus.OUTSTATE;
		
		Student outStateStudent = StudentFactory.createOutStateStudent(name, usAddr, yrsInState);
		
		assertEquals(name,       outStateStudent.getName());
		assertEquals(usAddr,     outStateStudent.getUsAddr());
		assertEquals(yrsInState, outStateStudent.getYrsInState());
		assertEquals(status,     outStateStudent.getStatus());
		
	}

	@Test
	public void createIntlStudent() {

		String        name        = "Mike";
		String        usAddr      = "Mike's US House";
		int           i20num      = 4;
		String        foreignAddr = "Mike's House";
		StudentStatus status      = StudentStatus.INTL;
		
		Student intlStudent = StudentFactory.createIntlStudent(name, usAddr, i20num, foreignAddr);
		
		assertEquals(name,        intlStudent.getName());
		assertEquals(usAddr,      intlStudent.getUsAddr());
		assertEquals(i20num,      intlStudent.getI20num());
		assertEquals(foreignAddr, intlStudent.getForeignAddr());
		assertEquals(status,      intlStudent.getStatus());
	}


}
