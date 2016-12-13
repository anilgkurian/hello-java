package datastructure.list;

/**
 * Reverse singly linked list with O(n)
 *
 * @author Anil Kurian
 *
 */
public class ReverseSinglyLinkedList {

	Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	public static void main(final String[] args) {
		final ReverseSinglyLinkedList list = new ReverseSinglyLinkedList();
		Node head = new Node(85);
		head.next = new Node(15);
		head.next.next = new Node(4);
		head.next.next.next = new Node(20);

		Node.printList(head);

		head = list.reverse(head);
		Node.printList(head);
	}
}
