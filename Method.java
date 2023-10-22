package airlinegraph;

import java.util.HashMap;
import java.util.LinkedList;

public class Method {
    private final HashMap<String, LinkedList<String>> adjList;

    public Method(HashMap<String, LinkedList<String>> adjList) {
        this.adjList = adjList;
    }

    public LinkedList<String> terpendek(String src, String dst) {
        LinkedList<String> route = new LinkedList<>();
        HashMap<String, String> parentMap = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();
        HashMap<String, Boolean> visited = new HashMap<>();

        queue.add(src);
        visited.put(src, true);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(dst)) {
                String node = dst;
                while (node != null) {
                    route.addFirst(node);
                    node = parentMap.get(node);
                }
                break;
            }

            LinkedList<String> neighbors = adjList.get(current);
            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    if (!visited.containsKey(neighbor)) {
                        queue.add(neighbor);
                        visited.put(neighbor, true);
                        parentMap.put(neighbor, current);
                    }
                }
            }
        }

        return route;
    }
}