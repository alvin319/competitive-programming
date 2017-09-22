import java.io.*;
import java.util.*;


public class Codeforces_round_435_div_2_MahmoudAndEhabaAndTheBipartitness {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int from = input.nextInt() - 1;
            int to = input.nextInt() - 1;
            adj[from].add(to);
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            if (!map.containsKey(to)) {
                map.put(to, new ArrayList<>());
            }
            map.get(from).add(to);
            map.get(to).add(from);
        }
        int startingIndex = topologicalSortStart(adj, n);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startingIndex, 1, -1});
        HashMap<Integer, ArrayList<Integer>> levelMap = new HashMap<>();
        int maxLevel = -1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int index = current[0];
            int level = current[1];
            int parent = current[2];
            if (!levelMap.containsKey(level)) {
                levelMap.put(level, new ArrayList<>());
            }
            levelMap.get(level).add(index);
            for (int neighbor : map.get(index)) {
                if (neighbor != parent) {
                    queue.add(new int[]{neighbor, level + 1, index});
                    maxLevel = Math.max(maxLevel, level + 1);
                }
            }
        }
        long answer = -(n - 1);
        for (int i = 1; i <= maxLevel - 1; i++) {
            answer += levelMap.get(i).size() * levelMap.get(i + 1).size();
        }
        int[] levelCache = new int[maxLevel];
        int oddCount = 0;
        int evenCount = 0;
        for (int i = 1; i <= maxLevel; i++) {
            if (i % 2 == 0) {
                evenCount += levelMap.get(i).size();
                levelCache[i - 1] = oddCount;
            } else {
                oddCount += levelMap.get(i).size();
                levelCache[i - 1] = evenCount;
            }
        }
        for (int i = 0; i < levelCache.length; i++) {
            if (i - 2 >= 0) {
                answer += levelCache[i - 2] * levelMap.get(i + 1).size();
            }
        }
        out.println(answer);
        out.close();
    }

    static Integer topologicalSortStart(ArrayList<Integer>[] adj, int vertexCount) {
        int incomingEdges[] = new int[adj.length];

        for (int i = 0; i < adj.length; i++) {
            ArrayList<Integer> temp = (ArrayList<Integer>) adj[i];
            for (int node : temp) {
                incomingEdges[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertexCount; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> topologicalOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int startNode = queue.poll();
            topologicalOrder.add(startNode);

            for (int node : adj[startNode]) {
                incomingEdges[node]--;
                if (incomingEdges[node] == 0) {
                    queue.add(node);
                }
            }
        }

        return topologicalOrder.get(0);
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