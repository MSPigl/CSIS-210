/**
 * @(Matthew Pigliavento)
 * @(Fall 2016)
 */
public class LList < T > implements ListInterface < T >
{
    private Node firstNode; // reference to first node
    private int length;     // number of entries in list

    public LList ()
    {
        firstNode = null;
        length = 0;
    } // end default constructor

    public final void clear ()
    {
        firstNode = null;
        length = 0;
    } // end clear

    public boolean replace (int givenPosition, T newEntry)
    {
        if (givenPosition > length || givenPosition < 1)
        {
            return false;
        }
        getNodeAt(givenPosition).data = newEntry;
        return true;
    }

    public boolean add (T newEntry)
    {
        if (isFull())
        {
            return false;
        }
        if (length == 0)
        {
            Node newNode = new Node(newEntry);
            length++;
            firstNode = newNode;
        }
        else
        {
            Node newNode = new Node(newEntry);
            Node t = getNodeAt(length);
            t.next = newNode;
            length++;
        }
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
            else // case 2: list is not empty and newPosition > 1
            {
                Node p = getNodeAt(newPosition - 1);
                Node c = getNodeAt(newPosition);
                newNode.next = c;
                p.next = newNode;
            } // end if
            length++;
        }
        else
        {
            isSuccessful = false;
        }
        return isSuccessful;
    } // end add

    public T remove (int givenPosition) 
    {
        if (givenPosition > length || givenPosition < 1)
        {
            return null;
        }
        T removedEntry = null;
        if (length == 1 || givenPosition == 1)
        {
            removedEntry = firstNode.data;
            firstNode = firstNode.next;
        }
        else
        {
            removedEntry = getNodeAt(givenPosition).data;
            Node p = getNodeAt(givenPosition - 1);
            Node c = getNodeAt(givenPosition + 1);
            p.next = c;
            length--;
        }
        return removedEntry;
    } // end remove

    public T getEntry (int givenPosition)
    {
        if (givenPosition > length || givenPosition < 1)
        {
            return null;
        }
        Node currentNode = getNodeAt(givenPosition);
        return currentNode.data;
    } // end getEntry

    public void reverse ( )
    {
        Node currentNode = null;
        T originalData = null;
        T swapData = null;
        int count = length;
        for (int i = 1; i < count; i++)
        {
               originalData = getNodeAt(i).data;
               swapData = getNodeAt(count).data;
               getNodeAt(i).data = swapData;
               getNodeAt(count).data = originalData;
               count--;
        }
    } // end reverse

    public boolean contains (T anEntry)
    {
        Node currentNode = null;
        currentNode = firstNode;
        for (int i = 1; i < length; i++)
        {
            if (currentNode.data == anEntry)
            {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    } // end contains

    public int getLength ()
    {
        return length;
    } // end getLength

    public void display ()
    {
        Node currentNode = firstNode;
        while (currentNode != null)
        {
            System.out.println (currentNode.data);
            currentNode = currentNode.next;
        } // end while
    } // end display

    public boolean isFull ()
    {
        return false;
    } //end isFull

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

    /** Task: Returns a reference to the node at a given position.
     * Precondition: List is not empty; 1 <= givenPosition <= length. */
    private Node getNodeAt (int givenPosition)
    {
        if (givenPosition > length || givenPosition < 1)
        {
            return null;
        }
        Node currentNode = firstNode;
        for (int i = 1; i < givenPosition; i++)
        {
            currentNode = currentNode.next;
        }
        return currentNode;
    } // end getNodeAt

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