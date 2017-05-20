import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by alvindeng on 5/23/17.
 */
public class Codeforces_round_415_div_2_StraightA {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        double k = input.nextDouble();
        k -= 0.5;
        int[] array = new int[n];
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
            total += array[i];
        }
        double average = total / array.length;
        if (average == k) {
            out.println(0);
        } else {
            out.println(Math.max(0, (int)((k * array.length - total) / 0.5)));
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
