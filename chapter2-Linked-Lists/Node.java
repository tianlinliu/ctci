
public class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int value) {
        this(value, null);
    }

    public static Node creatOneTwoThree() {
        return new Node(1, new Node(2, new Node(3)));
    }

    public static Node build(int[] nums) {
        Node dummyHead = new Node(-1);
        Node current = dummyHead;
        for (int n : nums) {
            current.next = new Node(n);
            current = current.next;
        }
        return dummyHead.next;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("Empty List.");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}
