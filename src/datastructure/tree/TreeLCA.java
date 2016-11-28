package datastructure.tree;

public class TreeLCA {

	TreeNode getLCA(TreeNode root, int n1, int n2) {
		
		while (root != null) {
			if (root.val > n1 && root.val > n2)
				root = root.left;

			else if (root.val < n1 && root.val < n2)
				root = root.right;

			else
				break;
		}
		System.out.println("LCA of "+n1+" and "+n2+" = "+root.val);
		return root;
	}

	public static void main(String... args) {

		TreeNode binaryTree = TreeSamples.getBinaryTree();

		TreeLCA ob = new TreeLCA();
		ob.getLCA(binaryTree, 10, 14);
	}
}
