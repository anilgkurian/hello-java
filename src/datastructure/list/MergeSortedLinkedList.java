package datastructure.list;

/**
 * Merge two sorted linked lists into one. O(n)
 *
 * @author Anil Kurian
 *
 */
public class MergeSortedLinkedList {

	private static int loops = 0;

	public static void main(final String[] args) {
		final Node n1 = new Node(5);
		n1.next = new Node(10);
		n1.next.next = new Node(15);
		Node.printList(n1);

		final Node n2 = new Node(2);
		n2.next = new Node(3);
		n2.next.next = new Node(20);
		Node.printList(n2);

		final Node sortedMerge = SortedMerge(n1, n2);
		Node.printList(sortedMerge);

		System.out.println(loops);
	}

	private static Node SortedMerge(final Node n1, final Node n2) {
		loops++;
		Node result = null;

		if (n1 == null) {
			return n2;
		} else if (n2 == null) {
			return n1;
		}

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
