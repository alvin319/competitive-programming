import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/10/16.
 */

public class Codeforces_round_340_div_2_Elephant {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int hello = input.nextInt();
        int[] steps = new int[hello + 1];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;
        for (int i = 1; i <= hello; i++) {
            if(i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                steps[i] = 1;
            } else {
                if(i - 1 >= 0) {
                    steps[i] = Math.min(steps[i], 1 + steps[i - 1]);
                }
                if(i - 2 >= 0) {
                    steps[i] = Math.min(steps[i], 1 + steps[i - 2]);
                }
                if(i - 3 >= 0) {
                    steps[i] = Math.min(steps[i], 1 + steps[i - 3]);
                }
                if(i - 4 >= 0) {
                    steps[i] = Math.min(steps[i], 1 + steps[i - 4]);
                }
                if(i - 5 >= 0) {
                    steps[i] = Math.min(steps[i], 1 + steps[i - 5]);
                }
            }
        }
        out.println(steps[hello]);
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