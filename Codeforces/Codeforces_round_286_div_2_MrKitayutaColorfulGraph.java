import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 8/27/16.
 */

public class Codeforces_round_286_div_2_MrKitayutaColorfulGraph {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        HashMap<Integer, DisjointSet> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            int c = input.nextInt();
            DisjointSet currentSet;
            if (!map.containsKey(c)) {
                currentSet = new DisjointSet();
            } else {
                currentSet = map.get(c);
            }
            if (!currentSet.map.containsKey(u)) {
                currentSet.createSet(u);
            }
            if (!currentSet.map.containsKey(v)) {
                currentSet.createSet(v);
            }
            currentSet.unionSet(u, v);
            map.put(c, currentSet);
        }
        int q = input.nextInt();
        for (int i = 0; i < q; i++) {
            int colors = 0;
            int u = input.nextInt();
            int v = input.nextInt();
            for (int color : map.keySet()) {
                DisjointSet currentSet = map.get(color);
                int findU = currentSet.findSet(u);
                if (findU != -1 && findU == currentSet.findSet(v)) {
                    colors++;
                }
            }
            out.println(colors);
        }
        out.close();
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

    static class DisjointSet {

        HashMap<Integer, Node> map;

        public DisjointSet() {
            map = new HashMap<>();
        }

        public void createSet(int data) {
            Node node = new Node(data, 0);
            node.parent = node;
            map.put(data, node);
        }

        public int findSet(int data) {
            if (!map.containsKey(data)) {
                return -1;
            } else {
                int parentData = map.get(data).parent.data;
                if (parentData == data) {
                    return data;
                } else {
                    return findSet(parentData);
                }
            }
        }

        public boolean unionSet(int firstSet, int secondSet) {
            int firstParentID = findSet(firstSet);
            int secondParentID = findSet(secondSet);
            Node firstParent = map.get(firstParentID);
            Node secondParent = map.get(secondParentID);

            // If they are part of same set do nothing
            if (firstParentID == secondParentID) {
                return false;
            }

            if (firstParent.rank > secondParent.rank) {
                secondParent.parent = firstParent;
            } else if (firstParent.rank < secondParent.rank) {
                firstParent.parent = secondParent;
            } else {
                firstParent.rank++;
                secondParent.parent = firstParent;
            }
            map.put(firstParentID, firstParent);
            map.put(secondParentID, secondParent);

            return true;
        }

        static class Node {
            int data;
            Node parent;
            int rank;

            public Node(int data, int rank) {
                this.data = data;
                this.rank = rank;
            }
        }
    }
}