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
		
		for (int i = 0; i < inputArray.length; i++) {
			BSTNode temp = new BSTNode(inputArray[i]);
			testBST.insertWrapper(temp);
			System.out.printf("Inserting node with key %2d. Size: %d.\n", inputArray[i],testBST.getSize());
		}
		
		System.out.printf("Testing traversals.\n");
		System.out.println("Testing pre-order traversal:");
		testBST.preOrderTraversalWrapper();
		System.out.println("Testing post-order traversal:");
		testBST.postOrderTraversalWrapper();
		System.out.println("Testing in-order traversal:");
		testBST.inOrderTraversalWrapper();
		
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
		System.out.println("In-order traversal:");
		testBST.inOrderTraversalWrapper();
	}

}
