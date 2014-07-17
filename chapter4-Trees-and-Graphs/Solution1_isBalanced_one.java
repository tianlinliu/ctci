/**
 * Implement a function to check if a binary tree is balanced.
 * Definition of a balanced tree: the heights of the two subtrees of any node
 * never differ by more than one.
 */

 public class Solution1_isBalanced_one {
    public static boolean isBalanced(Node root) {
        if (root == null)  return true;
        int diff = Math.abs(height(root.left) - height(root.right));
        if (diff <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }

    private static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }



    /****************** Test part *********************************************/
    /*     4
     *  2     6
     * 1 3   5 7
     */
    public static Node build() {
        return new Node(4, new Node(2, new Node(1), new Node(3)),
            new Node(6, new Node(5), new Node(7)));
    }

    public static void main(String[] args) {
        Node root = build();
        System.out.println(isBalanced(root));
    }
 }