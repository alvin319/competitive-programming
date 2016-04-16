import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/15/16.
 */

public class Codeforces_Educational_round_8_TennisTournament {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int b = input.nextInt();
        int p = input.nextInt();
        int totalWater = 0;
        int totalTowel = n * p;
        if(n == 1) {
            out.println(0 + " " + p);
        } else {
            while (n > 1) {
                int matches = maxK(n) / 2;
                int remainPlayer = n - maxK(n);
                totalWater += matches * (2 * b + 1);
                n = matches + remainPlayer;
            }
            out.println(totalWater + (2 * b + 1) + " " + totalTowel);
        }
        out.close();
    }

    public static int maxK(int m) {
        int k = 1;
        while(k < m) {
            k *= 2;
        }
        return k / 2;
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