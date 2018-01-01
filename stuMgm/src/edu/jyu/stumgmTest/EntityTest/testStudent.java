package edu.jyu.stumgmTest.EntityTest;

import edu.jyu.stumgm.entity.*;

import junit.framework.TestCase;

public class testStudent extends TestCase {
	public void setUp() throws Exception {
    }

    public void tearDown() throws Exception {
    }
    
    public void testgetGrade()
    {
    	Student s = new Student();
    	Grade g = new Grade(new Student(), "软件项目管理", 70);
    	s.setGrade(g);
    	assertEquals(s.getGrade().getId(), g.getId());
    	assertEquals(s.getGrade().getNumScore(), g.getNumScore());
    }
    
    public void testgetIdentityId()
    {
    	Student s = new Student();
    	s.setIdentityID("77262");
    	
    	assertEquals(s.getIdentityID(), "77262");
    }
}
