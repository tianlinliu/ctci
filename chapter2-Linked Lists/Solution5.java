/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1's digit
 * is at the head of the list. Write a function that adds the two numbers and
 * return the sum as a linked list.
 */

public class Solution5 {
    /**
     * Iterate two linked lists simultaneously, add the second list node's value
     * to the first one's. If the sum is greater than 9, add 1 to next node's
     * value.
     *
     * Time: O(n)
     * Space: O(1)
     */
    public static Node sum(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }


    }
}