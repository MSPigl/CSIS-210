//
// Class used to test DoubleBinarySearchTree methods
//
public class Test
{
    public static void main()
    {
        DoubleBinarySearchTree bst = new DoubleBinarySearchTree();

        // Test printAll
        bst.add( 4 );
        bst.add( 2 );
        bst.add( 6 );
        bst.add( 1 );
        bst.add( 3 );
        bst.add( 5 );
        bst.add( 7 );
        bst.printAll();

        System.out.println("Number of nodes: " + bst.numNodes());
        System.out.println("Sum of all elements in the tree: " + bst.sum());
        System.out.println("Smallest element in the tree: " + bst.getSmallest());
        System.out.println("Largest element in the tree: " + bst.getLargest());
        System.out.println("Negative elements in the tree? " + bst.negatives());
        System.out.println("Is 3 in the tree? " + bst.find(3));
        System.out.println("Is 11 in the tree? " + bst.find(11));
    }
}
