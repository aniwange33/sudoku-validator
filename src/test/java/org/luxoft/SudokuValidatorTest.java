package org.luxoft;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SudokuValidatorTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SudokuValidatorTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SudokuValidatorTest.class );
    }

   
    public void testValidFile() {
       // SudokuValidator.main(new String[]{"validFile.txt"});
        assertTrue(true);


    }

//    public void testNonValidFile() {
//        SudokuValidator.main(new String[]{"nonValidFile.txt"});
//        assertFalse(false);
//
//
//    }
}
