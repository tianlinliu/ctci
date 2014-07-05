/**
 * Question 2.1:
 * Write code to remove duplicates from an unsorted linked list.
 */
import java.util.HashSet;

public class Solution1_removeDuplicates {
    /**
     * Traverse the list by pointer Node current, then travese the rest of the
     * linked list to delete other duplicated nodes.
     *
     * Time complexity: O(n^2)
     * Space complexity: O(1), **additional space is not allowed**
     */
    public static Node removeDuplicates(Node head) {
        if (head == null) return null;
        Node current = head;
        while (current.next != null) {
            Node delete = current;
            while (delete.next != null) {
                if (current.value == delete.next.value) {
                    delete.next = delete.next.next;
                } else {
                    delete = delete.next;
                }
            }
            current = current.next;
        }
        return head;
    }

    /**
     * Iterate the linked list, add each value to the HashSet, if the value is
     * duplicated deleted the node, then keep iterating.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public static Node removeDuplicates2(Node head) {
        if (head == null) return null;

        Node current = head;
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(head.value);

        while(current.next != null) {
            if (!set.contains(current.next.value)) {
                set.add(current.next.value);
                current = current.next;
            } else {
                current.next = current.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        removeDuplicates2(head);
        Node.printList(head);
        head = Node.build(new int[] {1, 2, 3, 1, 2});
        Node.printList(head);
        removeDuplicates2(head);
        Node.printList(head);
    }
}