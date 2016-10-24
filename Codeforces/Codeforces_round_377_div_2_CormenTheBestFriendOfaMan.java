/**
 * Created by qicodeng on 10/24/16.
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforces_round_377_div_2_CormenTheBestFriendOfaMan {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        int k = input.nextInt();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = array[i];
        }
        for (int i = 1; i < array.length - 1; i++) {
            array[i] += Math.max(0, k - array[i] - array[i - 1]);
        }
        if (array.length == 1) {
            array[array.length - 1] += Math.max(0, k - array[array.length - 1]);
        } else {
            array[array.length - 1] += Math.max(0, k - array[array.length - 1] - array[array.length - 2]);
        }
        int diff = 0;
        for (int i = 0; i < array.length; i++) {
            diff += Math.abs(array[i] - copy[i]);
        }
        out.println(diff);
        for (int i = 0; i < array.length; i++) {
            out.print(i == 0 ? array[i] : " " + array[i]);
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