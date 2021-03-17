package herman;

/**
 * 
 * @author KatherineHerman-Williams
 *
 */

//creates bst class with node attribute
public class BinarySearchTree {
	
	Node root;
	
	/**
	 * @param root node in bst
	 * @return returns true if the tree is empty
	 */
	public static boolean isEmpty(Node root){
		
		return (root == null);
	}
	
	/**
	 * @param root location of node in bst
	 * @param num value of the node
	 * @return searches left and right, returns true if node exists with num value,
	 * false if tree is empty
	 * 
	 */
	public boolean search(Node root, int num) {//sees if node exists
		if (isEmpty(root)) {
			return false;
		}
		if (root.key == num){
			return true;
		}
		
		boolean lookleft = search(root.leftChild, num);
		if (lookleft) {
			return true;
		}
		return search(root.rightChild, num);
		
	}
	/**
	 * 
	 * @param root location of node in bst
	 * @param val number value in node
	 * @return root returns location of node
	 */

	private Node addNode(Node root, int val) {
		if (isEmpty(root)) {
			return new Node(val);
		}
		   if (val > root.key){//if number is bigger than root it's added to the right
	        	root.rightChild = addNode(root.rightChild,val);//needed addNode function
	        }
	        else if (val < root.key)//if number is less it's added left of root
	        {root.leftChild = addNode(root.leftChild, val);
	        }
	        return root;
	}
	
	/**A public method to insert a value into the binary search tree (if it does not already exist). 
	 *  Inserts must occur at a leaf and the respective child pointers should be assigned correctly.
	 *  
	 *  @param val number value of the node to be inserted into the tree
	 */
	
	public void insertNode(int val) {
		root = addNode(this.root, val);//
	}
	
	
	/** public method that removes a specified node from the Binary Search Tree.  
	 * Consider the possible scenarios for deletion.  For example (a) the node to be removed 
	 * is not in the tree, (b) the node to be removed has no children, (c) the node to be 
	 * removed had one child, and (d) the node to be removed has two children. Following a deleted node, 
	 * respective node pointers much be correctly re-assigned.
	 * 
	 * @param val number value of the node to be deleted
	 * 
	 */
	
	public void deleteNode(int val) {//sees if node exists, extracts if it does
		boolean here = search(this.root, val);//sees if node exists
		
		if (here) {
			this.root = exNode(this.root, val);//if node exists exNodes extracts from tree
		}
		else {
			System.out.println("does not exist");//if node does not exist
		}
	}
	/**
	 * 
	 * @param root location of node being removed
	 * @param num value of node being removed
	 * @return returns null if tree is empty, otherwise returns tree without Node
	 */
	
	private Node exNode(Node root, int num) {  //extract
		
		if (isEmpty(root)) {//checks if tree is empty
			return null;
		}
		
        if (num > root.key){//checks if num is to the right of root
        	root.rightChild = exNode(root.rightChild, num);//if num is to the right sends next node
        	}
        else if (num < root.key){//checks if num is to the left of root
        	root.leftChild = exNode(root.leftChild, num);//if num is to the left sends next node
        	}
        else{
            if (root.rightChild == null){//if root does not have right child, jumps to left
            	return root.leftChild;
            	}
            else if(root.leftChild == null){//jumps to right
            	return root.rightChild;
            	}

            root.key = sort(root.rightChild);//finds key value at root
            root.rightChild = exNode(root.rightChild, root.key);//knocks Node off Binary tree
        }

        this.root = root;
        return this.root;//sets root to orig
		
	}
	
	//Helper method(s) :	
		/**You may add additional methods to your class to help with tasks.  For example, searching 
		 * for a node can be done with a helper method. 
		 */
	/**
	 * 
	 * @param root node in a tree
	 * @return returns the number value at that node
	 */
	private int sort(Node root) {
		int sort = root.key;
		while (root.leftChild != null) {
			sort = root.leftChild.key;
			root = root.leftChild;
		}
		return sort;
		
	}
	
	public void printBST() {//prints entire tree
		printEach(this.root);
	}
	
	/**
	 * 
	 * @param root node in a tree
	 */
	public void printEach(Node root) { //prints each node in tree 
		if (!isEmpty(root)) {
			printEach(root.leftChild);
			System.out.println(root.key);
			printEach(root.rightChild);
		}
	}
	

	
}
