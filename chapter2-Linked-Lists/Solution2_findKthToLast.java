/**
 * Question 2.2:
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */

public class Solution2_findKthToLast {
    /**
     * *****Iterative Solution*****
     * Use 2 pointers: Node current and Node kBehind. kBehind is k nodes behind
     * current. When the current pointer goes through the whole list, return the
     * kBehind pointer.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * * Assume when k = 0, return the last element
     */
    public static Node findKthToLast(Node head, int k) {
        if (head == null || k < 0) return null;

        Node current = head;
        for (int i = 0; i < k; i++) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        Node kBehind = head;
        while (current.next != null) {
            current = current.next;
            kBehind = kBehind.next;
        }
        return kBehind;
    }

    /**
     * *****Recursive solution*****
     * Base case: the length of the linked list = k, return the head node
     * Recursive case: remove the head
     *
     * Time: O(n^2)
     */
    public static Node findKthToLast2(Node head, int k) {
        if (head == null || k < 0) return null;

        if (length(head) == k) return head;
        return findKthToLast(head.next, k);
    }

    public static int length(Node head) {
        if (head == null) {
            return 0;
        }
        int count = 0;
        while (head.next != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node head = Node.creatOneTwoThree();
        Node.printList(findKthToLast(head, 1));
        Node.printList(findKthToLast2(head, 2));
    }
}