package Algorithms.Graphs;

import Algorithms.Algorithms;
import Algorithms.LinkedLists.DoublyLinkedList;

public class ReverseGraph extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Reverse Graph");
        Graph g;
        int vertices;
        vertices = 8;
        g = new Graph(vertices);
        g.addEdge(0,2);
        g.addEdge(2,1);
        g.addEdge(1,0);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(5,6);
        g.addEdge(6,4);
        g.addEdge(6,7);
        g.addEdge(7,4);
        System.out.println("Graph: ");
        g.printGraph();
        Graph revGraph = this.reverseGraph(g);
        System.out.println("Reversed Graph: ");
        revGraph.printGraph();
    }

    private Graph reverseGraph(Graph g) {
        Graph rGraph = new Graph(g.vertices);
        for (int v = 0; v < g.vertices; v++) {
            DoublyLinkedList<Integer>.Node edge = g.adjacencyList[v].getHeadNode();
            while (edge != null) {
                rGraph.addEdge(edge.data, v);
                edge = edge.nextNode;
            }
        }
        return rGraph;
    }
}
