/**
 * Created by qicodeng on 10/17/16.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_round_211_div_2_Fence {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        int k = input.nextInt();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int[] prefix = new int[array.length];
        int current = 0;
        for (int i = 0; i < array.length; i++) {
            current += array[i];
            prefix[i] = current;
        }
        int index = -1;
        int overall = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - k + 1; i++) {
            int first = i - 1 < 0 ? 0 : prefix[i - 1];
            int second = prefix[prefix.length - 1] - prefix[i + k - 1];
            int currentSum = prefix[prefix.length - 1] - first - second;
            if (currentSum < overall) {
                overall = currentSum;
                index = i;
            }
        }
        out.println(index + 1);
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
