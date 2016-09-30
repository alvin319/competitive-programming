/**
 * Created by qicodeng on 9/30/16.
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforces_BubbleCup_9_PotionsHomework {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        long[] diff = new long[count];
        long[] lazy = new long[count];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = input.nextLong();
        }
        Arrays.sort(diff);
        for (int i = 0; i < lazy.length; i++) {
            lazy[i] = diff[lazy.length - 1 - i];
        }
        long answer = 0;
        for (int i = 0; i < lazy.length; i++) {
            answer += ((lazy[i] * diff[i]) % 10007);
        }
        out.println(answer % 10007);
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
