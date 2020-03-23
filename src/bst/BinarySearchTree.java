/**
 * HW 6: Binary Search Trees
 * Written for CSCI 333, Prof. Adam Whitley
 * Implements BSTNode object, one node of a binary search tree.
 * Author:		Jesse Reeve
 * Contact: 	jreeve@unca.edu
 * Created:		3/20/2020
 */

package bst;

public class BinarySearchTree {

	private BSTNode root;
	private int size;
	
	/**
	 * Constructor for BinarySearchTree object.
	 */
	BinarySearchTree(){
		root = null;
		size = 0;
	}//constructor

	/**
	 * Replaces the subtree rooted at node u with the subtree rooted at node v
	 * @param u - root of the pruned subtree
	 * @param v - root of the grafted subtree
	 */
	private void transplant(BSTNode u, BSTNode v) {
		if (null==u.getP()) {//if u was root, v is now root
			root=v;
		}//if
		else if (u==u.getP().getLeft()){//if u was a left child, v is the new left child
			u.getP().setLeft(v);
		}//if
		else u.getP().setRight(v);
		if (v != null) {
			v.setP(u.getP());
		}
	}
	
	/**
	 * Returns the size of the tree.
	 * @return size - the value of size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Searches for a node with the indicated key.
	 * @param key - key value to search for
	 * @return node with correct key (null if not found)
	 */
	public BSTNode searchWrapper(int key) {
		return search(key);
	}
	
	
	/**
	 * Returns the node with smallest key.
	 * @return minimum key in tree (null if empty)
	 */
	public BSTNode minimumWrapper() {
		return minimum(root);
	}
	
	/**
	 * Returns the node with largest key.
	 * @return maximum value in tree (null if empty)
	 */
	public BSTNode maximumWrapper() {
		return maximum(root);
	}
	
	/**
	 * Returns the successor of a node.
	 * @param node - the input node
	 * @return the node with the next highest key value (null if none)
	 */
	public BSTNode successorWrapper(BSTNode node) {
		return successor(node);
	}
	
	/**
	 * Returns the predecessor of a node.
	 * @param node - the input node
	 * @return the node with the next smallest key value (null if none)
	 */
	public BSTNode predecessorWrapper(BSTNode node) {
		return predecessor(node);
	}
	
	/**
	 * Inserts a new node.
	 * @param node - the node to be inserted
	 */
	public void insertWrapper(BSTNode node) {
		insert(node);
	}
	
	/**
	 * @param node - the node to be deleted
	 */
	public void deleteWrapper(BSTNode node) {
		delete(node);
	}
	
	/**
	 * Prints a pre-ordered traversal of the tree.
	 */
	public void preOrderTraversalWrapper() {
		preOrderTraversal(root);
		System.out.println();
	}
	
	/**
	 * Prints a post-ordered traversal of the tree.
	 */
	public void postOrderTraversalWrapper() {
		postOrderTraversal(root);
		System.out.println();
	}
	
	/**
	 * Prints an in-order traversal of the tree.
	 */
	public void inOrderTraversalWrapper() {
		inOrderTraversal(root);
		System.out.println();
	}
	
	/**
	 * Prints a pre-ordered traversal of the subtree with root <node>.
	 * @param node - root of the subtree to be traversed
	 */
	public void preOrderTraversalWrapper(BSTNode node) {
		preOrderTraversal(node);
		System.out.println();
	}
	
	/** 
	 * Prints a post-ordered traversal of the subtree with root <node>.
	 * @param node - root of the subtree to be traversed
	 */
	public void postOrderTraversalWrapper(BSTNode node) {
		postOrderTraversal(node);
		System.out.println();
	}
	
	/**
	 * Prints an in-order traversal of the subtree with root <node>.
	 * @param node - root of the subtree to be traversed
	 */
	public void inOrderTraversalWrapper(BSTNode node) {
		inOrderTraversal(node);
		System.out.println();
	}//inOrderTraversalWrapper
	
	/**
	 * Locates order statistic i in entire tree.
	 * @param i - the order statistic to be located
	 * @return the order statistic (type BSTNode) (null if not found)
	 */
	public BSTNode selectWrapper(int i) {
		return select(i,this.root);
	}
	
	/**
	 * Locates order statistic i in subtree rooted at node.
	 * @param i
	 * @param node
	 * @return order statistic i (type BSTNode) (null if not found)
	 */
	public BSTNode selectWrapper(int i, BSTNode node) {
		return select(i,node);
	}
	
	/**
	 * Ranks a node in the full tree.
	 * @param node - the node to be ranked
	 * @return the rank (type int)
	 */
	public int rankWrapper(BSTNode node) {
		return rank(node, this.root);
	}
	
