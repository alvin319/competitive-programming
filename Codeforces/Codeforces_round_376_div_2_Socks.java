/**
 * Created by qicodeng on 10/18/16.
 */

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Codeforces_round_376_div_2_Socks {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        int[] socks = new int[n];
        int[][] pair = new int[m][2];
        HashMap<Integer, HashSet<Integer>> group = new HashMap<>();
        HashMap<Integer, Integer> sockMap = new HashMap<>();
        for (int i = 0; i < socks.length; i++) {
            socks[i] = input.nextInt();
            DisjointSet.createSet(i);
        }
        for (int i = 0; i < m; i++) {
            int l = input.nextInt() - 1;
            int r = input.nextInt() - 1;
            DisjointSet.unionSet(l, r);
            pair[i][0] = l;
            pair[i][1] = r;
        }

        for (int i = 0; i < pair.length; i++) {
            int parent = DisjointSet.findSet(pair[i][0]);
            HashSet<Integer> set = group.containsKey(parent) ? group.get(parent) : new HashSet<>();
            set.add(pair[i][0]);
            set.add(pair[i][1]);
            group.put(parent, set);
        }

        for (int groupID : group.keySet()) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int x : group.get(groupID)) {
                freq.put(socks[x], freq.containsKey(socks[x]) ? freq.get(socks[x]) + 1 : 1);
            }
            int maxColor = -1;
            int maxCount = -1;
            for (int x : freq.keySet()) {
                if (freq.get(x) > maxCount) {
                    maxColor = x;
                    maxCount = freq.get(x);
                }
            }
            sockMap.put(groupID, maxColor);
        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            int l = pair[i][0];
            int r = pair[i][1];
            int color = sockMap.get(DisjointSet.findSet(l));
            if (socks[l] != color) {
                socks[l] = color;
                answer++;
            }
            if (socks[r] != color) {
                socks[r] = color;
                answer++;
            }
        }
        out.println(answer);
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

        static HashMap<Integer, Node> map = new HashMap<>();

        public static void createSet(int data) {
            Node node = new Node(data, 0);
            node.parent = node;
            map.put(data, node);
        }

        public static int findSet(int data) {
            int parentData = map.get(data).parent.data;
            if (parentData == data) {
                return data;
            } else {
                return findSet(parentData);
            }
        }

        public static boolean unionSet(int firstSet, int secondSet) {
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
