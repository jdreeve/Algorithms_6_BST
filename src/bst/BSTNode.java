/**
 * HW 6: Binary Search Trees
 * Written for CSCI 333, Prof. Adam Whitley
 * Implements BSTNode object, one node of a binary search tree.
 * Author:		Jesse Reeve
 * Contact: 	jreeve@unca.edu
 * Created:		3/20/2020
 */

package bst;

public class BSTNode {

	private BSTNode p;
	private BSTNode left;
	private BSTNode right;
	int key;
	
	/**
	 * Constructor for BSTNode object.
	 * @param key - the object's key.
	 */
	BSTNode(int key){
		this.key = key;
		this.p = null;
		this.left = null;
		this.right = null;
	}//constructor


	/**
	 * @return p
	 */
	public BSTNode getP() {
		return p;
	}


	/**
	 * @param p - handle to intended parent node
	 * @return p - handle to parent node
	 */
	public BSTNode setP(BSTNode p) {
		this.p = p;
		return this.p;
	}


	/**
	 * @return left
	 */
	public BSTNode getLeft() {
		return left;
	}


	/**
	 * @param left - handle to intended left node
	 * @return left - handle to left node
	 */
	public BSTNode setLeft(BSTNode left) {
		this.left = left;
		return this.left;
	}


	/**
	 * @return right
	 */
	public BSTNode getRight() {
		return right;
	}


	/**
	 * @param right - handle to intended right child
	 * @return right - handle to right child
	 */
	public BSTNode setRight(BSTNode right) {
		this.right = right;
		return this.right;
	}


	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}


	/**
	 * @param key the key to set
	 * @return key - value of key
	 */
	public int setKey(int key) {
		this.key = key;
		return this.key;
	}



}
