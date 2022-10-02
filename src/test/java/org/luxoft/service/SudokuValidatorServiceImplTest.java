package org.luxoft.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class SudokuValidatorServiceImplTest  extends TestCase {
	
	private static SudokuValidatorService classUnderTest;
	
	public SudokuValidatorServiceImplTest(String name) {
		super(name);
	}
	
	public void testIsSudokuBoardValidShouldThrowIllegalArgument() {
		assertThrows(IllegalArgumentException.class,
				() -> (new SudokuValidatorServiceImpl()).isSudokuBoardValid(new Integer[][]{new Integer[]{1}}));
	}
	
	public void testIsSudokuBoardValidShouldReturnTrue() {
		//given
		Integer[][] validBoard = new Integer[][]{
				{8, 2, 5, 4, 7, 1, 3, 9, 6},
				{1, 9, 4, 3, 2, 6, 5, 7, 8},
				{3, 7, 6, 9, 8, 5, 2, 4, 1},
				{5, 1, 9, 7, 4, 3, 8, 6, 2},
				{6, 3, 2, 5, 9, 8, 4, 1, 7},
				{4, 8, 7, 6, 1, 2, 9, 3, 5},
				{2, 6, 3, 1, 5, 9, 7, 8, 4},
				{9, 4, 8, 2, 6, 7, 1, 5, 3},
				{7, 5, 1, 8, 3, 4, 6, 2, 9},
		};
		assertEquals(true, classUnderTest.isSudokuBoardValid(validBoard));
	}
	public void testIsSudokuBoardValidShouldReturnFalse() {
		//given
		Integer[][] inValidBoard = new Integer[][]{
				{8, 2, 5, 4, 7, 1, 3, 9, 6},
				{1, 9, 4, 3, 2, 6, 5, 7, 8},
				{3, 7, 6, 9, 8, 5, 2, 4, 1},
				{5, 1, 9, 7, 4, 3, 8, 6, 2},
				{6, 3, 2, 5, 9, 8, 4, 1, 7},
				{4, 8, 7, 6, 1, 5, 9, 3, 5},
				{2, 6, 3, 1, 5, 9, 7, 8, 4},
				{9, 4, 8, 2, 6, 7, 1, 5, 3},
				{7, 5, 1, 8, 3, 4, 6, 2, 8},
		};
		assertFalse(classUnderTest.isSudokuBoardValid(inValidBoard));
	}
	
	public void setUp() throws Exception {
		classUnderTest = new SudokuValidatorServiceImpl();
	}
}



