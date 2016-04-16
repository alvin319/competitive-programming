import java.util.*;
import java.lang.*;

public class BellmanFord {

    public static void printArr(int dist[], int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void BellmanFordCalc(Graph graph, int src) {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];
        int num[] = new int[V];
        int ShortestPathCache[] = new int[V];
        ArrayList<HashSet<Edge>> predecessor = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            predecessor.add(new HashSet<Edge>());
        }

        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;

        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    HashSet<Edge> newList = new HashSet<>();
                    newList.add(graph.edge[j]);
                    predecessor.set(v, newList);
                } else if (dist[u] != Integer.MAX_VALUE && dist[u] + weight == dist[v]) {
                    predecessor.get(v).add(graph.edge[j]);
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

        int y = 0;
        System.out.println("Node Predecessor");
        for(HashSet<Edge> x : predecessor) {
            System.out.println(y + " " + x);
            y++;
        }
        System.out.println();

        int destination = 4;
        boolean[] visited = new boolean[V];
        int shortestPathCount = getNumberOfShortestPath(predecessor, destination, visited, ShortestPathCache);
        System.out.println(num[destination]);
        for(int x : num)
            System.out.println(x);
        System.out.println("Destination: " + destination + " numberOfShortestPathFromSource: " + shortestPathCount + "\n");
        printArr(dist, V);

    }

    public static int getNumberOfShortestPath(ArrayList<HashSet<Edge>> predecessor, int current, boolean[] visited, int[] ShortestPathCache) {
        if(current == 0) {
            return 1;
        } else if(ShortestPathCache[current] != 0) {
            return ShortestPathCache[current];
        } else if(!visited[current]) {
            visited[current] = true;
            int totalCount = 0;
            for (Edge x : predecessor.get(current)) {
                totalCount += getNumberOfShortestPath(predecessor, x.src, visited, ShortestPathCache);
            }
            visited[current] = false;
            ShortestPathCache[current] = totalCount;
            return totalCount;
        }
        return 0;
    }

    public static void main(String[] args) {
        int Vertices = 5;
        int Edges = 9;

        Graph graph = new Graph(Vertices, Edges);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 1;

        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 1;

        graph.edge[2].src = 2;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 1;

        graph.edge[3].src = 3;
        graph.edge[3].dest = 4;
        graph.edge[3].weight = 1;

        graph.edge[4].src = 0;
        graph.edge[4].dest = 2;
        graph.edge[4].weight = 2;

        graph.edge[5].src = 2;
        graph.edge[5].dest = 4;
        graph.edge[5].weight = 2;

        graph.edge[6].src = 1;
        graph.edge[6].dest = 3;
        graph.edge[6].weight = 2;

        graph.edge[7].src = 1;
        graph.edge[7].dest = 4;
        graph.edge[7].weight = 3;

        graph.edge[8].src = 0;
        graph.edge[8].dest = 4;
        graph.edge[8].weight = 4;

        BellmanFordCalc(graph, 0);
    }

    static class Edge {
        int src, dest, weight;

        public Edge() {
            src = dest = weight = 0;
        }

        public String toString() {
            return ""+src;
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