package collections.tree;

public class TreeTraversal {
	
	
	public static void main(String...strings ) {
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        tree.printPostorder(tree.root);
        System.out.println();
        tree.printInorder(tree.root);
        System.out.println();
        tree.printPreorder(tree.root);
	}
	
	static class BinaryTree
	{
	    Node root;
	 
	    BinaryTree()
	    {
	        root = null;
	    }
	    
	    void printPostorder(Node node)
	    {
	        if (node == null)
	            return;
	 
	        printPostorder(node.left);
	 
	        printPostorder(node.right);
	 
	        System.out.print(node.key + " ");
	    }
	 
	    void printInorder(Node node)
	    {
	        if (node == null)
	            return;
	 
	        printInorder(node.left);
	 
	        System.out.print(node.key + " ");
	 
	        printInorder(node.right);
	    }
	 
	    void printPreorder(Node node)
	    {
	        if (node == null)
	            return;
	 
	        /* first print data of node */
	        System.out.print(node.key + " ");
	 
	        /* then recur on left sutree */
	        printPreorder(node.left);
	 
	        /* now recur on right subtree */
	        printPreorder(node.right);
	    }
	}

	private static class Node{
		
		private int key;
		Node left,right;
		
		public Node(int value) {
			this.key = value;
		}
		
		
	}
}
