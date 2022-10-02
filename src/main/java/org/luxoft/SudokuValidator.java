package org.luxoft;

/**
 * Hello world!
 *
 */
public class SudokuValidator
{
    public static void main( String[] args )
    {
        if (args.length == 0) {
            throw new IllegalArgumentException("This command line tool requires at least one file to run");
        }
        System.out.println( "Hello World!" );
    }
}
