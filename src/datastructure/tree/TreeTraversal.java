package datastructure.tree;

public class TreeTraversal {

	public static void main(String... strings) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		TreeTraversal ob = new TreeTraversal();
		ob.printPostorder(root);
		System.out.println();
		ob.printInorder(root);
		System.out.println();
		ob.printPreorder(root);
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
