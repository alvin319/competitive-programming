/**
 * Created by qicodeng on 12/1/16.
 */

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Codeforces_round_268_div_2_IWannaBeTheGuy {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        HashSet<Integer> set = new HashSet<>();
        int a = input.nextInt();
        for (int i = 0; i < a; i++) {
            set.add(input.nextInt());
        }
        int b = input.nextInt();
        for (int i = 0; i < b; i++) {
            set.add(input.nextInt());
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                out.println("Oh, my keyboard!");
                System.exit(0);
            }
        }
        out.println("I become the guy.");
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
