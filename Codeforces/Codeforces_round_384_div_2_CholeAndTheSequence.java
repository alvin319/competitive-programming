/**
 * Created by qicodeng on 12/15/16.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_round_384_div_2_CholeAndTheSequence {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        long k = input.nextLong() - 1;
        long size = (long) Math.pow(2, n + 1) - 1;
        long answer = n + 1;
        long start = 0;
        long end = size;
        while (true) {
            long mid = ((start + end) / 2);
            if (mid == k) {
                break;
            } else if (k > mid) {
                answer--;
                start = mid + 1;
            } else {
                answer--;
                end = mid;
            }
        }
        out.println(answer);
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