	/**
	 * Ranks a node in a given subtree.
	 * param node - the node to be ranked
	 * @param root - the root of the subtree to search
	 * @return
	 */
	public int rankWrapper(BSTNode node, BSTNode root) {
		return rank(node, root);
	}
	
	private BSTNode search(int key) {
		BSTNode target = root;
		while ((target != null) && (key != target.key)) {
			if (key < target.key) {//if target is in the left tree
				target = target.getLeft();
			}//if
			else {
				target = target.getRight();
			}//if
		}//while
		return target;
	}//search
	
	private BSTNode minimum(BSTNode x) {
		while (x.getLeft() != null) {
			x = x.getLeft();
		}//while
		return x;
	}//minimum
	
	private BSTNode maximum(BSTNode x) {
		while (x.getRight() != null) {
			x = x.getRight();
		}//while
		return x;
	}//maximum
	
	private BSTNode successor(BSTNode node) {
		if (node.getRight() != null) {
			return minimum(node.getRight());
		}//if
		while (node.getP() != null && node == node.getP().getRight()) {
			node = node.getP();
		}//while
		return node;
	}//successor
	
	private BSTNode predecessor(BSTNode node) {
		if (null != node.getLeft()) {
			return maximum(node.getLeft());
		}//if
		while (node.getP() != null && node == node.getP().getLeft()) {
			node = node.getP();
		}//while
		return node;
	}//predecessor
	
	private void insert(BSTNode node) {
		BSTNode y = null;
		BSTNode x = this.root;
		while (null != x) {
			y=x;
			if (node.getKey() < x.getKey()) {
				x = x.getLeft();
			}//if
			else x = x.getRight();
		}//while
		node.setP(y);
		if (null == y) {
			this.root = node;
		}//if
		else if (node.getKey() < y.getKey()) {
			y.setLeft(node);
		}
		else y.setRight(node);
		this.size++;
		//Augmentation for order statistic queries
		node.setSize(1);
		while (node.getP() != null) {
			node = node.getP();
			node.setSize(node.getSize()+1);
		}
	}//insert
	
	private void delete(BSTNode node) {
		BSTNode y = null;
		//First augmentation for order statistic queries (1/2)
		BSTNode q = null;
		if (null == node.getLeft() || null == node.getRight()) {
			q = node.getP();
		}//if
		else {
			y = successor(node);
			if (y.getP() != node) {
				q = y.getP();
			}//if
			else q = y;
		}
		//end first augmentation
		if (search(node.getKey()) != null) {
			this.size--;
		}
		if (null == node.getLeft()) {
			transplant(node,node.getRight());
		}//if
		else if (null == node.getRight()) {
			transplant(node,node.getLeft());
		}//if
		else {
			y = successor(node);
			if (node != y.getP()) {
				transplant(y,y.getRight());
				y.setRight(node.getRight());
				y.getRight().setP(y);
			}//if
			transplant(node,y);
			y.setLeft(node.getLeft());
			y.getLeft().setP(y);
		}//if
		//Second augmentation for order statistic queries (2/2)
		while (q != null) {
			int qsize = 1;
			if (q.getLeft() != null) qsize += q.getLeft().getSize();
			if (q.getRight() != null) qsize += q.getRight().getSize();
			q.setSize(qsize);
			q = q.getP();
		}
		//end second augmentation
	}//delete
	
	private void preOrderTraversal(BSTNode node) {
		if (null != node) {
			System.out.printf("%d ",node.getKey());
			preOrderTraversal(node.getLeft());
			preOrderTraversal(node.getRight());
		}//if
	}//preOrderTraversal
	
	private void postOrderTraversal(BSTNode node) {
		if (null != node) {
			postOrderTraversal(node.getLeft());
			postOrderTraversal(node.getRight());
			System.out.printf("%d ",node.getKey());		
			}//if
	}
	
	private void inOrderTraversal(BSTNode node) {
		if (null != node) {
			inOrderTraversal(node.getLeft());
			System.out.printf("%d ",node.getKey());	
			inOrderTraversal(node.getRight());
			}//if
	}
	
	private BSTNode select(int i, BSTNode node) {
		if (node == null) return null;
		int r = 1;
		if (node.getLeft() != null) r += node.getLeft().getSize();
		if (i == r) {
			return node;
		}//if
		else if (i < r) {//look in left subtree
			return select(i,node.getLeft());
		}//else
		else return select(i-r, node.getRight());
	}
	
	private int rank(BSTNode node, BSTNode root) {
		if (node == null) return -1;
		int r = 1;
		if (node.getLeft() != null) r += node.getLeft().getSize();
		BSTNode y = node;
		while (y != root) {
			if (y == y.getP().getRight()) {//if y is a right child
				if (y.getP().getLeft() != null) r += y.getP().getLeft().getSize();
				r++;
			}//if
			y = y.getP();
		}//while
		return r;
	}
	
}
