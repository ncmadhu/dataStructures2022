package Problems.Graphs;

import Common.Problem;
import Utils.DoublyLinkedList;
import Problems.Stacks.Stack;

public class DepthFirstSearch extends Problem {

    @Override
    public void run() {
        System.out.println("Running Depth First Search Traversal Of Graph");
        int vertices;
        vertices = 5;
        // Directed Graph
        System.out.println("Directed Graph: ");
        Graph graph = new Graph(vertices);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        System.out.println("Depth First Search Recursion: " + this.dfs(graph, "recursion"));
        System.out.println("Depth First Search Stack: " + this.dfs(graph, "stack"));
    }

    public String dfs(Graph g, String method) {
        String result = "";
        boolean[] visited = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++) {
            if (!visited[i]) {
                if (method.equals("recursion")) {
                    result = result + this.dfsHelperRecursion(g, i, visited);
                } else {
                    result = result + this.dfsHelperStack(g, i, visited);
                }
            }
        }
        return result;
    }

    private String dfsHelperRecursion(Graph g, int source, boolean[] visited) {
        String result = "";
        result = result + source;
        visited[source] = true;
        DoublyLinkedList<Integer>.Node edge = g.adjacencyList[source].getHeadNode();
        while (edge != null) {
            if (!visited[edge.data]) {
                result = result + this.dfsHelperRecursion(g, edge.data, visited);
            }
            edge = edge.nextNode;
        }
        return result;
    }

    // Why Stack ? ---> Stack is Last In First Out
    // Depth First needs to go the end before exhausting current level. Hence, current elements are pushed to stack
    // to be processed at the end (First In Last Out)
    private String dfsHelperStack(Graph g, int source, boolean[] visited) {
        String result= "";
        Stack<Integer> vertices =  new Stack<>(g.vertices);
        vertices.push(source);
        while (!vertices.isEmpty()) {
            int vertex = vertices.pop();
            result = result + vertex;
            DoublyLinkedList<Integer>.Node edge = g.adjacencyList[vertex].getHeadNode();
            while (edge != null) {
                if (!visited[edge.data]) {
                    vertices.push(edge.data);
                }
                edge = edge.nextNode;
            }
            visited[vertex] = true;
        }
        return result;
    }
}
