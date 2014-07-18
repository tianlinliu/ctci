/**
 * Question 2.6:
 * Given a circular linked list, implement an algorithm which returns the node
 * at the beginning of the loop.
 */
public class Solution6_findBeginning {
    /**
     * 1. Creat 2 pointers, fast moves at a rate of 2 steps and slow moves at rate of 1 step.
     * 2. When they collide, move slow to the head of list.
     * 3. Move slow and fast at rate of 1 step. Return the new collision point.
     */
    public static Node findBeginning(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }

        /* error check: if there is no loop */
        if (fast == null || fast.next == null) {
            return null;
        }

        /* move slow to the head, then return their collision point */
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}