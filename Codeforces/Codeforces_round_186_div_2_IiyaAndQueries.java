import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by alvin on 6/21/16.
 */

public class Codeforces_round_186_div_2_IiyaAndQueries {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String current = input.nextLine();
        long[] cache = new long[current.length()];
        for (int i = 1; i < cache.length; i++) {
            cache[i] = current.charAt(i) == current.charAt(i - 1) ? cache[i - 1] + 1 : cache[i - 1];
        }
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            int left = input.nextInt();
            int right = input.nextInt();
            out.println(cache[right - 1] - cache[left - 1]);
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
