import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/21/2016.
 */

public class Codeforces_round_87_Party {

    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> map;
    static int answer = 0;
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        map = new HashMap<>();
        int count = input.nextInt();
        visited = new boolean[count];
        ArrayList<Integer> managers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int manager = input.nextInt();
            if(manager != -1) {
                manager--;
                ArrayList<Integer> list;
                if(!map.containsKey(manager)) {
                    list = new ArrayList<>();
                } else {
                    list = map.get(manager);
                }
                list.add(i);
                map.put(manager, list);
            } else {
                managers.add(i);
            }
        }
        for(int x : managers) {
            if(!visited[x]) {
                DFS(x, 1);
            }
        }
        out.println(answer == 0 ? 1 : answer);
        out.close();
    }

    public static void DFS(int root, int depth) {
        answer = Math.max(answer, depth);
        if(!visited[root]) {
            visited[root] = true;
            if(map.containsKey(root)) {
                for(int x : map.get(root)) {
                    DFS(x, depth + 1);
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

