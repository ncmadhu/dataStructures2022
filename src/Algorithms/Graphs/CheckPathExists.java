package Algorithms.Graphs;

import Algorithms.Algorithms;
import Algorithms.LinkedLists.DoublyLinkedList;
import Algorithms.Stacks.Stack;

import java.awt.desktop.SystemSleepEvent;
import java.util.HashSet;

public class CheckPathExists extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Check Path Exists");
        Graph g;
        int vertices;
        vertices = 8;
        g = new Graph(vertices);
        g.addEdge(0,1);
        g.addEdge(0,5);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,5);
        g.addEdge(4,2);
        g.addEdge(4,5);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(5,3);
        g.addEdge(6,7);
        System.out.println("Graph: ");
        g.printGraph();
        int source = 2;
        int destination = 0;
        System.out.println("Path Exists Between : " + source + "," + destination + " - " +
                this.checkPath(g, source, destination));
        System.out.println("Path Exists Between (Stack) : " + source + "," + destination + " - " +
                this.checkPathStack(g, source, destination));
        System.out.println("Path Exists Between (Stack) : " + source + "," + destination + " - " +
                this.getPathStack(g, source, destination));
        source = 1;
        destination = 7;
        System.out.println("Path Exists Between : " + source + "," + destination + " - " +
                this.checkPath(g, source, destination));
        System.out.println("Path Exists Between (Stack) : " + source + "," + destination + " - " +
                this.checkPathStack(g, source, destination));
        System.out.println("Path Exists Between (Stack) : " + source + "," + destination + " - " +
                this.getPathStack(g, source, destination));
    }

    private boolean checkPath(Graph g, int source, int destination) {
        boolean[] visited = new boolean[g.vertices];
        if (source == destination) return true;
        return checkPath(g, source, destination, visited);

    }

    private boolean checkPath(Graph g, int source, int destination, boolean[] visited) {
        boolean pathExists = false;
        visited[source] = true;
        DoublyLinkedList<Integer>.Node edge = g.adjacencyList[source].getHeadNode();
        while (edge != null) {
            int vertex = edge.data;
            if (vertex == destination) return true;
            if (!visited[vertex] && this.checkPath(g, vertex, destination, visited)) return true;
            edge = edge.nextNode;
        }
        return pathExists;
    }

    private boolean checkPathStack(Graph g, int source, int destination) {
        boolean isPath = false;
        boolean[] visited = new boolean[g.vertices];
        visited[source] = true;
        Stack<Integer> vertices = new Stack<>(g.vertices);
        vertices.push(source);
        while (!vertices.isEmpty()) {
            int vertex = vertices.pop();
            DoublyLinkedList<Integer>.Node edge = g.adjacencyList[vertex].getHeadNode();
            while (edge != null) {
                int v = edge.data;
                if (v == destination) return true;
                if (!visited[v]) {
                    vertices.push(v);
                    visited[v] = true;
                }
                edge = edge.nextNode;
            }
        }
        return isPath;
    }

    private HashSet<Integer> getPathStack(Graph g, int source, int destination) {
        boolean isPath = false;
        boolean[] visited = new boolean[g.vertices];
        visited[source] = true;
        Stack<Integer> vertices = new Stack<>(g.vertices);
        HashSet<Integer> route = new HashSet<>();
        vertices.push(source);
        route.add(source);
        while (!vertices.isEmpty()) {
            int vertex = vertices.pop();
            DoublyLinkedList<Integer>.Node edge = g.adjacencyList[vertex].getHeadNode();
            while (edge != null) {
                int v = edge.data;
                if (!visited[v]) {
                    route.add(v);
                    if (v == destination) return route;
                    vertices.push(v);
                    visited[v] = true;
                }
                edge = edge.nextNode;
            }
            route.remove(vertex);
        }
        route.remove(source);
        return route;
    }

}
