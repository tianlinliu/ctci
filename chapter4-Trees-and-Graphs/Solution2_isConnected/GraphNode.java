/**
 * Class Node for graph.
 */

 public class GraphNode {
    int value;
    GraphNode[] parents;
    GraphNode[] children;

    public GraphNode(int value, GraphNode[] parents, GraphNode[] children) {
        this.value = value;
        this.parents = parents;
        this.children = children;
    }

    public GraphNode(int value) {
        this(value, null, null);
    }

 }