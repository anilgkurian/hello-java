package datastructure.tree;

public class FindClosestInTree {

	public TreeNode getCloset(TreeNode root, int value)
	{
	    TreeNode current = root;
	    TreeNode minNode = null;
	    int minValue = Integer.MAX_VALUE;

	    while (current != null)
	    {
	        int diff = Math.abs(current.val - value);
	        if (diff < minValue)
	        {
	            minValue = diff;
	            minNode = current;
	            if (diff == 0)
	                break;
	        }

	        current = (value < current.val) ? current.left : current.right;
	    }

	    return minNode;
	}
	
	public static void main(String... args){
		TreeNode binaryTree = TreeSamples.getBinaryTree();
		FindClosestInTree ob = new FindClosestInTree();
		TreeNode closest = ob.getCloset(binaryTree, 4);
		System.out.println(closest.val);
	}
}
