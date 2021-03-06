public class LList < T > implements ListInterface < T >
{
    private Node firstNode; // reference to first node
    private int length;     // number of entries in list
    public LList ()
    {
        clear ();
    } // end default constructor

    public final void clear ()
    {
        firstNode = null;
        length = 0;
    } // end clear

    ///////////////////////RECURSIVE PRINT//////////////////////////////

    // Prints the elements in the list 
    public void recursivePrint()
    {
        recursivePrint( firstNode );
        System.out.println();
    }

    // Prints the elements in the list 
    // beginning with node n
    private void recursivePrint( Node n ) {
        if ( n == null ) return;
        else {
            System.out.print( n.data + " ");
            recursivePrint( n.next );
        }
    }

    ///////////////////////RECURSIVE COUNT//////////////////////////////

    // Returns the count of the number of items in the list 
    public int recursiveCount()
    {
        int c = recursiveCount( firstNode );
        return c;
    }

    // Returns the count of the number of items in the list whose first node is n
    private int recursiveCount( Node n ) {        
        if (n == null)
        {
            return 0;
        }
        int count = recursiveCount(n.next);
        count++;
        return count;
    }

    ///////////////////////RECURSIVE PRINT BACKWARDS/////////////////////

    // Prints the elements in the list  in reverse order
    public void recursivePrintBackwards()
    {
        recursivePrintBackwards( firstNode );
        System.out.println();
    }

    // Prints the elements in the list 
    // beginning with node n in reverse order
    private void recursivePrintBackwards( Node n ) 
    {
        // Start with base case when n is null
        if (n == null)
        {
            return;
        }
        recursivePrintBackwards(n.next);
        System.out.print(n.data + " ");
    }

    //////////////////////////RECURSIVE SEARCH  ///////////////////////////

    // Returns: true if value is an element of the sequence
    // and false otherwise.
    public boolean recursiveSearch( T value )
    {
        if ( firstNode == null ) return false;
        else return recursiveSearch( firstNode, value );
    }

    // Returns: true if value is an element of the list 
    // beginning with node n, and false otherwise. 
    private boolean recursiveSearch( Node n, T value ) 
    {
        // Start with base case when n is null (an empty list)
        if (n == null)
        {
            return false;
        }        
        if (n.data == value)
        {
            return true;
        }
        return (recursiveSearch(n.next, value));
    }

    ///////////////////////RECURSIVE GET ELEMENT ////////////////////////
    // Returns: the element in the ith position in the sequence, if there is one. If there
    // is no ith element, then it returns null. 
    public T recursiveGetElement( int i )
    {
        if (( i <= 0) || (i > length)) return null;
        else 
            return recursiveGetElement( firstNode, i );
    }

    // Returns: the element in the ith position in the list beginning with node n. 
    // It assumes that an ith element exists. (I.e. this method should never be called unless
    // there is an ith element in the list beginning with node n.)
    private T recursiveGetElement( Node n, int i )
    {
        //static int pos = 0;
        if (n == null)
        {
            return null;
        }
        if (n == getNodeAt(i))
        {
            return n.data;
        }
        return recursiveGetElement(n.next, i);
    }

    public boolean add (T newEntry)
    {
        Node newNode = new Node (newEntry);
        if (isEmpty ())
            firstNode = newNode;
        else // add to end of nonempty list
        {
            Node lastNode = getNodeAt (length);
            lastNode.next = newNode; // make last node reference new node
        } // end if

        length++;
        return true;
    } // end add

    public boolean add (int newPosition, T newEntry)
    {
        boolean isSuccessful = true;
        if ((newPosition >= 1) && (newPosition <= length + 1))
        {
            Node newNode = new Node (newEntry);
            if (isEmpty () || (newPosition == 1)) // case 1
            {
                newNode.next = firstNode;
                firstNode = newNode;
            }
            else // case 2: list is not empty
            // and newPosition > 1
            {
                Node nodeBefore = getNodeAt (newPosition - 1);
                Node nodeAfter = nodeBefore.next;
                newNode.next = nodeAfter;
                nodeBefore.next = newNode;
            } // end if
            length++;
        }
        else
            isSuccessful = false;
        return isSuccessful;
    } // end add

    public void display ()
    {
        Node currentNode = firstNode;
        while (currentNode != null)
        {
            System.out.println (currentNode.data);
            currentNode = currentNode.next;
        } // end while
    } // end display

    public boolean isEmpty ()
    {
        boolean result;
        if (length == 0)
        {
            assert firstNode == null;
            result = true;
        }
        else
        {
            assert firstNode != null;
            result = false;
        } // end if
        return result;
    } // end isEmpty


    public boolean replace (int givenPosition, T newEntry)
    {
        boolean isSuccessful = true;
        if ((givenPosition >= 1) && (givenPosition <= length))
        {
            assert !isEmpty ();
            Node desiredNode = getNodeAt (givenPosition);
            desiredNode.data = newEntry;
        }
        else
            isSuccessful = false;
        return isSuccessful;
    } // end replace

    public T getEntry (int givenPosition)
    {
        T result = null; // result to return
        if ((givenPosition >= 1) && (givenPosition <= length))
        {
            assert !isEmpty ();
            result = getNodeAt (givenPosition).data;
        } // end if
        return result;
    } // end getEntry

    public T remove (int givenPosition)
    {
        T result = null; // return value
        if ((givenPosition >= 1) && (givenPosition <= length))
        {
            assert !isEmpty ();
            if (givenPosition == 1) // case 1: remove first entry
            {
                result = firstNode.data; // save entry to be removed
                firstNode = firstNode.next;
            }
            else // case 2: givenPosition > 1
            {
                Node nodeBefore = getNodeAt (givenPosition - 1);
                Node nodeToRemove = nodeBefore.next;
                Node nodeAfter = nodeToRemove.next;
                nodeBefore.next = nodeAfter; // disconnect the node to be removed
                result = nodeToRemove.data; // save entry to be removed
            } // end if
            length--;
        } // end if

        return result; // return removed entry, or
        // null if operation fails
    } // end remove

    public boolean isFull ()  // should ALWAYS return false
    {
        return false;
    }

    public boolean contains (T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null))
        {
            if (anEntry.equals (currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        } // end while
        return found;
    } // end contains

    /** Task: Returns a reference to the node at a given position.
     * Precondition: List is not empty; 1 <= givenPosition <= length. */
    private Node getNodeAt (int givenPosition)
    {
        assert !isEmpty () &&
        (1 <= givenPosition) && (givenPosition <= length);
        Node currentNode = firstNode;
        // traverse the list to locate the desired node
        for (int counter = 1 ; counter < givenPosition ; counter++)
            currentNode = currentNode.next;
        assert currentNode != null;
        return currentNode;
    } // end getNodeAt

    public int getLength() 
    {
        return length;    
    }

    public void reverse()
    {
        System.out.println( "LList.reverse -- Not implemented!" );   
    }
    private class Node // private inner class
    {
        private T data; // entry in list
        private Node next; // link to next node

        private Node (T dataPortion)
        {
            data = dataPortion;
            next = null;
        } // end constructor

        private Node (T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        } // end constructor

    } // end Node
} // end LList
