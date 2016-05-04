import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/4/16.
 */

public class Codeforces_VKCup_2015_round_1_Reposts {

    static HashMap<String, ArrayList<String>> graph;

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] current = input.nextLine().split(" ");
            if(!graph.containsKey(current[2].toLowerCase())) {
                ArrayList<String> list = new ArrayList<>();
                list.add(current[0].toLowerCase());
                graph.put(current[2].toLowerCase(), list);
            } else {
                ArrayList<String> list = graph.get(current[2].toLowerCase());
                list.add(current[0].toLowerCase());
                graph.put(current[2].toLowerCase(), list);
            }
        }
        int answer = DFS("polycarp");
        out.println(answer + 1);
        out.close();
    }

    public static int DFS(String s) {
        if(!graph.containsKey(s) || graph.get(s).size() == 0) {
            return 0;
        }
        ArrayList<String> list = graph.get(s);
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, 1 + DFS(list.get(i)));
        }
        return max;
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