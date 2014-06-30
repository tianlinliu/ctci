/**
 * Question 2.3:
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 */

 public class Solution3 {

    /**
     * Copy the value and reference of next node to current one, then delete current
     */
    public static void delete(Node node) {
        if (node == null) return;
        node.value = node.next.value;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Node head = Node.creatOneTwoThree();
        Node.printList(head);
        delete(head.next);
        Node.printList(head);
    }

 }