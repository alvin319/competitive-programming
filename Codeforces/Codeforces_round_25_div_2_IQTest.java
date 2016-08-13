import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/4/2016.
 */

public class Codeforces_round_25_div_2_IQTest {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            boolean odd = true;
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    int difference = Math.abs(array[i] - array[j]);
                    if (difference % 2 == 0) {
                        odd = false;
                    }
                }
            }
            if (odd) {
                out.println(i + 1);
                System.exit(0);
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