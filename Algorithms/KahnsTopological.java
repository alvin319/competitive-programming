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
            ArrayList<Integer> temp = (ArrayList<Integer>) adj[i];
            for (int node : temp) {
                incomingEdges[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < vertexCount; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }

        int visited = 0;
        ArrayList<Integer> topologicalOrder = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int startNode = queue.poll();
            topologicalOrder.add(startNode);

            for (int node : adj[startNode]) {
                incomingEdges[node]--;
                if (incomingEdges[node] == 0) {
                    queue.add(node);
                }
            }

            visited++;
        }

        if (visited != vertexCount) {
            System.out.println("There exists a cycle in the graph");
            return null;
        }
        return topologicalOrder;
    }
}


