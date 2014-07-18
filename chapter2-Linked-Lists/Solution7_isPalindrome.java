/**
 * Question 2.7:
 * Implement a function to check if a linked list is a palindrome.
 */
public class Solution7_isPalindrome {
    /**
     * Reverse the list, then compare it with the original.
     */
    public static boolean isPalindrome(Node head) {
        if (head == null) return true;

        Node reverseHead = reverse(head);
        while (head != null) {
            if (head.value != reverseHead.value) {
                return false;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    private static Node reverse(Node head) {
        Node result = null;
        while (head != null) {
            Node next = head.next;
            head.next = result;
            result = head;
            head = next;
        }
        return result;
    }

    public static void main(String[] args) {
        Node test = Node.build(new int[] {1, 2, 3, 2, 1});
        Node.printList(test);
        System.out.println(isPalindrome(test));
    }
}