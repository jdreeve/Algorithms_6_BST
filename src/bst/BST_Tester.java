/**
 * HW 6: Binary Search Trees
 * Written for CSCI 333, Prof. Adam Whitley
 * Tests BinarySearchTree implementation.
 * Author:		Jesse Reeve
 * Contact: 	jreeve@unca.edu
 * Created:		3/20/2020
 */

package bst;

import java.util.Arrays;
import java.util.Random;

public class BST_Tester {

	public static void main(String[] args) {

		BinarySearchTree testBST = new BinarySearchTree();
		Random gen = new Random();
		int[] inputArray = new int[20];
		for (int i=0; i < inputArray.length; i++) {
			inputArray[i] = gen.nextInt(50)+i*100;
		}//for

		System.out.printf("Generated the following values:\n%s\n", Arrays.toString(inputArray));
		System.out.println();
		for (int i=0; i < inputArray.length; i++) {
			int randInt = gen.nextInt(inputArray.length);
			int temp = inputArray[i];
			inputArray[i] = inputArray[randInt];
			inputArray[randInt] = temp;
		}
		System.out.printf("Shuffling values... new order:\n%s\n",Arrays.toString(inputArray));
		System.out.println();
		for (int i = 0; i < inputArray.length; i++) {
			BSTNode temp = new BSTNode(inputArray[i]);
			testBST.insertWrapper(temp);
			System.out.printf("Inserting node with key %2d. Tree size: %d.\n", inputArray[i],testBST.getSize());
		}
		
		System.out.println();
		System.out.printf("Testing traversals.\n");
		System.out.println("Testing pre-order traversal:");
		testBST.preOrderTraversalWrapper();
		System.out.println();
		System.out.println("Testing post-order traversal:");
		testBST.postOrderTraversalWrapper();
		System.out.println();
		System.out.println("Testing in-order traversal:");
		testBST.inOrderTraversalWrapper();
		System.out.println();
		
		for (int i=0; i < inputArray.length; i+=inputArray.length/5) {
			System.out.printf("Searching for valid key %d: %d\n", inputArray[i], testBST.searchWrapper(inputArray[i]).getKey());
		}
		for (int i=0; i < inputArray.length; i+=inputArray.length/5) {
			System.out.printf("Searching for invalid key %d: %d\n", inputArray[i]+50, testBST.searchWrapper(inputArray[i]+50));
		}
		
		for (int i=0; i < inputArray.length; i+=inputArray.length/6) {
			testBST.deleteWrapper(testBST.searchWrapper(inputArray[i]));
			System.out.printf("Deleting key %d. Size: %d\n",inputArray[i],testBST.getSize());
		}
		System.out.println();
		System.out.println("In-order traversal:");
		testBST.inOrderTraversalWrapper();
		System.out.println();
		
		System.out.println("Querying and ranking order statistics.");

		for (int i = 1; i < 10; i+=2) {		
			System.out.printf("Order statistic %d: key %d\n", i, testBST.selectWrapper(i).getKey());
			System.out.printf("Key %d has rank: %d",testBST.selectWrapper(i).getKey(),testBST.rankWrapper(testBST.selectWrapper(i)));
		System.out.println();
		}//for
	}//main
}//BST_Tester
