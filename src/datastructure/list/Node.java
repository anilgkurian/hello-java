package datastructure.list;

public class Node {

	public int data;
	public Node next;
	public Node prev;

	public Node(final int d) {
		data = d;
		next = null;
		prev = null;
	}

	@Override
	public String toString() {
		String val = data + "";
		if (next != null) {
			val = val + "(" + next.data;
		} else {
			val = val + "(-";
		}
		if (prev != null) {
			val = val + "," + prev.data + ")";
		} else {
			val = val + ",-)";
		}
		return val;
	}

	// prints content of double linked list
	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node + " | ");
			node = node.next;
		}
		System.out.println("");
	}
}
