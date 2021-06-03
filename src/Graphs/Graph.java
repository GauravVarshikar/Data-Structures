package Graphs;

import java.util.*;

/* Custom implementation of graph having an adjacency list */
class GraphNode {
    public int value;
    private int weight;
    public GraphNode(int value){
        this.value = value;
    }
    public GraphNode(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
}
public class Graph {
    public int noOfVertices;
    private final Map<Integer, List<GraphNode>> adjacentListMap;

    public Graph(){
        adjacentListMap = new HashMap<>();
    }

    public void addVertex(int value) {
        adjacentListMap.put(value, new ArrayList<>());
        noOfVertices++;
    }
    public void addEdge(int vertex1, int vertex2){
        //for undirected graphs we had to add an edge for both the vertices one by one
        List<GraphNode> adjacentList = adjacentListMap.get(vertex1);
        adjacentList.add(new GraphNode(vertex2));
        //adding vertex2 to the list of vertex1
        adjacentListMap.put(vertex1, adjacentList);

        adjacentList = adjacentListMap.get(vertex2);
        adjacentList.add(new GraphNode(vertex1));
        //adding vertex1 to the list of vertex2
        adjacentListMap.put(vertex2, adjacentList);
    }
    // Print the graph
    public void printGraph() {
        Set<Map.Entry<Integer, List<GraphNode>>> entries = adjacentListMap.entrySet();
        for(Map.Entry<Integer, List<GraphNode>> entry: entries){
            int key = entry.getKey();
            List<GraphNode> list = entry.getValue();
            System.out.print(key + " --> ");
            for(GraphNode node: list){
                System.out.print(node.value + " ");
            }
            System.out.println();
        }
    }
}
