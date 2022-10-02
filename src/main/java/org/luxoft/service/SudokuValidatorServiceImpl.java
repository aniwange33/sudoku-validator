package org.luxoft.service;

import java.util.HashSet;

public class SudokuValidatorServiceImpl implements SudokuValidatorService {
	
	private static final int BOARD_MAX_LENGTH = 9;
	
	
	@Override
	public boolean isSudokuBoardValid(Integer[][] board) {
		HashSet<String> checkContainer = new HashSet<>();
		if (board.length > BOARD_MAX_LENGTH || board.length < BOARD_MAX_LENGTH) {
			throw new IllegalArgumentException("Invalid board length: " + board.length);
		}
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board.length; column++) {
				Integer currentValue = board[row][column];
				String rowValueInCheckContainer = currentValue + "current row value" + row;
				String columnValueInCheckContainer = currentValue + "current column value" + column;
				String subBoxValueInCheckerContainer = currentValue + "current box value" + row / 3 + "." + column / 3;
				boolean isRowOrColumnOrSubBoxValueRepeated =
						!checkContainer.add(rowValueInCheckContainer)
								||
								!checkContainer.add(columnValueInCheckContainer)
								||
								!checkContainer.add(subBoxValueInCheckerContainer);
				if (currentValue > 0 && currentValue <= BOARD_MAX_LENGTH &&
						isRowOrColumnOrSubBoxValueRepeated) return false;
				
			}
		}
		return true;
	}
}
