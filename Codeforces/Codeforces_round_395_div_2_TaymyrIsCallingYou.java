import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 2/3/2017.
 */

public class Codeforces_round_395_div_2_TaymyrIsCallingYou {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] array = new int[input.nextInt()];
        for (int i = n - 1; i < array.length; i += n) {
            array[i] += 1;
        }
        for (int i = m - 1; i < array.length; i += m) {
            array[i] += 1;
        }
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 2) {
                answer++;
            }
        }
        out.println(answer);
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

