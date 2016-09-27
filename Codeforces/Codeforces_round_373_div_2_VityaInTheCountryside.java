/**
 * Created by qicodeng on 9/27/16.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_round_373_div_2_VityaInTheCountryside {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int change = 0;
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int previous = array[i - 1];
            change = previous - current;
        }
        if (change == 0 && (array[array.length - 1] != 15 && array[array.length - 1] != 0)) {
            out.println(-1);
        } else {
            if (array[array.length -1] == 15) {
                out.println("DOWN");
            } else if (array[array.length - 1] == 0) {
                out.println("UP");
            } else {
                out.println(change == -1 ? "UP" : "DOWN");
            }
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
