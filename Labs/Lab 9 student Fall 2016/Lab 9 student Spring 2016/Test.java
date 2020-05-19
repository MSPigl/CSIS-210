//
// Class used to test DoubleBinarySearchTree methods
//
public class Test
{
  public static void testBST()
  {
    int score;
    
    score = 0;
    try { 
     DoubleBinarySearchTree bst = new DoubleBinarySearchTree();
     System.out.println( "Testing getLargest method..." );
     bst.add( 4 );
     double lar1 = bst.getLargest( );
     if ( lar1 == 4 ) score++;
     bst.add( 2 );
     bst.add( 6 );
     bst.add( 1 );
     bst.add( 3 );
     bst.add( 5 );
     bst.add( 7 );
     double lar2 = bst.getLargest( );
     if ( lar2 == 7 ) score++;
     bst.add( 15 );
     double lar3 = bst.getLargest( );
     if ( lar3 == 15 ) score++;
    }
    catch (Exception e ) {
        System.out.println( "    exception raised!" );
    }
    System.out.println( "    You scored " + score + " out of 3 possible points" );
    
    score = 0;
    try { 
     DoubleBinarySearchTree bst = new DoubleBinarySearchTree();
     System.out.println( "Testing getParent method..." );
     bst.add( 4 );
     bst.add( 2 );
     bst.add( 6 );
     bst.add( 1 );
     bst.add( 3 );
     bst.add( 5 );
     bst.add( 7 );
     DoubleBTNode p1 = bst.getParent( 4 );
     if ( p1 == null ) score++;
     DoubleBTNode p2 = bst.getParent( 2 );
     if ( p2.getData() == 4 ) score++;
     DoubleBTNode p3 = bst.getParent( 3 );
     if ( p3.getData() == 2 ) score++;
     DoubleBTNode p4 = bst.getParent( 5 );
     if ( p4.getData() == 6 ) score++;
     DoubleBTNode p5 = bst.getParent( 7 );
     if ( p5.getData() == 6 ) score++;
    }
    catch (Exception e ) {
        System.out.println( "    exception raised!" );
    }
    System.out.println( "    You scored " + score + " out of 5 possible points" );
    
    score = 0;
    try { 
     DoubleBinarySearchTree bst = new DoubleBinarySearchTree();
     System.out.println( "Testing delete case 0 (v is not in tree)..." );
     bst.delete( 4 ); 
     score++; // if it didn't crash on an empty tree, then you get the point
     bst.add( 4 );
     bst.add( 2 );
     bst.add( 6 );
     bst.add( 1 );
     bst.add( 3 );
     bst.add( 5 );
     bst.add( 7 );
     bst.delete( 7.5 ); 
     score++; // if it didn't crash when v is not in tree, then you get the point
    }
    catch (Exception e ) {
        System.out.println( "    exception raised!" );
    }
    System.out.println( "    You scored " + score + " out of 2 possible points" );
    
    
    score = 0;
    try { 
     DoubleBinarySearchTree bst = new DoubleBinarySearchTree();
     System.out.println( "Testing delete case 1 (v is at a leaf node)..." );
     bst.add( 4 );
     bst.add( 2 );
     bst.add( 6 );
     bst.add( 1 );
     bst.add( 3 );
     bst.add( 5 );
     bst.add( 7 );
     bst.delete( 7 ); 
     score++; // if it didn't crash when v is at a leaf, then you get the point 
     if ( bst.find( 7 ) == false ) score++;
     if ( bst.find( 5 ) == true ) score++;
     bst.delete( 5 ); 
     score++; // if it didn't crash when v is at a leaf, then you get the point
     if ( bst.find( 5 ) == false ) score++;
     if ( bst.find( 6 ) == true ) score++;
     bst.delete( 6 ); 
     score++; // if it didn't crash when v is at a leaf, then you get the point
     if ( bst.find( 6 ) == false ) score++;
    }
    catch (Exception e ) {
        System.out.println( "    exception raised!" );
    }
    System.out.println( "    You scored " + score + " out of 8 possible points" );
        
    score = 0;
    try { 
     DoubleBinarySearchTree bst1 = new DoubleBinarySearchTree();
     System.out.println( "Testing delete case 2 (4 possibilities) (v is has one child)..." );
     bst1.add( 4 );
     bst1.add( 5 );
     bst1.add( 6 );
     bst1.add( 7 );
     bst1.add( 8 );
     bst1.delete( 6 ); 
     if ( bst1.find( 6 ) == false ) score++;
     if ( bst1.find( 5 ) == true ) score++;
     if ( bst1.find( 7 ) == true ) score++;
     DoubleBinarySearchTree bst2 = new DoubleBinarySearchTree();
     bst2.add( 4 );
     bst2.add( 3 );
     bst2.add( 2 );
     bst2.add( 1 );
     bst2.add( 0 );
     bst2.delete( 2 ); 
     if ( bst2.find( 2 ) == false ) score++;
     if ( bst2.find( 1 ) == true ) score++;
     if ( bst2.find( 3 ) == true ) score++;
     DoubleBinarySearchTree bst3 = new DoubleBinarySearchTree();
     bst3.add( 4 );
     bst3.add( 9 );
     bst3.add( 5 );
     bst3.add( 6 );
     bst3.add( 7 );
     bst3.delete( 5 ); 
     if ( bst3.find( 5 ) == false ) score++;
     if ( bst3.find( 9 ) == true ) score++;
     if ( bst3.find( 6 ) == true ) score++;
     
     DoubleBinarySearchTree bst4 = new DoubleBinarySearchTree();
     bst4.add( 4 );
     bst4.add( 0 );
     bst4.add( 3 );
     bst4.add( 2 );
     bst4.add( 1 );
     bst4.delete( 3 ); 
     if ( bst4.find( 3 ) == false ) score++;
     if ( bst4.find( 0 ) == true ) score++;
     if ( bst4.find( 2 ) == true ) score++;
    }
    catch (Exception e ) {
        System.out.println( "    exception raised!" );
    }
    System.out.println( "    You scored " + score + " out of 12 possible points" );
    
    // two children - root
      score = 0;
    try { 
     DoubleBinarySearchTree bst = new DoubleBinarySearchTree();
     System.out.println( "Testing delete case 3 root (node with two children)..." );
     bst.delete( 4 ); 
     score++; // if it didn't crash on an empty tree, then you get the point
     bst.add( 4 );
     bst.add( 2 );
     bst.add( 6 );
     bst.add( 1 );
     bst.add( 3 );
     bst.add( 5 );
     bst.add( 7 );
     System.out.println("right before delete of 4.");
     bst.delete( 4 ); 
     if (bst.find( 4) == false) score++; // if it didn't crash when v is not in tree, then you get the point
     System.out.println("Tree should not have a 4 in it.");
     bst.printAll(); 
    }
    catch (Exception e ) {
        System.out.println( "    exception raised!" );
    }
    System.out.println( "    You scored " + score + " out of 2 possible points" );
    
     // two children - not root
      score = 0;
    try { 
     DoubleBinarySearchTree bst = new DoubleBinarySearchTree();
     System.out.println( "Testing delete case 3 (node with two children)..." );
     bst.delete( 6 ); 
     score++; // if it didn't crash on an empty tree, then you get the point
     bst.add( 4 );
     bst.add( 2 );
     bst.add( 6 );
     bst.add( 1 );
     bst.add( 3 );
     bst.add( 5 );
     bst.add( 7 );
     System.out.println("right before delete of 6.");
     bst.delete( 6 ); 
     if (bst.find( 6) == false) score++; // if it didn't crash when v is not in tree, then you get the point
     System.out.println("Tree should not have a 6 in it.");
     bst.printAll(); 
    }
    catch (Exception e ) {
        System.out.println( "    exception raised!" );
    }
    System.out.println( "    You scored " + score + " out of 2 possible points" );
    
    System.out.println("DONE!");
    
  }
  
  
  public static void main(String args[]){
	Test testClient = new Test();
	testClient.testBST();
  }
  
}
