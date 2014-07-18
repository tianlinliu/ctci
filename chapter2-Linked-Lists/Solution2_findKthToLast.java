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
    public static Node findKthToLast_recusion(Node head, int k) {
        if (head == null || k < 0) return null;

        /* move the front pointer */
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
     * *****Recursive solution*****???
     * Base case:
     * Recursive case:
     *
     * Time: O(n)
     */
    public static int findKthToLast_iteration(Node head, int k) {
        if (head == null) return 0;

        /* i is the index from end to kth to last */
        int i = findKthToLast_iteration(head.next, k) + 1;
        if (i == k) {
            System.out.println(head.value);
        }
        return i;
    }

    /**
     * First calculate the length of the list, then substract k to get the position.
     */
    public static Node findKthToLast_length(Node head, int k) {
        if (head == null || k < 0) return null;

        int steps = length(head) - k;
        if (steps < 0) return null;

        while (steps > 0) {
            head = head.next;
            steps--;
        }
        return head;
    }

    private static int length(Node head) {
        int count = 0;
        while (head.next != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node head = Node.build(new int[] {1, 2, 3, 4, 5});
        Node.printList(findKthToLast_recusion(head, 1));
        Node.printList(findKthToLast_length(head, 6));
        findKthToLast_iteration(head, 1);
    }
}