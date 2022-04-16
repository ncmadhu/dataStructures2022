package Problems.Graphs;

import Common.Problem;
import Utils.DoublyLinkedList;
import Problems.Stacks.Stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Strongly Connected Components ---> Part of graph where we can reach any vertex from any other vertex
// Algorithm to find SCC
// Initialize visited vertices as false
// Do a DFS and populate stack with the vertex in the order they finish (no more edges to explore from that vertex)
// Reverse the graph
// Reset the visited vertices to false again
// Pop a vertex from the stack with vertices
// Do a DFS on the vertex, when recursion completes for that vertex we will have SCC of that vertex
// Kosaraju Algorithm --- Runtime O(V+ E)
// Why this works ? when we reverse the graph we break the outgoing edge from SCC,
// and when we do DFS on the vertex which finished last in the SCC we get only vertices in that SCC since
// they are all connected and the outgoing edge is removed because of reverse graph


public class FindStronglyConnectedComponents extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find Strongly Connected Components");
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
        List<HashSet<Integer>> scc = this.findStronglyConnectedComponents(g);
        for (HashSet<Integer> comp: scc) {
            System.out.println("SCC: " + comp.toString());
        }
    }

    private List<HashSet<Integer>> findStronglyConnectedComponents(Graph g) {
        boolean[] visited = new boolean[g.vertices];
        Stack<Integer> vertices = new Stack<>(g.vertices);
        List<HashSet<Integer>> sccComp = new ArrayList<>();
        for (int v = 0; v < g.vertices; v++) {
            this.dfs(g, v, visited, vertices);
        }
        Graph reverseGraph = this.reverseGraph(g);
        visited = new boolean[g.vertices];
        Stack<Integer> scc = new Stack<>(g.vertices);
        while (!vertices.isEmpty()) {
            HashSet<Integer> components = new HashSet<>();
            this.dfs(reverseGraph, vertices.pop(), visited, scc);
            while (!scc.isEmpty()) {
                components.add(scc.pop());
            }
            if (!components.isEmpty()) sccComp.add(components);
        }
        return sccComp;
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

    private void dfs(Graph g, int vertex, boolean[] visited, Stack<Integer> vertices) {
        if (visited[vertex]) return;
        //Mark the vertex as visited
        visited[vertex] = true;
        DoublyLinkedList<Integer>.Node edge = g.adjacencyList[vertex].getHeadNode();
        while (edge != null) {
            this.dfs(g, edge.data, visited, vertices);
            edge = edge.nextNode;
        }
        vertices.push(vertex);
    }
}
