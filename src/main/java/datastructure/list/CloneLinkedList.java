package datastructure.list;

import java.util.HashMap;

/**
 * Cloning a linked list with next and optional pointer, using a Map. O(n)
 * 
 * @author Anil Kurian
 */
public class CloneLinkedList {

	private void cloneLinkedList(final Node head) {

		final HashMap<Node, Node> map = new HashMap<Node, Node>();

		Node cur = head;

		while (cur != null) {
			final Node newNode = new Node(cur.value);
			map.put(cur, newNode);
			cur = cur.next;
		}

		cur = head;

		while (cur != null) {
			final Node node = map.get(cur);
			node.next = map.get(cur.next);
			node.optional = map.get(cur.optional);
			cur = cur.next;
		}

		final Node clonedHead = map.get(head);
		print(clonedHead);

	}

	private static class Node {

		int value;

		Node next;

		Node optional;

		Node(final int val) {
			value = val;
		}

		@Override
		public String toString() {
			String val = value + "";
			if (next != null) {
				val = val + "," + next.value;
			} else {
				val = val + ",-";
			}
			if (optional != null) {
				val = val + "," + optional.value;
			} else {
				val = val + ",-";
			}
			return val;
		}
	}

	public static void main(final String... args) {

		final Node n1 = new Node(1);
		final Node n2 = new Node(2);
		final Node n3 = new Node(3);
		final Node n4 = new Node(4);
		final Node n5 = new Node(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		n1.optional = n3;
		n2.optional = n1;
		n3.optional = n5;
		n4.optional = n3;
		n5.optional = n2;

		print(n1);

		new CloneLinkedList().cloneLinkedList(n1);

	}

	public static void print(Node node) {
		while (node != null) {
			System.out.print(node + " | ");
			node = node.next;
		}
		System.out.println();
	}
}
