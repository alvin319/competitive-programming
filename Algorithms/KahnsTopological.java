import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Alvin on 7/30/2016.
 */

public class KahnsTopological {
    public static void main(String[] args) {
        ArrayList<Integer>[] adj = new ArrayList[6];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[5].add(2);
        adj[5].add(0);
        adj[4].add(0);
        adj[4].add(1);
        adj[2].add(3);
        adj[3].add(1);

        ArrayList<Integer> solution = topologicalSort(adj, adj.length);

        if (solution != null) {
            for (int i = 0; i < solution.size(); i++) {
                System.out.print(i == 0 ? solution.get(i) : " " + solution.get(i));
            }
        }
    }

    public static ArrayList<Integer> topologicalSort(ArrayList<Integer>[] adj, int vertexCount) {
        int incomingEdges[] = new int[adj.length];

        for (int i = 0; i < adj.length; i++) {
            ArrayList<Integer> neighbors = (ArrayList<Integer>) adj[i];
            for (int toNode : neighbors) {
                incomingEdges[toNode]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertexCount; i++) {
            // Found the starting point
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }

        int visitedNodeCount = 0;
        ArrayList<Integer> topologicalOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            int startNode = queue.poll();
            topologicalOrder.add(startNode);

            for (int toNode : adj[startNode]) {
                incomingEdges[toNode]--;
                if (incomingEdges[toNode] == 0) {
                    queue.add(toNode);
                }
            }

            visitedNodeCount++;
        }

        if (visitedNodeCount != vertexCount) {
            System.out.println("There exists a cycle in the graph");
            return null;
        }
        return topologicalOrder;
    }
}


