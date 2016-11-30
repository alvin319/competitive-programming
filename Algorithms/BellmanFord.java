import java.util.*;
import java.lang.*;

public class BellmanFord {

    public static void printArr(int dist[], int V, int source) {
        System.out.println("Vertex Distance from Source " + source);
        for (int i = 0; i < V; ++i)
            System.out.println("Destination: " + i + "\t\t" + "cost: " + dist[i]);
    }

    public static void BellmanFordCalc(Graph graph, int src) {
        int V = graph.V, E = graph.E;
        int distance[] = new int[V];

        for (int i = 0; i < V; ++i) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[src] = 0;

        for (int i = 0; i < V - 1; ++i) {
            for (int j = 0; j < E; ++j) {
                int startNode = graph.edge[j].src;
                int endNode = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (distance[startNode] != Integer.MAX_VALUE && distance[startNode] + weight < distance[endNode]) {
                    distance[endNode] = distance[startNode] + weight;
                }
            }
        }

//        for (int j = 0; j < E; ++j) {
//            int u = graph.edge[j].src;
//            int v = graph.edge[j].dest;
//            int weight = graph.edge[j].weight;
//            if (dist[u] != Integer.MAX_VALUE &&
//                    dist[u] + weight < dist[v])
//                System.out.println("Graph contains negative weight cycle");
//        }

        printArr(distance, V, src);

    }


    public static void main(String[] args) {
        int Vertices = 5;
        int Edges = 10;

        Graph graph = new Graph(Vertices, Edges);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 5;

        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 1;

        graph.edge[2].src = 2;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 1;

        graph.edge[4].src = 0;
        graph.edge[4].dest = 2;
        graph.edge[4].weight = 2;

        graph.edge[6].src = 1;
        graph.edge[6].dest = 3;
        graph.edge[6].weight = 2;

        graph.edge[8].src = 0;
        graph.edge[8].dest = 4;
        graph.edge[8].weight = 90;

        graph.edge[9].src = 3;
        graph.edge[9].dest = 4;
        graph.edge[9].weight = 15;

        BellmanFordCalc(graph, 0);
    }

    static class Edge {
        int src, dest, weight;

        public Edge() {
            src = dest = weight = 0;
        }

        public String toString() {
            return "" + src;
        }
    }

    static class Graph {

        int V, E;
        Edge edge[];

        Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[e];
            for (int i = 0; i < e; i++)
                edge[i] = new Edge();
        }
    }
}