package airlinegraph;

import java.util.HashMap;
import java.util.LinkedList;

public class Node {

    private final HashMap<String, LinkedList<String>> adjList;
    private int countVertex, countEdge;

    public Node() {
        adjList = new HashMap<>();
        countEdge = countVertex = 0;
    }

    public void addVertex(String vertex) {
        adjList.put(vertex, new LinkedList<>());
        countVertex++;
    }

    public void addEdge(String src, String dst) {
        LinkedList<String> srcNeighbors = adjList.get(src);
        LinkedList<String> dstNeighbors = adjList.get(dst);

        if (srcNeighbors != null && dstNeighbors != null) {
            srcNeighbors.add(dst);
            dstNeighbors.add(src);
            countEdge++;
        }
    }

    public int lengthVertex() {
        return countVertex;
    }

    public int lengthEdge() {
        return countEdge;
    }

    public void printGraph() {
        for (String vertex : adjList.keySet()) {
            System.out.print(vertex + ":");
            for (String data : adjList.get(vertex))
                System.out.print(" -> " + data);
            System.out.println();
        }
    }

    public HashMap<String, LinkedList<String>> getAdjList() {
        return adjList;
    }
}