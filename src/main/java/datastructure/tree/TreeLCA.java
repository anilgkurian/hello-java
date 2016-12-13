package datastructure.tree;

/**
 * Find the least common ancestor of two nodes in a tree
 *
 * @author Anil Kurian
 *
 */
public class TreeLCA {

	TreeNode getLCA(TreeNode node, final int n1, final int n2) {

		while (node != null) {
			if ((node.val > n1) && (node.val > n2)) {
				node = node.left;
			} else if ((node.val < n1) && (node.val < n2)) {
				node = node.right;
			} else {
				break;
			}
		}
		System.out.println("LCA of " + n1 + " & " + n2 + " = " + node.val);
		return node;
	}

	TreeNode getLCARecursive(final TreeNode node, final int n1, final int n2) {

		if (node == null) {
			return null;
		}
		if ((node.val > n1) && (node.val > n2)) {
			return getLCARecursive(node.left, n1, n2);
		}

		if ((node.val < n1) && (node.val < n2)) {
			return getLCARecursive(node.right, n1, n2);
		}

		System.out.println("LCA of " + n1 + " & " + n2 + " = " + node.val);
		return node;
	}

	TreeNode getLCA(TreeNode node, final int n1, final int n2, final int n3) {

		while (node != null) {
			if ((node.val > n1) && (node.val > n2) && (node.val > n3)) {
				node = node.left;
			} else if ((node.val < n1) && (node.val < n2) && (node.val < n3)) {
				node = node.right;
			} else {
				break;
			}
		}
		System.out.println("LCA of " + n1 + ", " + n2 + " & " + n3 + " = " + node.val);
		return node;
	}

	public static void main(final String... args) {

		final TreeNode binaryTree = TreeSamples.getBinaryTree();

		final TreeLCA ob = new TreeLCA();
		ob.getLCA(binaryTree, 10, 4);
		ob.getLCARecursive(binaryTree, 10, 4);
		ob.getLCA(binaryTree, 10, 4, 22);
	}
}
