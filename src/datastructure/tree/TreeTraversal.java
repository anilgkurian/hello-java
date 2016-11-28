package datastructure.tree;

public class TreeTraversal {

	public static void main(String... strings) {
		
		TreeNode tree = TreeSamples.getBinaryTree();

		TreeTraversal ob = new TreeTraversal();
		ob.printPostorder(tree);
		
		System.out.println();
		ob.printInorder(tree);
		
		System.out.println();
		ob.printPreorder(tree);
	}

	void printPostorder(TreeNode node) {
		if (node == null)
			return;

		printPostorder(node.left);

		printPostorder(node.right);

		System.out.print(node.val + " ");
	}

	void printInorder(TreeNode node) {
		if (node == null)
			return;

		printInorder(node.left);

		System.out.print(node.val + " ");

		printInorder(node.right);
	}

	void printPreorder(TreeNode node) {
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.val + " ");

		/* then recur on left sutree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
	}

}
