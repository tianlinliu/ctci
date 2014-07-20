/* Binary tree node */
class Node {
    Node left;
    Node right;
    int value;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(int value) {
        this(value, null, null);
    }

    public void printValue() {
        System.out.print(value + " ");
    }

    /* inorder */
    public static void printTree(Node root) {
        if (root == null) return;
        printTree(root.left);
        root.printValue();
        printTree(root.right);
    }
}