import java.util.Scanner;
/**
 * Write a description of class Convert here.
 * 
 * @author (Chris Fall and Matt Pigliavento) 
 * @version (2/3/2016)
 */
import java.util.Scanner;
public class Convert
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Convert
     */
    public static void main()
    {
        // initialise instance variables
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a positive integer, to quit Enter 0: ");
        int input = in.nextInt();

        System.out.println("Base 10 to base 2 converter.");
        while(input != 0)
        {
            StackADT bStack = new StackADT<Integer>(5);
            while(input != 0)
            {
                if(input % 2 == 0)
                {
                    bStack.push(0);
                }
                if (input % 2 != 0)
                {
                    bStack.push(1);
                }
                input = input / 2;
            }

            while(!bStack.isEmpty())
            {
                System.out.print(bStack.pop());
            }
            System.out.println();
            System.out.print("Please enter a positive integer, to quit Enter 0: ");
            input = in.nextInt();
        }
    } // main

} // class
