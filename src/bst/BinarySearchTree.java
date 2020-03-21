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
	 * @return size - the value of size
	 */
	public int getSize() {
		return size;
	}
	
	
}
