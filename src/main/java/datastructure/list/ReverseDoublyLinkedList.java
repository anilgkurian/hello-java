package datastructure.list;

/**
 * Reversing doubly linked list with O(n)
 *
 * @author Anil Kurian
 *
 */
public class ReverseDoublyLinkedList {

	Node reverse(final Node head) {
		Node temp = null;
		Node current = head;

		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}

		return temp.prev;
	}

	public static void main(final String... args) {
		final Node n1 = new Node(1);
		final Node n2 = new Node(2);
		final Node n3 = new Node(3);
		final Node n4 = new Node(4);

		final Node head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		n2.prev = n1;
		n3.prev = n2;
		n4.prev = n3;

		Node.printList(head);
		final Node reversedHead = new ReverseDoublyLinkedList().reverse(head);
		Node.printList(reversedHead);
	}
}
