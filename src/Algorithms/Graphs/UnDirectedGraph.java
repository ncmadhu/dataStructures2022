package Algorithms.Graphs;

import Algorithms.LinkedLists.DoublyLinkedList;

// Edges are Bidirectional
public class UnDirectedGraph extends Graph{
    public UnDirectedGraph(int vertices) {
        super(vertices);
    }

    @Override
    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            this.adjacencyList[source].insertAtTail(destination);
            this.adjacencyList[destination].insertAtTail(source);
        }
    }

    // Easiest solution is to add all the edges and divide by 2 :)
    public int numEdges() {
        int edges = 0;
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            visited[i] = true;
            DoublyLinkedList<Integer>.Node edge = this.adjacencyList[i].getHeadNode();
            while (edge != null) {
                if (!visited[edge.data]) edges++;
                edge = edge.nextNode;
            }
        }
        return edges;
    }
}
