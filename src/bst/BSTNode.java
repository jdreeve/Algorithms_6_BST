package bst;

public class BSTNode {

	private BSTNode p;
	private BSTNode left;
	private BSTNode right;
	int key;
	
	
	BSTNode(int key){
		this.key = key;
		this.p = null;
		this.left = null;
		this.right = null;
	}//constructor


	public BSTNode getP() {
		return p;
	}


	public BSTNode setP(BSTNode p) {
		this.p = p;
		return p;
	}


	public BSTNode getLeft() {
		return left;
	}


	public BSTNode setLeft(BSTNode left) {
		this.left = left;
		return left;
	}


	public BSTNode getRight() {
		return right;
	}


	public BSTNode setRight(BSTNode right) {
		this.right = right;
		return right;
	}


	public int getKey() {
		return key;
	}


	public int setKey(int key) {
		this.key = key;
		return key;
	}

}
