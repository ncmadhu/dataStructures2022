package Algorithms.Graphs;

import Algorithms.Algorithms;
import Algorithms.LinkedLists.DoublyLinkedList;
import Algorithms.Stacks.Stack;

import java.util.HashSet;

public class DetectCycle extends Algorithms {
    static int WHITE = 0, GRAY = 1, BLACK = 2;
    @Override
    public void run() {
        System.out.println("Running Detect Cycle In Graph");
        int vertices;
        vertices = 6;
        // Directed Graph
        System.out.println("Directed Graph: ");
        Graph graph = new Graph(vertices);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        System.out.println("Cycle Exists Recursion: " + this.detectCycle(graph, "recursion"));
        System.out.println("Cycle Exists Colors: " + this.detectCycle(graph, "colors"));
        vertices = 4;
        // Directed Graph
        System.out.println("Directed Graph: ");
        graph = new Graph(vertices);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        System.out.println("Cycle Exists Recursion: " + this.detectCycle(graph, "recursion"));
        System.out.println("Cycle Exists Colors: " + this.detectCycle(graph, "colors"));
        vertices = 5;
        // Directed Graph
        System.out.println("Directed Graph: ");
        graph = new Graph(vertices);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.addEdge(4,2);
        System.out.println("Cycle Exists Recursion: " + this.detectCycle(graph, "recursion"));
        System.out.println("Cycle Exists Colors: " + this.detectCycle(graph, "colors"));
    }

    public boolean detectCycle(Graph g, String method) {

        // Init visited array for use in recursion algorithm
        boolean[] visited = new boolean[g.vertices];
        // Init colors array for use in color algorithm
        int[] colors = new int[g.vertices];
        for (int i = 0; i < g.vertices; i++) {
            colors[i] = WHITE;
        }

        for (int i = 0; i < g.vertices; i++) {
                if (method.equals("recursion")) {
                    if (!visited[i]) {
                        HashSet<Integer> uniqueVertices = new HashSet<>();
                        if (this.detectCycleHelperRecursion(g, i, visited, uniqueVertices)) {
                            return true;
                        }
                    }
                } else {
                    if (colors[i] == WHITE) {
                        if (this.detectCycleHelperColors(g, i, colors)) {
                            return true;
                        }
                    }
                }
            }
        return false;
    }

    // Use depth first search by recursion
    // Add the vertex to HashSet when entering recursion
    // Remove the vertex from HashSet when backtracking from recursion ---- > this is key to avoid reporting false positive
    public boolean detectCycleHelperRecursion(Graph g, int source, boolean[] visited, HashSet<Integer> uniqueVertices) {
        System.out.println("Vertex: " + source);
        uniqueVertices.add(source);
        visited[source] = true;
        DoublyLinkedList<Integer>.Node edge = g.adjacencyList[source].getHeadNode();
        while (edge != null) {
            int vertex = edge.data;
            if (uniqueVertices.contains(vertex)) return true;
            if (!visited[vertex] && this.detectCycleHelperRecursion(g, vertex, visited, uniqueVertices)) return true;
            edge = edge.nextNode;
        }
        // This is important
        uniqueVertices.remove(source);
        return false;
    }

    // Detect Cycle using Colors
    // WHITE = Vertex is unprocessed
    // GRAY = Vertex In Process
    // BLACK = Vertex Processed

    public boolean detectCycleHelperColors(Graph g, int source, int[] colors) {
        // Set the color to GRAY
        System.out.println("Vertex: " + source);
        colors[source] = GRAY;
        DoublyLinkedList<Integer>.Node edge = g.adjacencyList[source].getHeadNode();
        while (edge != null) {
            int vertex = edge.data;
            if (colors[vertex] == GRAY) return true;
            if (colors[vertex] == WHITE && this.detectCycleHelperColors(g, vertex, colors)) return true;
            edge = edge.nextNode;
         }
        colors[source] = BLACK;
        return false;
    }

     // Not able to differentiate vertex taken from another path and reports graph as cyclic
    public boolean detectCycleHelperStackFail(Graph g, int source, boolean[] visited, HashSet<Integer> uniqueVertices) {
        Stack<Integer> vertices = new Stack<>(g.vertices);
        vertices.push(source);
        while (!vertices.isEmpty()) {
            int currentVertex = vertices.pop();
            uniqueVertices.add(currentVertex);
            System.out.println("Current Vertex: " + currentVertex);
            DoublyLinkedList<Integer>.Node edge = g.adjacencyList[currentVertex].getHeadNode();
            while (edge != null) {
                int vertex = edge.data;
                if (uniqueVertices.contains(vertex)) return true;
                if (!visited[vertex]) vertices.push(vertex);
                edge = edge.nextNode;
            }
            visited[currentVertex] = true;
        }
        return false;
    }
}
