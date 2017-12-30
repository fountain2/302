package edu.jyu.stumgmTest.EntityTest;

import junit.framework.TestSuite;

import junit.framework.Test;
import junit.textui.TestRunner;

import edu.jyu.stumgmTest.EntityTest.testStudent;

public class testAll extends TestSuite {
    public static Test suite() {
        TestSuite suite = new TestSuite("TestSuite Test");
        suite.addTestSuite(testStudent.class);
        return suite;
    }
    public static void main(String args[]){
        TestRunner.run(suite());
    }
} 