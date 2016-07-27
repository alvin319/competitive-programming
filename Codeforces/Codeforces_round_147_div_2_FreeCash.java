import javafx.util.Pair;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/25/2016.
 */

public class Codeforces_round_147_div_2_FreeCash {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        HashMap<Pair, Integer> map = new HashMap<>();
        int best = -1;
        for (int i = 0; i < count; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            Pair current = new Pair(x, y);
            if(!map.containsKey(current)) {
                map.put(current, 1);
            } else {
                map.put(current, map.get(current) + 1);
            }
            best = Math.max(map.get(current), best);
        }
        out.println(best);
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