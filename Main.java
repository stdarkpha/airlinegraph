package airlinegraph;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Node g = new Node();

        g.addVertex("Jakarta");
        g.addVertex("Surabaya");
        g.addVertex("Yogyakarta");
        g.addVertex("Bandung");
        g.addVertex("Semarang");
        g.addVertex("Makassar");
        g.addVertex("Denpasar");

        g.addEdge("Jakarta", "Surabaya");
        g.addEdge("Jakarta", "Yogyakarta");
        g.addEdge("Jakarta", "Bandung");
        g.addEdge("Surabaya", "Yogyakarta");
        g.addEdge("Surabaya", "Semarang");
        g.addEdge("Yogyakarta", "Bandung");
        g.addEdge("Yogyakarta", "Semarang");
        g.addEdge("Yogyakarta", "Denpasar");
        g.addEdge("Bandung", "Semarang");
        g.addEdge("Semarang", "Makassar");
        g.addEdge("Makassar", "Denpasar");
        g.addEdge("Denpasar", "Jakarta");
        g.addEdge("Denpasar", "Yogyakarta");

        g.printGraph();
        System.out.print("\nAda " + g.lengthVertex() + " kota ");
        System.out.println("dan Ada " + g.lengthEdge() + " rute penerbangan");

        HashMap<String, LinkedList<String>> adjList = g.getAdjList();
        Method method = new Method(adjList);

        String src = "Jakarta";
        String dst = "Denpasar";
        LinkedList<String> terpendek = method.terpendek(src, dst);
        System.out.println("Rute terpendek dari " + src + " ke " + dst + ":");
        for (String city : terpendek) {
            System.out.print(city + " -> ");
        }
        System.out.println("Selesai");
    }
}