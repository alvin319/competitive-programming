/**
 * Created by qicodeng on 11/11/16.
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforces_round_265_div_2_IncARG {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int[] array = new int[n];
        char[] num = input.nextLine().toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = num[i] - '0';
        }
        int[] newArray = new int[n];
        int current = 1;
        for (int i = 0; i < array.length; i++) {
            int total = current + array[i];
            if (total == 2) {
                newArray[i] = 0;
                current = 1;
            } else {
                current = 0;
                newArray[i] = total;
            }
        }
        int diff = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != newArray[i]) {
                diff++;
            }
        }
        out.println(diff);
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
