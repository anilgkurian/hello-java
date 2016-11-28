package datastructure.tree;

public class TreeLCA {

	TreeNode getLCA(TreeNode node, int n1, int n2) {

		while (node != null) {
			if (node.val > n1 && node.val > n2)
				node = node.left;

			else if (node.val < n1 && node.val < n2)
				node = node.right;

			else
				break;
		}
		System.out.println("LCA of " + n1 + " & " + n2 + " = " + node.val);
		return node;
	}

	TreeNode getLCARecursive(TreeNode node, int n1, int n2) {

		if (node == null) {
			return null;
		}
		if (node.val > n1 && node.val > n2)
			return getLCARecursive(node.left, n1, n2);

		if (node.val < n1 && node.val < n2)
			return getLCARecursive(node.right, n1, n2);

		System.out.println("LCA of " + n1 + " & " + n2 + " = " + node.val);
		return node;
	}

	TreeNode getLCA(TreeNode node, int n1, int n2, int n3) {

		while (node != null) {
			if (node.val > n1 && node.val > n2 && node.val > n3)
				node = node.left;

			else if (node.val < n1 && node.val < n2 && node.val < n3)
				node = node.right;

			else
				break;
		}
		System.out.println("LCA of " + n1 + ", " + n2 + " & " + n3 + " = " + node.val);
		return node;
	}

	public static void main(String... args) {

		TreeNode binaryTree = TreeSamples.getBinaryTree();

		TreeLCA ob = new TreeLCA();
		ob.getLCA(binaryTree, 10, 4);
		ob.getLCARecursive(binaryTree, 10, 4);
		ob.getLCA(binaryTree, 10, 4, 22);
	}
}
