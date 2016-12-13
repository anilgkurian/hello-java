package datastructure.tree;

/**
 * Sum of elements for all passes from root to leaf
 *
 * @author Anil Kurian
 *
 */
public class TreeSum {

	void getSum(final TreeNode node, int total) {

		if (node == null) {
			return;
		}

		total = total + node.val;

		if (isLeafNode(node)) {
			System.out.print(total + ",");
		}

		getSum(node.left, total);

		getSum(node.right, total);

	}

	boolean isLeafNode(final TreeNode node) {
		return (node.right == null) && (node.left == null);
	}

	public static void main(final String... strings) {

		final TreeNode tree = TreeSamples.getBinaryTree();

		final TreeSum ob = new TreeSum();
		ob.getSum(tree, 0);

	}

}
