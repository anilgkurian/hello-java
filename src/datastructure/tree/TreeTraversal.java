package datastructure.tree;

/**
 * @author Anil Kurian
 *
 */
public class TreeTraversal {

	void printPostorder(final TreeNode node) {
		if (node == null) {
			return;
		}

		printPostorder(node.left);

		printPostorder(node.right);

		System.out.print(node.val + " ");
	}

	void printInorder(final TreeNode node) {
		if (node == null) {
			return;
		}

		printInorder(node.left);

		System.out.print(node.val + " ");

		printInorder(node.right);
	}

	void printPreorder(final TreeNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.val + " ");

		printPreorder(node.left);

		printPreorder(node.right);
	}

	public static void main(final String... strings) {

		final TreeNode tree = TreeSamples.getBinaryTree();

		final TreeTraversal ob = new TreeTraversal();
		System.out.print("\nPost \t");
		ob.printPostorder(tree);

		System.out.print("\nIn \t");
		ob.printInorder(tree);

		System.out.print("\nPre \t");
		ob.printPreorder(tree);
	}

}
