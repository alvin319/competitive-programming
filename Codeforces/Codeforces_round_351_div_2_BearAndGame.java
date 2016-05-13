import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/12/16.
 */

public class Codeforces_round_351_div_2_BearAndGame {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int minutes = input.nextInt();
        int[] array = new int[minutes];
        for (int i = 0; i < minutes; i++) {
            array[i] = input.nextInt();
        }
        if (array[0] <= 15 && minutes == 1) {
            out.println(array[0] + 15);
        } else if(array[0] > 15) {
            out.println(15);
        } else {
            int total = -1;
            for (int i = 1; i < minutes; i++) {
                int previous = array[i - 1];
                int current = array[i];
                if(previous + 15 < current) {
                    total = previous + 15;
                    break;
                }
            }
            if(total == -1) {
                out.println(Math.min(90, array[array.length - 1] + 15));
            } else {
                out.println(total);
            }
        }
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