package collections.list;
public class LinkedListReversal {
 
    static Node head;
 
    /* Function to reverse the linked list */
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
 