package Algorithms.Graphs;

import Algorithms.Algorithms;
import Algorithms.LinkedLists.DoublyLinkedList;
import Algorithms.Queues.Queue;

public class ShortestPath extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Shortest Path");
        Graph g;
        int vertices, src, dst;
        // Directed Graph
        vertices = 6;
        g = new Graph(vertices);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(5,4);
        System.out.println("Directed Graph: ");
        g.printGraph();
        src = 0;
        dst = 4;
        System.out.println("Minimum Path From: " + src + " to " + dst + " is " + this.findMin(g, src, dst));
        System.out.println("Minimum Path From (BFS): " + src + " to " + dst + " is " + this.findMinimumPathBfs(g,
                src, dst));
        // Directed Graph
        vertices = 7;
        g = new Graph(vertices);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(4,6);
        g.addEdge(5,6);
        System.out.println("Graph: ");
        g.printGraph();
        src = 0;
        dst = 6;
        System.out.println("Minimum Path From: " + src + " to " + dst + " is " + this.findMin(g, src, dst));
        System.out.println("Minimum Path From (BFS): " + src + " to " + dst + " is " + this.findMinimumPathBfs(g,
                src, dst));
    }

    private int findMin(Graph g, int src, int dst) {
        boolean[] visited =  new boolean[g.vertices];
        int minPath = Integer.MAX_VALUE;
        int curPath = -1;
        return this.findMinDfs(g, src, dst, minPath, curPath, visited);
    }

    private int findMinDfs(Graph g, int src, int dst, int minPath, int curPath, boolean[] visited) {
        visited[src] = true;
        curPath += 1;
        DoublyLinkedList<Integer>.Node edge = g.adjacencyList[src].getHeadNode();
        while (edge != null) {
            int vertex = edge.data;
            if (vertex == dst) {
                curPath += 1;
                minPath = Math.min(minPath, curPath);
                return minPath;
            }
            if (!visited[vertex]) {
                minPath = this.findMinDfs(g, vertex, dst, minPath, curPath, visited);
            }
            edge = edge.nextNode;
        }
        curPath -= 1;
        return minPath;
    }

    public int findMinimumPathBfs(Graph g, int src, int dst) {
        // Source same as Destination
        if (src == dst) return 0;

        // Visited array to keep track of visited vertices
        boolean[] visited = new boolean[g.vertices];

        // Distance array to keep track of distance from root
        int[] distance = new int[g.vertices];

        // Queue for Breadth First Search --- Idea here is since we are going level by level the shortest path always
        // present itself first since its some x level above the other viable paths
        Queue<Integer> vertices = new Queue<>(g.vertices);
        vertices.enqueue(src);
        visited[src] = true;

        while (!vertices.isEmpty()) {
            int v = vertices.dequeue();
            DoublyLinkedList<Integer>.Node edge = g.adjacencyList[v].getHeadNode();
            while (edge != null) {
                int data = edge.data;
                if (!visited[data]) {
                    vertices.enqueue(data);
                    visited[data] = true;
                    distance[data] = distance[v] + 1;
                }
                if (data == dst) {
                    return distance[data];
                }
                edge = edge.nextNode;
            }
        }
        // No path
        return -1;
    }
}
