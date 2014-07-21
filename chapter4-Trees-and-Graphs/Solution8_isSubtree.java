/**
 * Question 4.8:
 * You have 2 very large binary trees: T1, with millions of nodes, and T2, with
 * hundreds of node. Create an algorithm to decide if T2 is a subtree of T1.
 * If you cut off the tree at node n, the 2 trees would be identical.
 */

public class Solution8_isSubtree {
    /**
     * Traverse T1, whenever find a node equals to T2's root, compare two trees
     */
    public static boolean isSubtree(Node root, Node subtree) {
        if (subtree == null) return true;  // empty tree is always subtree
        return isSubtreeHelpler(root, subtree);
    }

    private static boolean isSubtreeHelpler(Node root, Node subtree) {
        if (root == null) return false;

        if (root.value == subtree.value) {
            if (equals(root, subtree)) return true;
        }
        return isSubtreeHelpler(root.left, subtree) || isSubtreeHelpler(root.right, subtree);
    }

    private static boolean equals(Node r1, Node r2) {
        if (r1 == null && r2 == null) return true;

        if (r1 == null || r2 == null) return false;
        if (r1.value != r2.value) return false;
        return equals(r1.left, r2.left) && equals(r1.right, r2.right);
    }
}