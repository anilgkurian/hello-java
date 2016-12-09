package datastructure.tree;

/**
 * @author Anil Kurian
 *
 */
public class TreeTraversalWithLoop {

	void printPostorder(final TreeNode node) {
		if (node == null) {
			return;
		}

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

	public static void main(final String... strings) {
		final TreeNode tree = TreeSamples.getBinaryTree();

		final TreeTraversalWithLoop ob = new TreeTraversalWithLoop();
		ob.printPostorder(tree);
		System.out.println();
	}

}
