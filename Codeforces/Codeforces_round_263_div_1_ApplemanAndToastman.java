import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 9/22/16.
 */

public class Codeforces_round_263_div_1_ApplemanAndToastman {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long[] array = new long[input.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextLong();
        }
        Arrays.sort(array);
        long sum = 0;
        long[] postFix = new long[array.length];
        long current = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            current += array[i];
            postFix[i] = current;
        }
        for (int i = 0; i < postFix.length; i++) {
            sum += postFix[i];
        }
        for (int i = 0; i < array.length - 1; i++) {
            sum += array[i];
        }
        out.println(sum);
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