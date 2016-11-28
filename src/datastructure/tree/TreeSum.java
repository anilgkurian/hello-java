package datastructure.tree;

public class TreeSum {

	public static void main(String... strings) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.left.left = new Node(6);
		tree.root.left.right = new Node(5);

		System.out.println("POST");
		tree.printPostorder(tree.root, 0);
		
		System.out.println("IN");
		tree.printInorder(tree.root,0);
		
		System.out.println("PRE");
		tree.printPreorder(tree.root,0);
	}

	static class BinaryTree {
		Node root;

		BinaryTree() {
			root = null;
		}

		void printPostorder(Node node, int total) {
			
			if (node == null) {
				return;
			}

			total = total + node.key;
			if(isLeafNode(node))
				System.out.println(total);
			
			printPostorder(node.left,total);

			printPostorder(node.right,total);

		}

		boolean isLeafNode(Node node) {
			return node.right==null && node.left==null;
		}
		void printInorder(Node node, int total) {
			
			if (node == null) {
				return;
			}

			total = total + node.key;

			printInorder(node.left,total);

			if(isLeafNode(node))
				System.out.println(total);
			
			printInorder(node.right,total);
		}

		void printPreorder(Node node, int total) {
			
			if (node == null) {
				return;
			}

			total = total + node.key;
			
			if(isLeafNode(node))
				System.out.println(total);
			
			printPreorder(node.left, total);
			
			printPreorder(node.right,total);
		}
	}

	private static class Node {

		private int key;
		Node left, right;

		public Node(int value) {
			this.key = value;
		}

	}
}
