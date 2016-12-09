package datastructure.tree;

/**
 * Level order traversal of a tree. O(n2)
 *
 * @author Anil Kurian
 *
 */
public class TreeLevelTraversal {

	void printLevelOrder(final TreeNode root) {
		final int h = height(root);
		int i;
		for (i = 1; i <= h; i++) {
			printGivenLevel(root, i);
		}
	}

	int height(final TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			final int lheight = height(node.left);
			final int rheight = height(node.right);

			// use the larger one
			if (lheight > rheight) {
				return (lheight + 1);
			} else {
				return (rheight + 1);
			}
		}
	}

	void printGivenLevel(final TreeNode root, final int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.val + " ");
		} else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	public static void main(final String args[]) {
		TreeNode tree = TreeSamples.getBinaryTree();
		final TreeLevelTraversal ob = new TreeLevelTraversal();
		ob.printLevelOrder(tree);

		tree = TreeSamples.getSimpleBinaryTree();
		ob.printLevelOrder(tree);
	}
}