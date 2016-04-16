import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/15/16.
 */

public class TravellingCandidate {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long count = input.nextLong();
        for (int i = 0; i < count; i++) {
            int size = input.nextInt();
            MST graph = new MST(size);
            int[][] matrix = new int[size][size];
            for(int j = 0; j < size - 1; j++) {
                int x = input.nextInt() - 1;
                int y = input.nextInt() - 1;
                int cost = input.nextInt();
                matrix[x][y] = cost;
                matrix[y][x] = cost;
            }
            graph.primMST(matrix);
        }
        out.close();
    }

    public static PrintWriter out;

    public static class MST {
        // Number of vertices in the graph
        int V;

        public MST(int V) {
            this.V = V;
        }

        int minKey(int key[], Boolean mstSet[]) {
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < V; v++)
                if (mstSet[v] == false && key[v] < min) {
                    min = key[v];
                    min_index = v;
                }

            return min_index;
        }

        void printMST(int parent[], int n, int graph[][]) {
            long weightTotal = 0;
            int i = 1;
            for (;i < V; i++) {
                weightTotal += graph[i][parent[i]];
            }
            System.out.println(weightTotal + graph[i - 1][parent[i - 1]]);
        }

        void primMST(int graph[][]) {
            int parent[] = new int[V];
            int key[] = new int[V];
            Boolean mstSet[] = new Boolean[V];

            for (int i = 0; i < V; i++) {
                key[i] = Integer.MAX_VALUE;
                mstSet[i] = false;
            }

            key[0] = 0;
            parent[0] = -1;

            for (int count = 0; count < V - 1; count++) {
                int u = minKey(key, mstSet);
                mstSet[u] = true;

                for (int v = 0; v < V; v++)
                    if (graph[u][v] != 0 && mstSet[v] == false &&
                            graph[u][v] < key[v]) {
                        parent[v] = u;
                        key[v] = graph[u][v];
                    }
            }
            printMST(parent, V, graph);
        }
    }

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