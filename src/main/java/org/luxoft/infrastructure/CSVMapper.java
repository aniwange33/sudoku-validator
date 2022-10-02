package org.luxoft.infrastructure;

import org.luxoft.infrastructure.exception.EmptyFileException;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVMapper {
	
	private static final String COMMA_DELIMITER = ",";
	
	public Integer[][] convertCsvContentToSudokuBoard(final String csvFileName) throws
			EmptyFileException, IOException, NumberFormatException {
		
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(csvFileName);
		
		if (resourceAsStream == null) {
			File file = new File(csvFileName);
			
			if (!file.exists()) {
				throw new FileNotFoundException("The file " + csvFileName + " cannot be found");
			}
			resourceAsStream = Files.newInputStream(file.toPath());
		}
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream))) {
			
			String line;
			List<List<Integer>> sudokuBoardTransformer = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				String[] values = line.split(COMMA_DELIMITER);
				
				sudokuBoardTransformer.add(
						Arrays.stream(values)
								.map(String::trim)
								.map(value -> value.isEmpty() ? null : Integer.valueOf(value))
								.collect(Collectors.toList()));
			}
			
			if (sudokuBoardTransformer.isEmpty()) {
				throw new EmptyFileException();
			}
			
			return sudokuBoardTransformer.stream()
					.map(columns -> columns.stream().toArray(Integer[]::new))
					.toArray(Integer[][]::new);
			
		}
	}
	
}
