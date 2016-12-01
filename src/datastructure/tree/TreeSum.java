package datastructure.tree;

public class TreeSum {

	void postorder(TreeNode node, int total) {

		if (node == null) {
			return;
		}

		total = total + node.val;
		if (isLeafNode(node))
			System.out.print(total+",");

		postorder(node.left, total);

		postorder(node.right, total);

	}

	void inorder(TreeNode node, int total) {

		if (node == null) {
			return;
		}

		total = total + node.val;

		inorder(node.left, total);

		if (isLeafNode(node))
			System.out.print(total+",");

		inorder(node.right, total);
	}

	void preorder(TreeNode node, int total) {

		if (node == null) {
			return;
		}

		total = total + node.val;

		if (isLeafNode(node))
			System.out.print(total+",");

		preorder(node.left, total);

		preorder(node.right, total);
	}

	boolean isLeafNode(TreeNode node) {
		return node.right == null && node.left == null;
	}

	public static void main(String... strings) {

		TreeNode tree = TreeSamples.getBinaryTree();

		TreeSum ob = new TreeSum();
		System.out.println(" POST");
		ob.postorder(tree, 0);

		System.out.println("\n IN");
		ob.inorder(tree, 0);

		System.out.println("\n PRE");
		ob.preorder(tree, 0);
	}

}
