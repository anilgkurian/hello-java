package datastructure.list;

public class MergeSortedLinkedList {
	static Node head;

	public static void main(String[] args) {
		Node n1 = new Node(5);
		n1.next = new Node(10);
		n1.next.next = new Node(15);

		Node n2 = new Node(2);
		n2.next = new Node(3);
		n2.next.next = new Node(20);

		Node sortedMerge = SortedMerge(n1, n2);

		Node.printList(sortedMerge);
	}

	private static Node SortedMerge(Node n1, Node n2) {
		Node result = null;

		/* Base cases */
		if (n1 == null)
			return n2;
		else if (n2 == null)
			return n1;

		/* Pick either a or b, and recur */
		if (n1.data <= n2.data) {
			result = n1;
			result.next = SortedMerge(n1.next, n2);
		} else {
			result = n2;
			result.next = SortedMerge(n1, n2.next);
		}
		return result;
	}
}
