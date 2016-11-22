package collections.list;

public class MiddleOfLinkedList {
	static Node head;

	public static void main(String[] args) {
		LinkedListReversal list = new LinkedListReversal();
		list.head = new Node(85);
		list.head.next = new Node(15);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(20);

		System.out.println("Original Linked list is :");
		Node.printList(head);
		head = list.reverse(head);
		System.out.println("");
		System.out.println("Reversed linked list : ");
		Node.printList(head);
	}
}
