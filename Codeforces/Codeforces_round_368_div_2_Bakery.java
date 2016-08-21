import java.io.*;
import java.util.*;

/**
 * Created by Alvin on 8/21/2016.
 */

public class Codeforces_round_368_div_2_Bakery {

    static ArrayList<Edge> allEdges;

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        init();
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        for (int i = 0; i < m; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            int weight = input.nextInt();
            addEdge(start, end, weight);
            addEdge(end, start, weight);
        }
        HashSet<Integer> bakery = new HashSet<>();
        for (int i = 0; i < k; i++) {
            bakery.add(input.nextInt());
        }
        int lowestCost = Integer.MAX_VALUE;
        for (Edge current : allEdges) {
            if (bakery.contains(current.start) && !bakery.contains(current.end)) {
                lowestCost = Math.min(current.weight, lowestCost);
            } else if (bakery.contains(current.end) && !bakery.contains(current.start)) {
                lowestCost = Math.min(current.weight, lowestCost);
            }
        }

        System.out.println(lowestCost == Integer.MAX_VALUE ? -1 : lowestCost);
        out.close();
    }

    public static void init() {
        allEdges = new ArrayList<>();
    }


    public static void addEdge(int start, int end, int weight) {
        Edge currentEdge = new Edge(start, end, weight);
        allEdges.add(currentEdge);
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int s, int e, int weight) {
            this.start = s;
            this.end = e;
            this.weight = weight;
        }
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

