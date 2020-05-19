import java.util.Scanner;

/**
 * Prompts user for number of rows (students) and columns (exams) to store exam scores, 
 * then prints the average for each row and column
 * 
 * @author Matthew Pigliavento 
 * @version November 30, 2016
 */
public class ExamScores
{
    public static void main(String[] args)
    {
        // prompts user for number of rows and columns
        Scanner prompt = new Scanner(System.in);
        System.out.println("Enter number of students (rows):");
        int rows = prompt.nextInt();
        System.out.println("Enter number of exams (columns):");
        int cols = prompt.nextInt();
        
        // creates 2D array of size rows x cols
        double[][] exams = new double[rows][cols];
        
        // prompts user for input and fills 2D array exams with the inputs
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.println("Enter value for [" + i + "]" + "[" + j + "]");
                double value = prompt.nextDouble();
                exams[i][j] = value;
            }
        }
        
        // totals and prints averages for each row and column
        System.out.println("Average for each row:");
        for (int i = 0; i < rows; i++)
        {
            double rowTotal = 0;
            for (int j = 0; j < cols; j++)
            {
               rowTotal += exams[i][j];
            }
            System.out.println("Average for row " + i + " is: " + (rowTotal/cols));
        }
        System.out.println("Average for each column:");
        for (int i = 0; i < cols; i++)
        {
            double colTotal = 0;
            for (int j = 0; j < rows; j++)
            {
               colTotal += exams[j][i];
            }
            System.out.println("Average for column " + i + " is: " + (colTotal/rows));
        }
    }
}