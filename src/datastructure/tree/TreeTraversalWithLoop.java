package datastructure.tree;

public class TreeTraversalWithLoop {

	public static void main(String... strings) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		TreeTraversalWithLoop ob = new TreeTraversalWithLoop();
		ob.printPostorder(root);
		System.out.println();
	}

	void printPostorder(TreeNode node) {
		if (node == null)
			return;

		TreeNode tempL = node.left;
		while (tempL != null) {

			TreeNode tempR = tempL.right;
			while (tempR != null) {

				tempR = tempR.right;
			}
			tempL = tempL.left;
		}
		printPostorder(node.left);

		printPostorder(node.right);

		System.out.print(node.val + " ");
	}

}
