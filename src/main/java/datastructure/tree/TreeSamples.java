package datastructure.tree;

public class TreeSamples {
	

	public static TreeNode getBinaryTree() {
		TreeNode tree = new TreeNode(20);
		tree.left = new TreeNode(8);
		tree.right = new TreeNode(22);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(12);
		tree.left.right.left = new TreeNode(10);
		tree.left.right.right = new TreeNode(14);
		TreePrinter.printNode(tree);
		return tree;
	}

	public static TreeNode getSimpleBinaryTree() {
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(3);
		tree.right = new TreeNode(7);
		tree.right.right = new TreeNode(8);
		tree.right.left  = new TreeNode(6);
		tree.left.left = new TreeNode(2);
		tree.left.right = new TreeNode(4);
		TreePrinter.printNode(tree);
		return tree;
	}

}
