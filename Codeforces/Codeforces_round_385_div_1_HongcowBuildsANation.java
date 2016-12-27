import java.io.*;
import java.util.*;

/**
 * Created by Alvin on 12/26/2016.
 */

public class Codeforces_round_385_div_1_HongcowBuildsANation {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        DisjointSet set = new DisjointSet();
        for (int i = 0; i < n; i++) {
            set.createSet(i + 1);
        }
        int[] government = new int[k];
        for (int i = 0; i < government.length; i++) {
            government[i] = input.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            set.unionSet(from, to);
        }
        HashMap<Integer, Integer> cluster = new HashMap<>();
        for (int point : set.map.keySet()) {
            int group = set.findSet(point);
            cluster.put(group, cluster.containsKey(group) ? cluster.get(group) + 1 : 1);
        }
        HashSet<Integer> deny = new HashSet<>();
        for (int i = 0; i < government.length; i++) {
            deny.add(set.findSet(government[i]));
        }
        long answer = 0;
        for (int point : cluster.keySet()) {
            int size = cluster.get(point);
            answer += (size * (size - 1)) / 2;
        }
        ArrayList<Integer> regular = new ArrayList<>();
        ArrayList<Integer> special = new ArrayList<>();
        for (int group : cluster.keySet()) {
            if (deny.contains(group)) {
                special.add(cluster.get(group));
            } else {
                regular.add(cluster.get(group));
            }
        }
        Collections.sort(special);
        if (special.size() != 0 && regular.size() != 0) {
            int specialSize = special.get(special.size() - 1);
            for (int x : regular) {
                answer += (x * specialSize);
                specialSize += x;
            }
        }
        out.println(answer - m);
        out.close();
    }

    public static PrintWriter out;

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

