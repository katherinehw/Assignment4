package herman;

/**
 * 
 * @author KatherineHerman-Williams
 *
 */
public class Main {
	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree();//creates new bst
		
		//insert nodes
		tree.insertNode(5);
		tree.insertNode(14);
		tree.insertNode(1);
		tree.insertNode(7);
		tree.insertNode(9);
		tree.insertNode(2);
		
		//print tree
		tree.printBST();
		
		
		System.out.println("next");//separates between 2 trees that will be printed
		
		//delete nodes
		tree.deleteNode(2);
		tree.deleteNode(7);
		
		//print new tree
		tree.printBST();
	}

}
