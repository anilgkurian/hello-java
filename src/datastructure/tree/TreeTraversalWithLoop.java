package datastructure.tree;

public class TreeTraversalWithLoop {

	public static void main(String... strings) {
		TreeNode tree = TreeSamples.getBinaryTree();

		TreeTraversalWithLoop ob = new TreeTraversalWithLoop();
		ob.printPostorder(tree);
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
