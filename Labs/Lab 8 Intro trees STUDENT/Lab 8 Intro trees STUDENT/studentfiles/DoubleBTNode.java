public class DoubleBTNode
{ 
   private double data;
   private DoubleBTNode left;
   private DoubleBTNode right;

   // constructor
   public DoubleBTNode(double initData, DoubleBTNode initLeft, DoubleBTNode initRight )
   {
       data = initData;
       left = initLeft;
       right = initRight;
   }

   // accessor methods
   public double getData()        { return data; }
   public DoubleBTNode getLeft()  { return left; }
   public DoubleBTNode getRight() { return right; }

   // modification methods
   public void setData( double newData )         { data = newData; }
   public void setLeft( DoubleBTNode newLeft )   { left = newLeft; }
   public void setRight( DoubleBTNode newRight ) { right = newRight; }
   
   // Returns true if node invoking method is true, and false otherwise
   public boolean isLeaf( )
   {
      if ( ( left == null ) && ( right == null ) )
         return true;
      else
         return false;
   }
}
