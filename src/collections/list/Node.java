package collections.list;

public class Node {

    public int data;
    public Node next;
    public Node prev;

    public Node(int d) {
        data = d;
        next = null;
        prev = null;
    }
    
    // prints content of double linked list
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
