/**
 * Class graph.
 */

class Graph {
    private final int MAX_VERTS = 10;
    private int nVerts;
    private Vertex[] vertices;
    private boolean[][] adjMatrix;

    public Graph() {
        adjMatrix = int[MAX_VERTS][MAX_VERTS];
    }

    public void addVertex(int value) {
        vertics[nVerts++] = new Vertex(value);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
    }

    public static Graph build() {
        Graph graph = new Graph();
        for (i = 0; i < 10; i++) {
            graph.add(i);
        }
        addEdge()
    }
}