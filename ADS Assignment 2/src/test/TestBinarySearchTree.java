package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.*;
import java.util.Arrays;

public class TestBinarySearchTree {
    @Test
    public void empty(){
        BinarySearchTree bst = BinarySearchTree.createBinarySearchTree(new int[] {});
        assertTrue(bst.setEmpty());
    }

    @Test
    public void size() {
        BinarySearchTree bst = BinarySearchTree.createBinarySearchTree(new int[] {1,2,3,4,5});
        assertEquals(5, bst.setSize());
    }

    @Test
    public void isElement() {
        BinarySearchTree bst = BinarySearchTree.createBinarySearchTree(new int[] {1,2,3,4,5});
        assertTrue(bst.isElement(5));
        assertFalse(bst.isElement(6));
    }

    @Test
    public void add() {
        BinarySearchTree bst = BinarySearchTree.createBinarySearchTree(new int[] {1,2,3,4,5});
        bst.add(6);
        bst.add(6);
        assertTrue(bst.isElement(6));
        assertEquals(6, bst.setSize());
    }

    @Test
    public void remove() {
        BinarySearchTree bst = BinarySearchTree.createBinarySearchTree(new int[] {1,2,3,4,5});
        bst.remove(4);
        assertEquals(4, bst.setSize());
        assertFalse(bst.isElement(4));
    }

    @Test
    public void union() {
        BinarySearchTree tree1 = BinarySearchTree.createBinarySearchTree(new int[] {1,2,3,4,5});
        BinarySearchTree tree2 = BinarySearchTree.createBinarySearchTree(new int[] {5,6,7,8,9});
        BinarySearchTree union = tree1.union(tree2);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(union.toArray()));
        assertEquals(9, union.setSize());
    }

    @Test
    public void intersection() {
        BinarySearchTree tree1 = BinarySearchTree.createBinarySearchTree(new int[] {1,2,3,4,5});
        BinarySearchTree tree2 = BinarySearchTree.createBinarySearchTree(new int[] {5,6,7,8,9});
        BinarySearchTree intersection = tree1.intersection(tree2);
        assertEquals("[5]", Arrays.toString(intersection.toArray()));
        assertEquals(1, intersection.setSize());
    }

    @Test
    public void difference() {
        BinarySearchTree tree1 = BinarySearchTree.createBinarySearchTree(new int[] {1,2,3,4,5});
        BinarySearchTree tree2 = BinarySearchTree.createBinarySearchTree(new int[] {5,6,7,8,9});
        BinarySearchTree difference = tree1.difference(tree2);
        assertEquals("[1, 2, 3, 4]", Arrays.toString(difference.toArray()));
        assertEquals(4, difference.setSize());
    }

    @Test
    public void subset() {
        BinarySearchTree tree1 = BinarySearchTree.createBinarySearchTree(new int[] {1,2,3,4,5});
        BinarySearchTree tree2 = BinarySearchTree.createBinarySearchTree(new int[] {5,6,7,8,9});
        BinarySearchTree tree3 = BinarySearchTree.createBinarySearchTree(new int[] {1,2,3,4,5,6});

        boolean subset1 = tree1.subset(tree2);
        boolean subset2 = tree1.subset(tree3);

        assertFalse(subset1);
        assertTrue(subset2);
    }
}
