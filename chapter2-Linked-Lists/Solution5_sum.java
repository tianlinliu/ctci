/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1's digit
 * is at the head of the list. Write a function that adds the two numbers and
 * return the sum as a linked list.
 * FOLLOW UP:
 * Suppose the digits are stored in forward order. Repeat above problem.
 */

public class Solution5_sum {
    /**
     * Recusion.
     * Base case: the next nodes of both lists are the end and carry = 0
     * Recusive case:  add up the nodes' value and carry, set the next node's
     *   value equals sum of next nodes.
     *
     * Time: O(n)
     */
    public static Node sum(Node head1, Node head2, int carry) {
        /* base case */
        if (head1 == null && head2 == null && carry == 0) {
            return null;
        }

        int result = carry;
        if (head1 != null) {
            result += head1.value;
        }
        if (head2 != null) {
            result += head2.value;
        }

        /* recusive case */
        Node head = new Node(result % 10);
        if (head1 != null || head2 != null) {
            head.next = sum(head1 == null ? head1 : head1.next, head2 == null ?
                head2 : head2.next, result >= 10 ? 1 : 0);
        }
        return head;
    }

    /**
     *
     */

    public static void main(String[] args) {
        Node head1 = Node.build(new int[] {2, 2, 2});
        Node head2 = Node.build(new int[] {8, 8, 8});
        Node.printList(head1);
        Node.printList(head2);
        Node.printList(sum(head1, head2, 0));
    }
}