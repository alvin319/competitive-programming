import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/5/2016.
 */

public class Codeforces_round_ff_div_2_DZYLovesString {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String current = input.nextLine();
        int k = input.nextInt();
        int[] array = new int[26];
        for (int i = 0; i < 26; i++) {
            array[i] = input.nextInt();
        }
        int total = 0;
        int currentCounter = 1;
        for (int i = 0; i < current.length(); i++) {
            total += currentCounter * array[current.charAt(i) - 'a'];
            currentCounter++;
        }
        Arrays.sort(array);
        for (int i = 1; i <= k; i++) {
            total += currentCounter * array[array.length - 1];
            currentCounter++;
        }
        out.println(total);
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

