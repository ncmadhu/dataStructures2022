package Problems.Graphs;

import Utils.DoublyLinkedList;

// Graph implementation using Adjacency List
// Adjacency List ---> Array of Doubly Linked List with size equal to number of vertices
// Each index represent the vertices and Doubly Linked List value at that index contains the connected vertices
public class Graph {
    protected int vertices;
    protected DoublyLinkedList<Integer>[] adjacencyList;

    // Constructor gets number of vertices as input
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new DoublyLinkedList[vertices];

        // Initialize Doubly Linked List at each index
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new DoublyLinkedList<>();
        }
    }

    // Add vertices to the Doubly Linked List
    public void addEdge(int source, int destination) {
        // Checks whether source and destination value fall within the max index value of adjacencyList array
        if (source < vertices && destination < vertices) {
            this.adjacencyList[source].insertAtTail(destination);
        }
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("|" + i + "| ==> ");
            DoublyLinkedList<Integer>.Node temp = adjacencyList[i].getHeadNode();
            while (temp != null) {
                System.out.print("[" + temp.data + "] --> ");
                temp = temp.nextNode;
            }
            System.out.println("NULL");
        }
    }
}
