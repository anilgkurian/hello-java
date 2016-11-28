package datastructure.tree;

public class TreeTraversalWithLoop {
	
	
	public static void main(String...strings ) {
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        tree.printPostorder(tree.root);
        System.out.println();
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
	        
	        Node tempL = node.left;
	        while(tempL!=null){
	        	
	        	Node tempR = tempL.right;
	        	while(tempR!=null){
	        		
	        		
	        		tempR = tempR.right;
	        	}
	        	tempL = tempL.left;
	        }
	        printPostorder(node.left);
	 
	        printPostorder(node.right);
	 
	        System.out.print(node.key + " ");
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
