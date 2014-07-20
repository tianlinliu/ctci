/**
 * Question 4.3:
 * Given a sorted array with unique integer elements, write an algorithm to creat
 * a binary search tree with minimal height.
 */
public class Solution3_createBFS {
    /**
     * Base case: if the end index exceeds the start index.
     * Recursive case:
     * 1. create the parent node
     * 2. create the left subtree
     * 3. create the right subtree
     */
    public static Node createBFS(int[] arr) {
        if (arr == null) return null;
        return createBFS(arr, 0, arr.length - 1);

    }

    private static Node createBFS(int[] arr, int start, int end) {
        if (end < start) return null;

        int mid = (end - start) / 2 + start;
        Node parent = new Node(arr[mid]);
        parent.left = createBFS(arr, start, mid - 1);
        parent.right = createBFS(arr, mid + 1, end);

        return parent;
    }

    public static void main(String[] args) {
        Node.printTree(createBFS(new int[] {1, 2, 3, 4, 5}));
    }
}