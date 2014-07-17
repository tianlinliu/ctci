public class Solution1_isBalanced_better {
    public static boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    public static int checkHeight(Node root) {
        if (root == null) return 0;

        /* if subtree is unbalanced, return -1 */
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        /* check current node */
        int diff = Math.abs(leftHeight - rightHeight);
        if (diff > 1) {
            return -1;
        } else {
            return  1 + Math.max(checkHeight(root.left), checkHeight(root.right));
        }
    }


    /****************** Test part *********************************************/
    /*     4
     *  2     6
     * 1 3   5 7
     */
    public static Node build() {
        return new Node(4, new Node(2, new Node(1), new Node(3)),
            new Node(6, null, null));
    }

    public static void main(String[] args) {
        Node root = build();
        System.out.println(isBalanced(root));
    }

}