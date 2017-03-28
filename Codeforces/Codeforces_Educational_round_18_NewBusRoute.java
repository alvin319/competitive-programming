import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 3/28/2017.
 */

public class Codeforces_Educational_round_18_NewBusRoute {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        Arrays.sort(array);
        if (array.length == 2) {
            out.println(Math.abs(array[0] - array[1]) + " " + 1);
        } else {
            int min = Integer.MAX_VALUE;
            int count = 0;
            for (int i = 0; i < array.length - 1; i++) {
                int after = Math.abs(array[i] - array[i + 1]);
                if (after < min) {
                    min = after;
                    count = 1;
                } else if (after == min) {
                    count++;
                }
            }
            out.println(min + " " + count);
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

