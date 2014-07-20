/**
 * Question 4.5:
 * Implement a function to check if a binary tree is a binary search tree.
 */

 public class Solution5_isBST {
    // ?
    public static boolean isBST_preorder(Node root) {
        if (root == null) return true;

        if (!isBST_preorder(root.left)) return false;
        if (!isBST_preorder(root.right)) return false;

        if (root.left != null) {
            return root.value >= root.left.value;
        }
        if (root.right != null) {
            return root.value < root.right.value;
        }
        return true;
    }

    /**
     * All values on the left sub tree must be less than root, and all values
     * on the right sub tree must be greater than root.
     */
    public static boolean isBST_minmax(Node root) {
        return isBST_minmax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST_minmax(Node root, int min, int max) {
        if (root == null) return true;

        int value = root.value;
        if (value < min || value >= max) return false;

        return isBST_minmax(root.left, min, value) && isBST_minmax(root.right, value, max);
    }
 }