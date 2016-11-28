import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/28/16.
 */

public class Codeforces_round_381_div_2_AlyonaAndFlowers {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        int segment = input.nextInt();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        long answer = 0;
        for (int i = 0; i < segment; i++) {
            int start = input.nextInt() - 1;
            int end = input.nextInt() - 1;
            long currentTotal = 0;
            for (int j = start; j <= end; j++) {
                currentTotal += array[j];
            }
            if (currentTotal > 0) {
                answer += currentTotal;
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