/**
 * Write a description of class StackADT here.
 * 
 * @author Matt Pigliavento 
 * @version October 14, 2016
 */
public class StackADT<T>
{
    // instance variables
    private int top;
    private T[] stack;
    private final int DEFAULT_SIZE=5;

    /**
     * Constructor for objects of class StackADT
     */
    public StackADT()
    {
        // initialise instance variables
        top = -1;
        stack = (T[]) new Object[DEFAULT_SIZE];
    }

    public StackADT(int size)
    {
        // initialise instance variables
        top = -1;
        stack = (T[]) new Object[size];     
    }
    
    public void clear()
    { 
        top = -1;
    }
    public T pop()
    {
        T result = null;
        if( top == -1)
        {
            return result;
        }
        result = stack[top];
        top--;
        return result;
    }

    public T peek()
    {
        T result = null;
        if(top == -1)
        {
            return result;
        }
        result = stack[top];        
        return result;
    }

    public void push(T newItem)
    {
        if(top == stack.length - 1)
        {
            T[] newStack = (T[]) new Object[stack.length * 2];
            for(int i =0; i < stack.length; i++)
            {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        top++;
        stack[top] = newItem;
    }
    public boolean isEmpty()
    {
        if(top == -1)
        {
            return true;
        }
        return false;
    }
    public boolean isFull(int cap)
    {
        if (top == cap-1)
        {
            return true;
        }
        return false;
    }
}