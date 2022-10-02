The project create a command line tool (running on jvm) for validating a standard 9x9 Sudoku puzzle:

Command line: validate.bat puzzleName.txt

File format: csv format each line representing a row e.g.:

```
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
1,2,3,4,5,6,7,8,9
```

The program return 0 (VALID) or non-zero (INVALID) value with an error text on stdout (in case of
an invalid solution or file).

### INSTRUCTION


## In order to build, please use 

mvn clean install 

## in order to generate report

mvn surefire-report:report

## in order to launch

 please use validate.bat 

## to test: use the command below
 
cmd.exe /c validate.bat validFile.txt

