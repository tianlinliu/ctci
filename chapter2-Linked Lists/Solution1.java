/**
 * Question 2.1:
 * Write code to remove duplicates from an unsorted linked list.
 */
public class Solution1 {
    /**
     * Traverse the list by pointer Node current, then travese the rest of the
     * linked list to delete other duplicated nodes.
     *
     * Time complexity: O(n^2)
     * Space complexity: O(1)
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

    //public static Node removeDuplicates2(Node head) {
    //}


    public static void main(String[] args) {
        Node head = null;
        removeDuplicates(head);
        Node.printList(head);
        head = new Node(1, new Node(2, new Node(1)));
        Node.printList(head);
        removeDuplicates(head);
        Node.printList(head);
    }
}