package datastructure.tree;

public class TreeSum {
	
	void postorder(TreeNode node, int total) {

		if (node == null) {
			return;
		}

		total = total + node.val;
		if (isLeafNode(node))
			System.out.println(total);

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
			System.out.println(total);

		inorder(node.right, total);
	}

	void preorder(TreeNode node, int total) {

		if (node == null) {
			return;
		}

		total = total + node.val;

		if (isLeafNode(node))
			System.out.println(total);

		preorder(node.left, total);

		preorder(node.right, total);
	}
	
	boolean isLeafNode(TreeNode node) {
		return node.right == null && node.left == null;
	}

	public static void main(String... strings) {
		
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.left.left = new TreeNode(6);
		tree.left.right = new TreeNode(5);

		TreeSum ob = new TreeSum();
		System.out.println("POST");
		ob.postorder(tree, 0);
		
		System.out.println("IN");
		ob.inorder(tree,0);
		
		System.out.println("PRE");
		ob.preorder(tree,0);
	}
	
	
}
