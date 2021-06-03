package Graphs;

public class GraphMain {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(0);graph.addVertex(1);
        graph.addVertex(2);graph.addVertex(3);
        graph.addVertex(4);graph.addVertex(5);
        graph.addVertex(6);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(6, 5);
        graph.printGraph();
    }
}
