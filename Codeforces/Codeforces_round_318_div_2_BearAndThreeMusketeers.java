import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/25/16.
 */

public class Codeforces_round_318_div_2_BearAndThreeMusketeers {

    public static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int v = input.nextInt();
        int e = input.nextInt();
        int minimumNum = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            HashSet<Integer> fromSet = graph.get(from);
            HashSet<Integer> toSet = graph.get(to);
            fromSet.add(to);
            toSet.add(from);
            graph.put(from, fromSet);
            graph.put(to, toSet);
            edges.add(new Edge(from, to));
        }
        for (int i = 0; i < edges.size(); i++) {
            Edge currentE = edges.get(i);
            int from = currentE.from;
            int to = currentE.to;
            HashSet<Integer> fromSet = graph.get(from);
            HashSet<Integer> toSet = graph.get(to);
            HashSet<Integer> intersection = new HashSet<>(fromSet);
            intersection.retainAll(toSet);
            for (Integer x : intersection) {
                minimumNum = Math.min(minimumNum, getR(from, to, x));
            }

        }
        if(minimumNum != Integer.MAX_VALUE) {
            out.println(minimumNum);
        } else {
            out.println(-1);
        }
        out.close();
    }

    public static int getR(int a, int b, int c) {
        return graph.get(a).size() - 2 + graph.get(b).size() - 2 + graph.get(c).size() - 2;
    }

    public static class Edge {
        int from;
        int to;
        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
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