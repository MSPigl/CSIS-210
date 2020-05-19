
/**
 * Code to unit test the AList implementation of ListInterface
 * 
 * @author R. Flatland 
 */
public class TestListInterface
{
    private int score;
    private int maxscore;

    public TestListInterface()
    {
 
    }

    public void test()
    {
        score = 0;
        maxscore = 0;
                 
        LList<Integer> list1 = new LList<Integer>( );
        
        // Test add methods and getLength method
        list1.add( 1 );
        list1.add( 2 );
        list1.add( 3 );
        list1.add( 4 );
        
        if ( list1.getLength() == 4 ) score++; else System.out.println("Error 1.");
        maxscore++;
        
        if ( list1.add( 5 ) == true ) score++; else System.out.println("Error 2.");
        maxscore++;
        
        if ((list1.getEntry(2) != null) && (list1.getEntry(2) == 2 )) score++; else System.out.println("Error 3.");
        maxscore++;
        if (( list1.getEntry(5) != null) && (list1.getEntry(5) == 5 )) score++; else System.out.println("Error 4.");
        maxscore++;
        
        if ( list1.add(2, 6) == true) score++; else System.out.println("Error 5.");
        maxscore++;
        if (( list1.getEntry(2) != null) && (list1.getEntry(2) == 6 )) score++; else System.out.println("Error 6.");
        maxscore++;
        if (( list1.getEntry(3) != null) && (list1.getEntry(3) == 2 )) score++; else System.out.println("Error 7.");
        maxscore++;
        if (( list1.getEntry(6) != null) && (list1.getEntry(6) == 5 )) score++; else System.out.println("Error 8.");
        maxscore++;
        
        if ( list1.add(1, 20) == true) score++; else System.out.println("Error 9.");
        maxscore++;
        if (( list1.getEntry( 1 ) != null ) && ( list1.getEntry( 1 ) == 20 )) score++; else System.out.println("Error 10.");
        maxscore++;
        
        if ( list1.add(9, 6) == false) score++; else System.out.println("Error 11.");
        maxscore++;
        if ( list1.add(20, 6) == false) score++; else System.out.println("Error 12.");
        maxscore++;
        if ( list1.add(7, 6) == true) score++; else System.out.println("Error 13.");
        maxscore++;
                
        if ( list1.getLength() == 8 ) score++; else System.out.println("Error 14.");
        maxscore++;
        
        
        // Test replace method
        LList<Integer> list2 = new LList<Integer>( );
        if (list2.replace( 4, 8 ) == false) score++; else System.out.println("Error 15.");
        maxscore++;
        if (list2.replace( 0, 8 ) == false) score++; else System.out.println("Error 16.");
        maxscore++;
        if (list2.replace( -3, 8 ) == false) score++; else System.out.println("Error 17.");
        maxscore++;
        
        for (int i = 1; i <= 10; i++ ) 
            list2.add( i );
        
        if ( list2.replace( 5, 15 ) == true ) score++; else System.out.println("Error 18.");
        maxscore++;
        if (( list2.getEntry(5) != null) && (list2.getEntry(5) == 15 )) score++; else System.out.println("Error 19.");
        maxscore++;
        if ( list2.replace( -5, 4 ) == false ) score++; else System.out.println("Error 20.");
        maxscore++;
        
        // Test Remove method
        LList<Integer> list3 = new LList<Integer>( );
                
        if (list3.remove( 5 ) == null) score++; else System.out.println("Error 21.");
        maxscore++;
        
        for (int i = 1; i <= 10; i++ ) 
            list3.add( i );
           
        if ((list3.getEntry( 5 ) != null) && (list3.remove( 5 ) == 5)) score++; else System.out.println("Error 22.");
        maxscore++;
        
        if ((list3.getEntry( 1 ) != null) && (list3.remove( 1 ) == 1)) score++; else System.out.println("Error 23.");
        maxscore++;
        
        if ((list3.getEntry( 1 ) != null ) && (list3.getEntry( 1 ) == 2)) score++; else System.out.println("Error  24.");
        maxscore++;
        
        // Test isEmpty & isFull & clear methods
        LList<Integer> list4 = new LList<Integer>( );
                
        if (list4.isEmpty() == true) score++; else System.out.println("Error 25.");
        maxscore++;
        if (list4.isFull() == false) score++; else System.out.println("Error 26.");
        maxscore++;
        
        list4.add( 1 );
        if (list4.isEmpty() == false) score++; else System.out.println("Error 27.");
        maxscore++;
        
        for (int i = 2; i <= 10; i++ ) 
            list4.add( i );
            
        if (list4.isFull() == false) score++ ;else System.out.println("Error 28."); 
        maxscore++;
        
        list4.clear();
        if (list4.isEmpty() == true) score++; else System.out.println("Error 29.");
        maxscore++;
       
        // test contains and reverse methods
        for (int i = 1; i <= 7; i++ ) 
            list4.add( i );
            if (list4.contains(5) ) score++; else System.out.println("Problem with contains method.");
                 maxscore++;
            if (!list4.contains(15) ) score++; else System.out.println("Problem with contains method.");
                 maxscore++;
                 
                  
        System.out.println( "You scored " + score + " out of a possible " + maxscore + " points." );
        if ( score < maxscore ) System.out.println( "Keep on it - you can fix the bugs!" );
        else System.out.println( "You rock -- a perfect score!" );
        
        System.out.println("List4 before reverse");
        list4.display();
        list4.reverse();
        System.out.println("List4 after reverse");
         list4.display();
             
    }
}
