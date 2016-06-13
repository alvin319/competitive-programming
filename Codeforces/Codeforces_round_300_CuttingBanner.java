import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 6/12/2016.
 */

public class Codeforces_round_300_CuttingBanner {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String current = input.nextLine();
        char[] array = {'C', 'O', 'D', 'E', 'F', 'O', 'R', 'C', 'E', 'S'};
        int l = 0;
        int r = 0;

        while (l < Math.min(10, current.length()) && current.charAt(l) == array[l]) {
            l++;
        }
        while(r < Math.min(10, current.length()) && current.charAt(current.length() - r - 1) == array[10 - r - 1]) {
            r++;
        }
        out.println(l + r >= 10 ? "YES" : "NO");
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

