import java.util.*;
import java.io.*;

/**
 * Performs various set operations using the LList ADT of type String to represent sets
 * @author Matthew Pigliavento
 * @version 11/04/2016
 */
public class BoolOps
{
    /**
     * Performs the union set operation
     * @param list1 an LList of Strings
     * @param list2 an LList of Strings
     * @return unionList the union of list1 and list2 stored as an LList
     */
    public LList<String> union(LList<String> list1, LList<String> list2)
    {
        LList<String> unionList = new LList<String>();
        // adds all elements from list1 into LList unionList
        for (int i = 1; i <= list1.getLength(); i++)
        {
            unionList.add(list1.getEntry(i));
        }
        // adds elements from list2 that do not exist in list 1 into LList unionList
        for (int i = 1; i <= list2.getLength(); i++)
        {
            if (!list1.contains(list2.getEntry(i)))
            {
                unionList.add(list2.getEntry(i));
            }
        }
        return unionList;
    }

    /**
     * Performs the intersection set operation 
     * @param list1 an LList of Strings
     * @param list2 an LList of Strings
     * @return intersectList the intersection of list1 and list 2 stored as an LList
     */
    public LList<String> intersection(LList<String> list1, LList<String> list2)
    {
        LList<String> intersectList = new LList<String>();
        // returns an empty set if either LList parameter is empty
        if (list1.isEmpty() || list2.isEmpty())
        {
            return intersectList;
        }
        // adds elements from list1 into LList intersectList if they 
        // exist in list2 and do not already exist in intersectList
        for (int i = 1; i <= list1.getLength(); i++)
        {
            if (list2.contains(list1.getEntry(i)) && !intersectList.contains(list1.getEntry(i)))
            {
                intersectList.add(list1.getEntry(i));
            }
        }
        // adds elements from list2 into LList intersectList if they 
        // exist in list1 and do not already exist in intersectList
        for (int i = 1; i <= list2.getLength(); i++)
        {
            if (list1.contains(list2.getEntry(i)) && !intersectList.contains(list2.getEntry(i)))
            {
                intersectList.add(list2.getEntry(i));
            }
        }
        return intersectList;
    }

    /**
     * Performs the difference set operation for list1 and list2
     * @param list1 an LList of Strings
     * @param list2 an LList of Strings
     * @return differenceList the difference between list1 and list2 stored as an LList
     */
    public LList<String> difference(LList<String> list1, LList<String> list2)
    {
        LList<String> differenceList = new LList<String>();
        // adds elements of list1 to LList differenceList if list2 does not contain the elements 
        for (int i = 1; i <= list1.getLength(); i++)
        {
            if (!list2.contains(list1.getEntry(i)))
            {
                differenceList.add(list1.getEntry(i));
            }
        }
        return differenceList;
    }

    /**
     * Checks whether list1 is a subset of list2
     * @param list1 an LList of Strings
     * @param list2 an LList of Strings
     * @return true if list1 is a subset of list2, false if not
     */
    public boolean subset(LList<String> list1, LList<String> list2)
    {
        boolean sub = false;
        // returns true if all elements in list1 are present in list2
        // or if list1 is empty
        for (int i = 1; i <= list1.getLength(); i++)
        {
            if (!list2.contains(list1.getEntry(i)))
            {
                sub = false;
                break;
            }
            sub = true;
        }
        if (sub == true || list1.isEmpty())
        {
            return true;
        }
        return false;
    }

    /**
     * Checks whether or not list1 and list2 are equivalent
     * @param list1 an LList of Strings
     * @param list2 an LList of Strings
     * @return true if list1 is equivalent to list2, false if not
     */
    public boolean equivalent(LList<String> list1, LList<String> list2)
    {
        boolean equal1 = false;
        boolean equal2 = false;
        // checks if all elements of list1 are present in list2
        for (int i = 1; i <= list1.getLength(); i++)
        {
            if (!list2.contains(list1.getEntry(i)))
            {
                equal1 = false;
                break;
            }
            equal1 = true;
        }
        // checks if all elements of list2 are present in list1
        for (int i = 1; i <= list2.getLength(); i++)
        {
            if (!list1.contains(list2.getEntry(i)))
            {
                equal2 = false;
                break;
            }
            equal2 = true;
        }
        // returns true if all elements of list1 are present in list2
        if (equal1 && equal2)
        {
            return true;
        }
        return false;
    }

    /**
     * Tests methods of class BoolOps
     */
    public void test()
    {
        System.out.println("Boolean set operations:");
        System.out.println();

        // defines two lists, list1 and list2 of type String
        LList<String> list1 = new LList<String>();
        LList<String> list2 = new LList<String>();

        // define and open file using scanner 
        String fileName = "testlist.txt";
        Scanner fromFile = null;

        // opens file, prints error message if file is not found
        try
        {
            fromFile = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("Cannot open " + fileName + " check if it exist in this project directory");
            return;
        }

        // read in two lines of data into list1 and list2 
        while (fromFile.hasNextLine()) 
        {
            // list 1
            String nextLine = fromFile.nextLine();
            StringTokenizer st = new StringTokenizer(nextLine);
            while (st.hasMoreTokens() ) {
                String item = st.nextToken();                
                if (!list1.contains(item))
                {
                    list1.add(item);
                }
            }

            // list 2
            nextLine = fromFile.nextLine();
            st = new StringTokenizer(nextLine);
            while (st.hasMoreTokens() ) {
                String item = st.nextToken();                
                if (!list2.contains(item))
                {
                    list2.add(item);
                }
            }

            //Prints Set1 and Set2
            //Set1
            System.out.print("Set1 = ");
            list1.display();

            //Set2
            System.out.print("Set2 = ");
            list2.display();

            // calls method union and stores the returned LList in LList unionList, then displays it
            LList<String> unionList = union(list1, list2);
            System.out.print("Union of Set1 and Set2 is ");
            unionList.display();

            // calls method intersection and stores the returned LList in LList intersectList, then displays it
            LList<String> intersectList = intersection(list1, list2);
            System.out.print("Intersection of Set1 and Set2 is ");
            intersectList.display();

            // calls method difference with both possible arrangements of list1 and list2,
            // stores the returned LLists in LList diff1 and diff2, then displays them
            LList<String> diff1 = difference(list1, list2);
            LList<String> diff2 = difference(list2, list1);
            System.out.print("The difference between Set1 and Set2 is ");
            diff1.display();
            System.out.print("The difference between Set2 and Set1 is ");
            diff2.display();

            // calls method subset with both possible arrangements of list1 and list2
            // then outputs to terminal whether the first parameter is a subset of the second or not
            if(subset(list1, list2))
            {
                System.out.println("Set1 is a subset of Set2.");
            }
            else
            {
                System.out.println("Set1 is not a subset of Set2.");
            }
            if (subset(list2, list1))
            {
                System.out.println("Set2 is a subset of Set1.");
            }
            else
            {
                System.out.println("Set2 is not a subset of Set1.");
            }

            // calls method equivalent and outputs to terminal whether the first parameter
            // is equivalent to the second or not
            if (equivalent(list1, list2))
            {
                System.out.println("Set1 and Set2 are equivalent.");
            }
            else
            {
                System.out.println("Set1 and Set2 are not equivalent.");
            }

            // clears both lists
            list1.clear();
            list2.clear();
            System.out.println();
        }
        System.out.println("Done!");
    }
} 