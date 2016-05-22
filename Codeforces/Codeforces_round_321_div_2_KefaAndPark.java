import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/21/2016.
 */

public class Codeforces_round_321_div_2_KefaAndPark {

    static long answer = 0;
    static long max;
    static int[] cats;
    static boolean[] visited;

    static HashMap<Integer, ArrayList<Integer>> map;
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int nodes = input.nextInt();
        max = input.nextInt();
        cats = new int[nodes];
        visited = new boolean[nodes];

        for (int i = 0; i < cats.length; i++) {
            cats[i] = input.nextInt();
        }
        map = new HashMap<>();
        for (int i = 0; i < nodes - 1; i++) {
            int start = input.nextInt() - 1;
            int end = input.nextInt() - 1;
            ArrayList<Integer> list;
            if(!map.containsKey(start)) {
                list = new ArrayList<>();
            } else {
                list = map.get(start);
            }
            list.add(end);
            map.put(start, list);
            ArrayList<Integer> list2;
            if(!map.containsKey(end)) {
                list2 = new ArrayList<>();
            } else {
                list2 = map.get(end);
            }
            list2.add(start);
            map.put(end, list2);
        }
        DFS(0, 0);
        out.println(answer);
        out.close();
    }

    public static void DFS(int x, int current) {
        if(!visited[x]) {
            if (cats[x] == 0) {
                current = 0;
            } else {
                current += cats[x];
            }
            visited[x] = true;
            if (current <= max) {
                if(map.get(x).size() == 1 && visited[map.get(x).get(0)]) {
                    answer++;
                } else {
                    for (int next : map.get(x)) {
                        DFS(next, current);
                    }
                }
            }
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

