/**
 * Tests the recursive list methods.
 * 
 */
public class TestRecursiveMethods
{
public static void  main() {
    LList<Integer> seq1 = new LList<Integer>();
    int score, total;
    Integer d;
    Boolean b;
    
    score = 0;
    total = 0;
    
    seq1.add( 1 );
    seq1.add( 2 );
    seq1.add( 3 );
    seq1.add( 4 );
    seq1.add( 5 );   
    
    System.out.println( "On the next line should be: 1 2 3 4 5 " );
    seq1.recursivePrint();       
    
    int c = seq1.recursiveCount();
    if ( c == 5 ) score++;
    total++;
    
    System.out.println( "On the next line should be: 5 4 3 2 1 " );
    seq1.recursivePrintBackwards();       
    
    d = seq1.recursiveGetElement( 1 );
    if ((d != null) && ( d.equals(1) )) score++;
    total++;
    
    d = seq1.recursiveGetElement( 5 );
    if ((d != null) && ( d.equals(5) )) score++;
    total++;
    
    d = seq1.recursiveGetElement( 4 );
    if ((d != null) && ( d == 4 )) score++;
    total++;

       
    b = seq1.recursiveSearch( 3 );
    if ((b!=null) && ( b.equals(true) )) score++;
    total++;
    
    b = seq1.recursiveSearch( 1 );
    if ((b != null) && ( b.equals(true) )) score++;
    total++;

    b = seq1.recursiveSearch( 10 );
    if ((b != null) && ( b == false )) score++;
    total++;
    
    b = seq1.recursiveSearch( -5 );
    if ((b != null) && ( b.equals(false) )) score++;
    total++;

    System.out.println( "Your implementation scored " + score + " points out of " + total + " total points" );

}
}
