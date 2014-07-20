/**
 * Question 4.4:
 * Given a binary tree, design an algorithm which creates a linked list of all the
 * nodes at each depth.
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution4_createLevelLinkedLists {
    /**
     * Use BFS.
     *
     */
    public static ArrayList<LinkedList<Node>> createLevelLinkedLists_BFS(Node root) {
        if (root == null) return null;

        ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
        LinkedList<Node> current = new LinkedList<Node>();

        current.add(root);
        while (current.size() > 0) {
            LinkedList<Node> parents = current;
            current = new LinkedList<Node>();
            result.add(parents);

            for (Node n : parents) {
                if (n.left != null) {
                    current.add(n.left);
                }
                if (n.right != null) {
                    current.add(n.right);
                }
            }
        }
        return result;
    }

    /**
     * Preorder traverse.
     */
    public static ArrayList<LinkedList<Node>> createLevelLinkedLists_DFS(Node root) {
        ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
        createLevelLinkedLists(root, result, 0);
        return result;
    }

    private static void createLevelLinkedLists(Node root, ArrayList<LinkedList<Node>> result, int level) {
        if (root == null) return;  // base case

        /* examine if current level exist */
        LinkedList<Node> list = null;
        if (result.size() == level) {
            list = new LinkedList<Node>();
            result.add(list);
        } else {
            list = result.get(level);
        }
        list.add(root);

        createLevelLinkedLists(root.left, result, level + 1);
        createLevelLinkedLists(root.right, result, level + 1);
    }
 }