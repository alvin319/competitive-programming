import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 10/7/16.
 */

public class MergingCommunities {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int q = input.nextInt();
        DisjointSet s = new DisjointSet();
        for (int i = 1; i <= n; i++) {
            s.createSet(i);
        }
        for (int i = 0; i < q; i++) {
            String[] info = input.nextLine().split(" ");
            switch (info[0]) {
                case "Q": {
                    out.println(s.getComm(Integer.parseInt(info[1])));
                } break;
                default: {
                    s.unionSet(Integer.parseInt(info[1]), Integer.parseInt(info[2]));
                }
            }
        }
        out.close();
    }

    static class DisjointSet {

        HashMap<Integer, Node> map;
        HashMap<Integer, Integer> comm;

        public DisjointSet() {
            map = new HashMap<>();
            comm = new HashMap<>();
        }

        public void createSet(int data) {
            Node node = new Node(data, 0);
            node.parent = node;
            map.put(data, node);
            comm.put(data, 1);
        }

        public int getComm(int data) {
            return comm.get(findSet(data));
        }

        public int findSet(int data) {
            int parentData = map.get(data).parent.data;
            if (parentData == data) {
                return data;
            } else {
                return findSet(parentData);
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

            boolean firstRemoval = false;

            if (firstParent.rank > secondParent.rank) {
                secondParent.parent = firstParent;
            } else if (firstParent.rank < secondParent.rank) {
                firstParent.parent = secondParent;
                firstRemoval = true;
            } else {
                firstParent.rank++;
                secondParent.parent = firstParent;
            }
            int count = -1;
            if (firstRemoval) {
                count = comm.get(firstParentID);
                comm.remove(firstParentID);
            } else {
                count = comm.get(secondParentID);
                comm.remove(secondParentID);
            }
            map.put(firstParentID, firstParent);
            map.put(secondParentID, secondParent);
            if (firstRemoval) {
                comm.put(secondParentID, comm.get(secondParentID) + count);
            } else {
                comm.put(firstParentID, comm.get(firstParentID) + count);
            }
            return true;
        }

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