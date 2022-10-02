package org.luxoft;

import org.luxoft.infrastructure.CSVMapper;
import org.luxoft.infrastructure.exception.EmptyFileException;
import org.luxoft.service.SudokuValidatorService;
import org.luxoft.service.SudokuValidatorServiceImpl;

import java.io.IOException;

/**
 * Hello world!
 */
public class SudokuValidator {
	
	public static void main(String[] args) {
		processAndValidSudokuBoardProvidedInCsvFile(args);
	}
	
	
	
	private static void processAndValidSudokuBoardProvidedInCsvFile(String[] args) {
		if (args.length != 1) {
			errorMessageHandler("Error : the program must be called with 1 filename");
		}
		try {
			String fileName = args[0];
			if (validateFile(fileName)) {
				System.out.println("0");
				System.exit(0);
			}
			errorMessageHandler("Validation error : Invalid Sudoku Grid");
			
		} catch (EmptyFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			errorMessageHandler(e.getMessage());
		} finally {
			errorMessageHandler("");
		}
	}
	
	
	private static boolean validateFile(String fileName) throws EmptyFileException, IOException {
		CSVMapper csvMapper = new CSVMapper();
		Integer[][] sudokuBoard = csvMapper.convertCsvContentToSudokuBoard(fileName);
		SudokuValidatorService sudokuValidatorService = new SudokuValidatorServiceImpl();
		return sudokuValidatorService.isSudokuBoardValid(sudokuBoard);
		
	}
	
	private static void errorMessageHandler(final String message) {
		System.out.println("1");
		System.out.println(message);
		System.exit(1);
	}
}
