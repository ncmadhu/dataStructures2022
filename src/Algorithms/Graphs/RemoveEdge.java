package Algorithms.Graphs;

import Algorithms.Algorithms;
import Algorithms.LinkedLists.DoublyLinkedList;

public class RemoveEdge extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Remove Edge");
        Graph g;
        int vertices, src, dst;
        // Directed Graph
        vertices = 5;
        g = new Graph(vertices);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        System.out.println("Directed Graph: ");
        g.printGraph();
        src = 1;
        dst = 2;
        System.out.println("Remove Edge : " + src + " to " + dst);
        this.removeEdge(g, src, dst);
        g.printGraph();
    }

    private void removeEdge(Graph g, int src, int dst) {
        DoublyLinkedList<Integer> adjList = g.adjacencyList[src];
        adjList.deleteByValue(dst);
    }
}
