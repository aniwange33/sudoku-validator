package org.luxoft.infrastructure;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Disabled;

import org.luxoft.SudokuValidatorTest;
import org.luxoft.infrastructure.exception.EmptyFileException;

public class CSVMapperTest  extends TestCase {
	
	
	public CSVMapperTest(String name) {
		super(name);
	}
	
	public static Test suite()
	{
		return new TestSuite( CSVMapperTest.class );
	}
	
	
	public void testShouldThrowFileNotFoundException()  {
		assertThrows(FileNotFoundException.class, () -> (new CSVMapper()).convertCsvContentToSudokuBoard("foo.txt"));
	}
	
	
	public void testShouldThrowNumberFormatException()  {
		assertThrows(NumberFormatException.class, () -> (new CSVMapper()).convertCsvContentToSudokuBoard(""));
	}
	
	public void testShouldThrowEmptyFileNotFoundException()  {
		assertThrows(EmptyFileException.class, () -> (new CSVMapper()).convertCsvContentToSudokuBoard("emptyFile.txt"));
	}
	
	

	public void testShouldConvertCsvContentToSudokuBoard() throws EmptyFileException, IOException {
		Integer[][]  expected = new Integer[][] {
				{8 , 2 , 5 , 4 , 7 , 1 , 3 , 9 , 6},
				{1 , 9 , 4 , 3 , 2 , 6 , 5 , 7 , 8},
				{3 , 7 , 6 , 9 , 8 , 5 , 2 , 4 , 1},
				{5 , 1 , 9 , 7 , 4 , 3 , 8 , 6 , 2},
				{6 , 3 , 2 , 5 , 9 , 8 , 4 , 1 , 7},
				{4 , 8 , 7 , 6 , 1 , 2 , 9 , 3 , 5},
				{2 , 6 , 3 , 1 , 5 , 9 , 7 , 8 , 4},
				{9 , 4 , 8 , 2 , 6 , 7 , 1 , 5 , 3},
				{7 , 5 , 1 , 8 , 3 , 4 , 6 , 2 , 9},
		};
		Integer[][] actual = (new CSVMapper()).convertCsvContentToSudokuBoard("validFile.txt");
		assertTrue(Arrays.deepEquals(expected, actual));
	}
}

