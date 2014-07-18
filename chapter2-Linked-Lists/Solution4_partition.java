/**
 * Question 2.4:
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal to x.
 */

public class Solution4_partition {
    /**
     * Creat 2 linked lists, one is all the nodes less than x, one is greater or
     * equal to it. Iterate the original list, add nodes to the end of their
     * lists then merge together.
     *
     * Time: O(n)
     * Space: O(1)
     */
    public static Node partition(Node head, int x) {
        if (head == null) return null;

        Node smallHead = null;
        Node smallTail = null;
        Node largeHead = null;
        Node largeTail = null;

        while (head != null) {
            if (head.value < x) {
                if (smallHead == null) {
                    smallHead = head;
                    smallTail = head;
                } else {
                    smallTail.next = head;
                    smallTail = smallTail.next;
                }
            } else { //head.value >= x;
                if (largeHead == null) {
                    largeHead = head;
                    largeTail = head;
                } else {
                    largeTail.next = head;
                    largeTail = largeTail.next;
                }
            }
            head = head.next;
        }

        if (smallHead == null) {
            return largeHead;
        } else {
            smallTail.next = largeHead;
            return smallHead;
        }
    }

    public static Node partition_dummy(Node head, int x) {
        Node dummyBefore = new Node(-1);
        Node tailBefore = dummyBefore;
        Node dummyAfter = new Node(-1);
        Node tailAfter = dummyAfter;

        while (head != null) {
            if (head.value < x) {
                tailBefore.next = head;
                tailBefore = tailBefore.next;
            } else {
                tailAfter.next = head;
                tailAfter = tailAfter.next;
            }
            head = head.next;
        }

        tailBefore.next = dummyAfter.next;
        return dummyBefore.next;
    }

    public static void main(String[] args) {
        Node head = new Node(9, new Node(5, new Node(2, new Node(7))));
        Node.printList(head);
        head = partition(head, 5);
        Node.printList(head);
        System.out.println("After partition function.");
        Node.printList(head);
        Node.printList(partition_dummy(head, 7));
    }

}