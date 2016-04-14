import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WiNDWAY on 9/16/15.
 */

public class Codeforces_round_20_C_Dijkstra {

    public static int[] finalPath;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int vertices = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        ArrayList<Node> nodes = new ArrayList<Node>();
        finalPath = new int[vertices];

        for(int i = 0; i < vertices; i++) {
            finalPath[i] = -1;
        }

        for (int i = 0; i < vertices; i++) {
            nodes.add(new Node(Integer.MAX_VALUE, false, i));
        }

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Node begin = nodes.get(start - 1);
            if(!begin.neighbors.containsKey(end - 1)) {
                begin.neighbors.put(end - 1, weight);
            } else {
                int storedValue = begin.neighbors.get(end - 1);
                if(weight < storedValue) {
                    begin.neighbors.put(end - 1, weight);
                }
            }

            Node over = nodes.get(end - 1);
            if(!begin.neighbors.containsKey(start - 1)) {
                over.neighbors.put(start - 1, weight);
            } else {
                int storedValue = over.neighbors.get(start - 1);
                if(weight < storedValue) {
                    over.neighbors.put(start - 1, weight);
                }
            }


        }

        PriorityQueue<Node> path = new PriorityQueue<Node>(vertices, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.totalCost - o2.totalCost;
            }
        });

        Node start = nodes.get(0);
        start.totalCost = 0;
        nodes.set(0, start);
        path.add(start);
        boolean isFound = false;
        while (!path.isEmpty()) {
            Node current = path.poll();
            if(current.id == nodes.size() - 1) {
                isFound = true;
                int index = current.id;
                List<Integer> out = new ArrayList<Integer>();
                while(index != 0) {
                    out.add(index);
                    index = finalPath[index];
                }
                System.out.print(1+" ");
                for (int i = out.size() - 1; i >= 0;i--) {
                    System.out.print(out.get(i)+1 + " ");
                }
                break;
            }
            if (!current.visited) {
                current.visited = true;
                for (Integer e : current.neighbors.keySet()) {
                    Node target = nodes.get(e);
                    if(!target.visited) {
                        int calculatedCost = current.totalCost + current.neighbors.get(e);
                        if (target.totalCost > calculatedCost) {
                            target.totalCost = calculatedCost;
                            finalPath[e] = current.id;
                        }
                        path.add(target);
                    }
                }
            }
        }

        if(!isFound)
            System.out.println(-1);

    }

    static class Node {
        int id;
        int totalCost;
        boolean visited;
        HashMap<Integer, Integer> neighbors;

        public Node(int totalCost, boolean visit, int id) {
            this.id = id;
            this.totalCost = totalCost;
            this.visited = visit;
            neighbors = new HashMap<Integer, Integer>();
        }
    }
}
