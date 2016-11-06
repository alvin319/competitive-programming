import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/5/16.
 */

public class Codeforces_round_269_div_2_MUHAndSticks {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            int x = input.nextInt();
            map.put(x, map.containsKey(x) ? map.get(x) + 1 : 1);
        }
        if (map.keySet().size() == 1) {
            out.println("Elephant");
        } else if (map.keySet().size() == 2) {
            for (int x : map.keySet()) {
                if (map.get(x) == 4) {
                    out.println("Elephant");
                    System.exit(0);
                } else if (map.get(x) == 5) {
                    out.println("Bear");
                    System.exit(0);
                }
            }
            out.println("Alien");
        } else if (map.keySet().size() == 3) {
            for (int x : map.keySet()) {
                if (map.get(x) == 4) {
                    out.println("Bear");
                    System.exit(0);
                }
            }
            out.println("Alien");
        } else {
            out.println("Alien");
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
}