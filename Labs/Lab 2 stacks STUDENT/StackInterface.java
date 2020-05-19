
/**
 * Write a description of interface StackInterface here.
 * 
 * @author (R. Yoder) 
 * @version (2/3/2016)
 */
public interface StackInterface<T>
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    public boolean isEmpty();
    public T pop();
    public T peek();
    public void push(T newItem);
    public void clear();
}
