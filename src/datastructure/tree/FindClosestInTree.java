package datastructure.tree;

/**
 * Find the closest element in a b tree.
 *
 * TODO: improve
 *
 * @author Anil Kurian
 *
 */
public class FindClosestInTree {

	public TreeNode getCloset(final TreeNode root, final int value) {
		TreeNode current = root;
		TreeNode minNode = null;
		int minValue = Integer.MAX_VALUE;

		while (current != null) {
			final int diff = Math.abs(current.val - value);
			if (diff < minValue) {
				minValue = diff;
				minNode = current;
				if (diff == 0) {
					break;
				}
			}

			current = (value < current.val) ? current.left : current.right;
		}

		return minNode;
	}

	public static void main(final String... args) {
		final TreeNode binaryTree = TreeSamples.getBinaryTree();
		final FindClosestInTree ob = new FindClosestInTree();
		final TreeNode closest = ob.getCloset(binaryTree, 10);
		System.out.println(closest.val);
	}
}
