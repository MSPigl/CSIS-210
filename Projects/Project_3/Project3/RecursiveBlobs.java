import java.util.*;
import java.io.*;

/**
 * Reads in a 2D array of characters from a text file, prints the
 * array, counts the number of "blobs" and prints the total,
 * replaces any asterisks with an "X" and then reprints the array
 * 
 * @author Matthew Pigliavento 
 * @version December 2, 2016
 */
public class RecursiveBlobs
{
    /**
     * Replaces any found asterisks in a 2D char array with an X
     * 
     * @param grid a 2D array of chars
     * @param row current row
     * @param col current column
     * @param maxRows number of rows in array
     * @param maxCols number of columns in array
     * @return grid - a 2D array of chars
     */
    public static char[][] eraseblob(char[][] grid, int row, int col, int maxRows, int maxCols)
    {
        // if an asterisk is found, replace it with an X, check neighboring spaces for asterisks
        if (grid[row][col] == '*')
        {
            grid[row][col] = 'X';
            // check north neighbor
            if (row != 0)
            {
                eraseblob(grid, row-1, col, maxRows, maxCols);
            }
            // check south neighbor
            if (row != maxRows -1)
            {
                eraseblob(grid, row+1, col, maxRows, maxCols);
            }
            // check west neighbor
            if (col != 0)
            {
                eraseblob(grid, row, col-1, maxRows, maxCols);
            }
            // check east neighbor
            if (col != maxCols-1)
            {
                eraseblob(grid, row, col+1, maxRows, maxCols);
            }
        }
        return grid;
    }

    /**
     * Main method for class RecursiveBlobs
     */
    public static void main(String[] args)
    {
        // define and open file using Scanner 
        String fileName = "blobdata.txt";
        Scanner fromFile = null;

        // opens file, prints error message if file is not found
        try
        {
            fromFile = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("Cannot open " + fileName + " check if it exists in this project directory");
            return;
        }

        // Stores the first line of the text file under a String variable
        String line = fromFile.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        
        // converts the two numbers in firstLine to ints
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        System.out.println("Rows: " + rows + " Columns: " + cols);
        
        // creates a 2D char array using the two ints from the file for rows and columns
        char[][] array = new char[rows][cols];
        
        // adds character at specified position to the element at a specified array position
        for (int i = 0; i < rows; i++)
        {
            line = fromFile.nextLine();
            for (int j = 0; j < cols; j++)
            {
                array[i][j] = line.charAt(j);
            }
        }
        
        // counts asterisks contained in the array, prints the total, and prints the array
        int starCount = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (array[i][j] == '*')
                {
                    starCount++;
                }
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        System.out.println("Star count: " + starCount);
        
        // process array, replace asterisks using method eraseblob, print the blob count and the modified array
        int blobCount = 0;
        System.out.println("Processing blobs...");
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (array[i][j] == '*')
                {
                    blobCount++;
                    eraseblob(array, i, j, rows, cols);
                }
            }
        }
        System.out.println("Blob count: " + blobCount);
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}