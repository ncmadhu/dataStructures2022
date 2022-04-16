package Problems.Graphs;

import Common.Problem;
import Utils.DoublyLinkedList;

import java.util.HashSet;

public class MotherVertex extends Problem {
    @Override
    public void run() {
        System.out.println("Running Mother Vertices In Graph");
        int vertices;
        vertices = 6;
        // Directed Graph
        System.out.println("Directed Graph: ");
        Graph graph = new Graph(vertices);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(5,0);
        System.out.println("Mother Vertex: " + this.findMotherVertex(graph, "recursion"));
    }

    private Integer findMotherVertex(Graph graph, String recursion) {
        int motherVertex = -1;
        for (int i = 0; i < graph.vertices; i++) {
            boolean[] visited =  new boolean[graph.vertices];
            HashSet<Integer> vertices = new HashSet<>();
            this.findMotherVertexRecursion(graph, i, visited, vertices);
            if (vertices.size() == graph.vertices) {
                return i;
            }
        }
        return motherVertex;
    }

    private void findMotherVertexRecursion(Graph graph, int source, boolean[] visited, HashSet<Integer> vertices) {
        vertices.add(source);
        visited[source] = true;
        DoublyLinkedList<Integer>.Node edge =  graph.adjacencyList[source].getHeadNode();
        while (edge != null) {
            int vertex = edge.data;
            if (!visited[vertex]) {
                this.findMotherVertexRecursion(graph, vertex, visited, vertices);
            }
            edge = edge.nextNode;
        }
    }
}
