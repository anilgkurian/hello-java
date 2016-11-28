package datastructure.tree;

public class TreeLevelTraversal {

	void printLevelOrder(TreeNode root) {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	int height(TreeNode node) {
		if (node == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(node.left);
			int rheight = height(node.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print nodes at the given level */
	void printGivenLevel(TreeNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.val + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	public static void main(String args[]) {
		TreeNode tree = TreeSamples.getBinaryTree();
		TreeLevelTraversal ob = new TreeLevelTraversal();
		ob.printLevelOrder(tree);
		
		tree = TreeSamples.getSimpleBinaryTree();
		ob.printLevelOrder(tree);
	}
}