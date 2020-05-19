/**
 * @author Matt Pigliavento, Chris Fall
 */

//
// A binary search tree data structure for storing doubles. The tree
// has the property that for every node n, all values in n's left subtree are less
// than or equal to n's data value and all values in n's right subtree are larger.
//
public class DoubleBinarySearchTree
{
    private DoubleBTNode root;

    // Constructor for objects of class DoubleTree. It initializes an empty tree
    public DoubleBinarySearchTree()
    {
        root = null;
    }

    // Adds the value to the tree. It maintains the binary search tree property 
    // that for every tree node n, all values in n's left subtree are less
    // than or equal to n's data value and all values in n's right subtree are larger.
    //
    public void add( double value ) 
    { 
        // inserting into an empty tree
        if ( root == null )
            root = new DoubleBTNode( value, null, null );
        else 
            recursiveAdd( value, root );
    }

    // Precondition: n is not null
    // Postcondition: value is inserted into the binary search tree whose root is n
    //
    public void recursiveAdd( double value, DoubleBTNode n )
    {
        if ( (value > n.getData()) && (n.getRight() == null) )
        // value is added as the right child of n
            n.setRight( new DoubleBTNode( value, null, null ));
        else if ( (value <= n.getData()) && (n.getLeft() == null) )
        // value is added as the left child of n
            n.setLeft( new DoubleBTNode( value, null, null ));   
        else if ( (value > n.getData()) && (n.getRight() != null) )
        // insert value into n's right subtree
            recursiveAdd( value, n.getRight() );
        else // the following is true: ( (value <= n.getData()) && (n.getLeft() != null) )
        // insert value into n's left subtree
            recursiveAdd( value, n.getLeft() );
    }

    // Prints the values in the tree in order, from smallest to largest
    //
    public void printAll( ) 
    {
        recursivePrintAll( root );
        System.out.println( "" ); // go to new line after printing all values
    }

    // Recursively prints the values out in the subtree whose root is n,
    // from smallest to largest
    //
    public void recursivePrintAll( DoubleBTNode n ) 
    {
        if ( n == null ) return;
        else {
            System.out.print( n.getData() + " " ); 
            recursivePrintAll( n.getLeft() );
            recursivePrintAll( n.getRight() );
        }
    }   

    public int numNodes ()
    {
        int count = recursiveNumNodes(root);
        return count;
    }

    public int recursiveNumNodes(DoubleBTNode n)
    {
        if (n == null)
        {
            return 0;
        }
        return recursiveNumNodes(n.getLeft()) + recursiveNumNodes(n.getRight()) + 1;
    }
    
    public double sum()
    {
        double sum = recursiveSum(root);
        return sum;
    }
    
    public double recursiveSum(DoubleBTNode n)
    {
        if (n == null)
        {
            return 0;
        }
        return recursiveSum(n.getLeft()) + recursiveSum(n.getRight()) + n.getData();
    }
    
    public double getSmallest()
    {
        double smallest = recursiveGetSmallest(root);
        return smallest;
    }
    
    public double recursiveGetSmallest(DoubleBTNode n)
    {
        if (n == null)
        {
            return 0;
        }
        if (n.getLeft() == null && n.getRight() == null)
        {
            return n.getData();
        }
        return recursiveGetSmallest(n.getLeft());
    }
    
    public double getLargest()
    {
        double largest = recursiveGetLargest(root);
        return largest;
    }
    
    public double recursiveGetLargest(DoubleBTNode n)
    {
        if (n == null)
        {
            return 0;
        }
        if (n.getLeft() == null && n.getRight() == null)
        {
            return n.getData();
        }
        return recursiveGetLargest(n.getRight());
    }
    
    public boolean negatives()
    {
        return recursiveNegatives(root);
    }
    
    public boolean recursiveNegatives(DoubleBTNode n)
    {
        if (n == null)
        {
            return false;
        }
        if (n.getData() < 0)
        {
            return true;
        }
        return recursiveNegatives(n.getLeft());
    }
    
    public boolean find (double v)
    {
        return recursiveFind(root, v);
    }
    
    public boolean recursiveFind(DoubleBTNode n, double v)
    {
        if (n == null)
        {
            return false;
        }
        if (v == n.getData())
        {
            return true;
        }
        if (v > n.getData())
        {
            return recursiveFind(n.getRight(), v);
        }
        return recursiveFind(n.getLeft(), v);
    }
}