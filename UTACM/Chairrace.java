import java.io.*;
import java.util.*;

public class Chairrace {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = input.nextInt() - 1;
            int y = input.nextInt() - 1;
            adj[x].add(y);
        }
        ArrayList<Integer> answer = topologicalSort(adj, adj.length);
        out.println(answer == null ? "YES" : "NO");
        out.close();
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
            return null;
        }
        return topologicalOrder;
    }

    public static PrintWriter out;

    public static class FScanner {
        BufferedReader br;
        StringTokenizer st;

        public FScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}