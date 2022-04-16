package Problems.Graphs;

import Common.Problem;
import Utils.DoublyLinkedList;
import Problems.Queues.Queue;
import Problems.Stacks.Stack;

public class DirectedGraphIsTree extends Problem {
    @Override
    public void run() {
        System.out.println("Running Check Directed Graph is Tree");
        Graph g;
        int vertices;
        vertices = 5;
        g = new Graph(vertices);
        g.addEdge(1,0);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        System.out.println("Graph: ");
        g.printGraph();
        System.out.println("Directed Graph Is Tree: " + this.isTree(g));
        System.out.println("Directed Graph Is Tree (BFS): " + this.isTree(g));
        g.addEdge(2,4);
        System.out.println("Graph: ");
        g.printGraph();
        System.out.println("Directed Graph Is Tree: " + this.isTree(g));
        System.out.println("Directed Graph Is Tree (BFS): " + this.isTree(g));
    }

    private boolean isTree(Graph g) {
        for (int i = 0; i< g.vertices; i++) {
            boolean[] visited = new boolean[g.vertices];
            if (!this.dfs(g, i, visited)) {
                return false;
            }
            boolean motherVertex = true;
            for (int j = 0; j < g.vertices; j++) {
                if (!visited[j]) {
                    motherVertex = false;
                    break;
                }
            }
            if (motherVertex) {
                return true;
            }
        }
        return false;
    }
    public boolean isTreeBFS(Graph g) {
        boolean[] visited = new boolean[g.vertices];
        int root = 0; // Mother vertex
        visited[root] = true; // Mark it visited
        int visitedVertices = 1; // Root is already visited
        Queue<Integer> vertices = new Queue<>(g.vertices);
        vertices.enqueue(root);
        while (!vertices.isEmpty()) {
            int v = vertices.dequeue();
            DoublyLinkedList<Integer>.Node edge = g.adjacencyList[v].getHeadNode();
            while (edge != null) {
                int vertex = edge.data;
                if (!visited[v]) {
                    visited[v] = true;
                    vertices.enqueue(vertex);
                    visitedVertices++;
                } else {
                    return false; // Double parent
                }
                edge = edge.nextNode;
            }
        }

        // All vertices are visited . Hence connected graph
        if (visitedVertices == g.vertices) {
            return true;
        }

        // Not all vertices are visited. Hence not a tree
        return false;
    }

    private boolean dfs(Graph g, int i, boolean[] visited) {
        visited[i] = true;
        Stack<Integer> vertices = new Stack<>(g.vertices);
        vertices.push(i);
        while (!vertices.isEmpty()) {
            int vertex = vertices.pop();
            DoublyLinkedList<Integer>.Node edge = g.adjacencyList[vertex].getHeadNode();
            while (edge != null) {
                int v = edge.data;
                if (visited[v]) return false; // Already visited means , two parents , so it is not a tree.
                visited[v] = true;
                vertices.push(v);
                edge = edge.nextNode;
            }
        }
        return true;
    }
}
