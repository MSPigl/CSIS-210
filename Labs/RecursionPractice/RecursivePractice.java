
/**
 * In this file you get practice writing recursive methods.
 * 
 */
public class RecursivePractice
{
    // Returns the sum of intergers 1 + 2 + 3 + ... + n
    public int sum(int n)
    {
        if ( n == 1 ) 
        // base case
            return 1;      
        else {
            int total;
            // recursive call to compute 1 + 2 + ... + n-1
            total = sum( n-1 );  
            // add in last number in sequence to get final result
            total = total + n;
            return total;
        }
    }

    // Returns the sum of 3 + 6 + 9 + ... + (n-3) + n
    public int sumThrees( int n )
    { 
        if (n==3)
        {
            return 3;
        }
        else
        {
            int total;
            total = sumThrees(n-3) + n;
            return total;
        }       
    }

    // Returns the nth fibonacci number 
    public int fib( int n )
    {
        if (n==1 || n==2)
        {
            return 1;
        }
        else
        {
            int total;
            total = fib(n-1) + fib (n-2);
            return total;
        }
    }

    // Returns A^2 + (A+1)^2 + ... + B^2, for 0<=A<=B
    public int squaresAtoB( int A, int B )
    {
        if (A==B)
        {
            return (B*B);
        }
        else
        {
            int total;
            total = squaresAtoB(A, B-1) + (B*B);
            return total;
        }
    }

    // Prints N asterisks, followed by the same number of exclamation points. 
    public void printIt( int n ) 
    {
        if ( n == 1 ) 
            System.out.print( "*!" );
        else 
        {
            System.out.print("*");
            if (n > 1)
            {
                printIt(n - 1);
            }
            System.out.print("!");
        } 
    }

    // Returns the maximum value in array A from among the values
    // A[first]…A[last]
    public int maximum( int[] A, int first, int last )
    {
        int greatest = A[last];
        if (last == first)
        {
            return greatest;
        }
        else
        {
            int temp = maximum(A, first, last - 1);
            if (temp > greatest)
            {
                return temp;
            }
            else
            {
                return greatest;
            }          
        }
    }

    // Returns a count of the number of times 100 occurs among the values 
    // A[first]…A[last]
    public int count100( int[] A, int first, int last ) 
    {
        if (last == first)
        {
            if (A[last] == 100)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        int count = count100(A, first, last - 1);      
        if (A[last] == 100)
        {
            count++;
        }                  
        return count;
    }

    // Returns true if there is a negative value among the values A[first]…A[last]
    public boolean negatives( int[] A, int first, int last )
    {
        if (first == last)
        {
            if (A[first] < 0)
            {
                return true;
            }
            return false;
        }
        else
        {
            if (A[last] < 0)
            {
                return true;
            }
            return negatives (A, first, last - 1);
        }       
    }
}