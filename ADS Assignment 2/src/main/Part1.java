package main;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Part1 {
    public static void main(String[] args) {
        BinarySearchTree bst = BinarySearchTree.createBinarySearchTree(new int[] {1,1,2,3,4,5});
        System.out.println(Arrays.toString(bst.toArray()));
    }
}