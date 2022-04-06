package Algorithms.Graphs;

import Algorithms.Algorithms;

public class TestGraphImplementation extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Test Graph Implementation");
        int vertices;
        vertices = 10;
        // Directed Graph
        System.out.println("Directed Graph: ");
        Graph graph = new Graph(vertices);
        for (int i = 0; i < vertices; i++) {
            int j = i;
            while (j  < vertices) {
                j = j + 2;
                graph.addEdge(i, j);
            }
        }
        graph.printGraph();
        vertices = 10;
        // UnDirected Graph
        System.out.println("UnDirected Graph: ");
        UnDirectedGraph unDirectedGraph = new UnDirectedGraph(vertices);
        for (int i = 0; i < vertices; i++) {
            int j = i;
            while (j  < vertices) {
                j = j + 2;
                unDirectedGraph.addEdge(i, j);
            }
        }
        unDirectedGraph.printGraph();
        System.out.println("Number Of Edges: " + unDirectedGraph.numEdges());
    }
}
