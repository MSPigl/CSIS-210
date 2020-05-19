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
    // added by rcy
    public double getLargest()
    { 
        // add your code here
        DoubleBTNode loc = root;
        double largest = loc.getData();
        // update loc and largest as we search for the largest value
        while (loc != null)
        {
            if (loc.getRight() != null)
            {
                largest = loc.getRight().getData(); 
            }           
            loc = loc.getRight();
        }
        return largest; // just so it compiles
    }

    public DoubleBTNode getParent(double v) {
        DoubleBTNode parent = null;
        DoubleBTNode loc = root;
        // base case, use find method, if value not found in tree return null
        if (!find(v))
        {
            return null;
        }
        // while v  not equal to data in loc, let parent trail loc and descend to left or right in our search
        while (v != loc.getData())
        {
            parent = loc;
            if (v > loc.getData())
            {
                loc = loc.getRight();
            }
            else
            {
                loc = loc.getLeft();
            }
        }
        return parent; // found, return parent node
    }

    //  efficient find 
    public boolean find(double v) {
        return recursiveFind(root, v);
    }

    private boolean recursiveFind(DoubleBTNode n, double v) {
        if (n == null) return false;
        if (v == n.getData()) return true;
        if (v < n.getData()) return recursiveFind(n.getLeft(), v );
        else return recursiveFind(n.getRight(),v);
    }

    public boolean delete(double v) { 
        // follow the comment instructions exactly and you will be ok

        // Case 0: check if v not found in tree (use find) then return false
        if (!find(v))
        {
            return false;
        }
        // special case: check if we are deleting the root then return deleteRoot(v)
        DoubleBTNode parent = getParent(v); // parent of node to delete
        DoubleBTNode deleteNode = null; //  node to delete,  SET this in code below
        deleteNode = root;
        if (parent == null)
        {            
            return deleteRoot(v);
        }

        boolean leftChild = false; // remember if node to be deleted is itself a left or right child
        // determine value of leftChild and deleteNode and fill them in
        if (v < parent.getData())
        {
            deleteNode = parent.getLeft();
            leftChild = true;
        }
        else
        {
            deleteNode = parent.getRight();
        }
        // case 1 check if deleteNode is a leaf, set correct child of parent node to null and return true
        if (deleteNode.isLeaf() && leftChild)
        {
            parent.setLeft(null);
            return true;
        }
        else if (deleteNode.isLeaf() && !leftChild)
        {
            parent.setRight(null);
            return true;
        }
        // case 3 check if deleteNode has two children
        // if so, find inorder successor of node to be deleted: right, then left as much as possible
        // go left as far as possible to find inorder successor
        // update inordervalue from inorder successor
        // actually delete inordersuccessor not deleteNode (call delete method recursively)
        // place remembered inordervalue into deleteNode and return true;
        if (deleteNode.getLeft() != null && deleteNode.getRight() != null)
        {
            DoubleBTNode inorderSuccessor = deleteNode.getRight();      
            double inordervalue = inorderSuccessor.getData();
            while (inorderSuccessor.getLeft() != null)
            {
                inorderSuccessor = inorderSuccessor.getLeft();
            }
            inordervalue = inorderSuccessor.getData(); 
            delete(inordervalue);
            deleteNode.setData(inordervalue);
            return true;
        }        
        // case 2 delete node with one child (must have only 1 child since we checked for zero and two children already)
        // case 2A, delete a node to on Parent's LEFT side (IF leftChild is true)
        //     if the node to be deleted has a left child: set parent's left child to deleted node's left child
        //     else set parent's left child to deleted node's right child
        //     return true
        if (leftChild)
        {
            if (deleteNode.getLeft() != null)
            {
                parent.setLeft(deleteNode.getLeft());
            }
            else
            {
                parent.setLeft(deleteNode.getRight());
            }
            return true;
        }
        // case 2B, else delete a node on Parent's RIGHT side (leftChild is false)
        //     if node to be deleted has a left child: set parent's right child to deleted node's left child
        //     else set parent's right child to deleted node's right child
        //     return true    
        else
        {
            if (deleteNode.getLeft() != null)
            {
                parent.setRight(deleteNode.getLeft());
            }
            else
            {
                parent.setRight(deleteNode.getRight());
            }
            return true;
        }
    } // end delete method

    private boolean deleteRoot(double v) {
        // case 1: check if root is a leaf, an easy delete and return true
        if (root.isLeaf())
        {
            root = null;
            return true;
        }
        // case 3, check that root has two children
        // if so, find inorder successor node and value
        // first go right
        // then left as far as possible
        // once we find inorder sucessor, save its value
        // delete successorr node
        // set root value to saved inorder  value and return true
        if (root.getLeft() != null && root.getRight() != null)
        {
            DoubleBTNode inorderSuccessor = root.getRight();      
            double inordervalue = inorderSuccessor.getData();
            while (inorderSuccessor.getLeft() != null)
            {
                inorderSuccessor = inorderSuccessor.getLeft();
            }
            inordervalue = inorderSuccessor.getData(); 
            delete (inordervalue);
            root.setData(inordervalue);
            return true;
        }        

        // case 2A delete root with left child, a simple delete, return true
        if (root.getLeft() != null)
        {
            root = root.getLeft();
            return true;
        }
        // case 2B delete root with right child, a simple delete
        if (root.getRight() != null)
        {
            root = root.getRight();
            return true;
        }
        return true;
    } // delete root
}       // end class