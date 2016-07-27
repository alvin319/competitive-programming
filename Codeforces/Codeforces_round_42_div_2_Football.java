import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/30/2016.
 */

public class Codeforces_round_42_div_2_Football {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        String bestTeam = "";
        int bestCount = -1;
        for (int i = 0; i < count; i++) {
            String line = input.nextLine();
            map.put(line, map.containsKey(line) ? map.get(line) + 1 : 1);
        }
        for (String line : map.keySet()) {
            if (map.get(line) > bestCount) {
                bestCount = map.get(line);
                bestTeam = line;
            }
        }
        out.println(bestTeam);
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
}

