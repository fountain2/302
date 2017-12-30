package edu.jyu.stumgmTest.EntityTest;

import edu.jyu.stumgm.entity.Grade;
import edu.jyu.stumgm.entity.Student;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testGrade {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetId() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testGetStudent() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testSetStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumElectron() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNumElectron() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumSoftware() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNumSoftware() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumSecurity() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNumSecurity() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumJava() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNumJava() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumDB() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNumDB() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumImage() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNumImage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumDistributed() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNumDistributed() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumTest() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNumTest() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotal() {
		Grade g = new Grade(new Student(), 0, 0, 0, 0, 0, 0, 0, 0);
		int total = g.getTotal();
		assertEquals(total, 0);
		fail("Not yet implemented");
	}

}
