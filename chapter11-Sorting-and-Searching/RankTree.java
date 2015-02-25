public class RankTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int rank;

        public TreeNode(int num) {
            this.val = num;
            this.rank = 1;
        }
    }

    private TreeNode root;

    public void track(int num) {
        if (root == null) {
            root = new TreeNode(num);
            return;
        }
        track(num, root);
    }

    private void track(int num, TreeNode node) {
        if (node.val >= num) {
            node.rank++;
            if (node.val == num) {
                return;
            }

            if (node.left == null) {
                node.left = new TreeNode(num);
            } else {
                track(num, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(num);
            } else {
                track(num, node.right);
            }
        }
    }

    public int getRankOfNumber(int num) {
        if (root == null) {
            return -1;
        }
        return getRankOfNumber(num, root);
    }

    private int getRankOfNumber(int num, TreeNode node) {
        if (node.val == num) {
            return node.rank;
        } else if (node.val > num) {
            if (node.left == null) {
                return -1;
            } else {
                return getRankOfNumber(num, node.left);
            }
        } else {
            if (node.right == null) {
                return -1;
            } else {
                return node.rank + getRankOfNumber(num, node.right);
            }
        }
    }
}