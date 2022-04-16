package Problems.Graphs;

import Common.Problem;
import Utils.DoublyLinkedList;
import Problems.Queues.Queue;

public class BreadthFirstSearch extends Problem {
    @Override
    public void run() {
        System.out.println("Running Breadth First Search Traversal Of Graph");
        int vertices;
        vertices = 5;
        // Directed Graph
        System.out.println("Directed Graph: ");
        Graph graph = new Graph(vertices);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        System.out.println("Breadth First Search: " + this.bfs(graph));
    }

    // Why queue ? ---> First In First Out which is needed when you level by level
    // Same as level order traversal in a Binary tree
    // Keep track of visited vertices
    // Use a queue. Add root to queue to start and run the loop until queue is not empty
    // In the loop add vertex edges to the queue
    // Time complexity : O(n) ---> visiting all the nodes
    // Space complexity : Best Case O(1) ---> only one edge per vertex
    //                    Worst Case O(n) ---> Perfect binary tree. n/2 nodes at the bottom
    private String bfs(Graph graph) {
        String result = "";
        boolean[] visited = new boolean[graph.vertices];
        for (int i = 0; i < graph.vertices; i++) {
            if (!visited[i]) {
                result = result + this.bfsHelper(graph, i, visited);
            }
        }
        return result;
    }

    private String bfsHelper(Graph graph, int source, boolean[] visited) {
        String result = "";
        Queue<Integer> vertexQue = new Queue<>(graph.vertices);
        vertexQue.enqueue(source);
        while (!vertexQue.isEmpty()) {
            int vertex = vertexQue.dequeue();
            visited[vertex] = true;
            result = result + vertex;
            DoublyLinkedList<Integer> edges = graph.adjacencyList[vertex];
            if (edges != null) {
                DoublyLinkedList<Integer>.Node edge = edges.getHeadNode();
                while (edge != null) {
                    // If not already visited add to the queue
                    // example (0, 1) , (1, 3) , (2, 1)
                    // 1 is already visited after 0. No need to visit again after 2
                    if (!visited[edge.data]) {
                        vertexQue.enqueue(edge.data);
                    }
                    edge = edge.nextNode;
                }
            }
        }
        return result;
    }
}
