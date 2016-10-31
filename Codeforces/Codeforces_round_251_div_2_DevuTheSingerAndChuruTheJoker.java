import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 10/30/16.
 */

public class Codeforces_round_251_div_2_DevuTheSingerAndChuruTheJoker {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int d = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        Arrays.sort(array);
        int required = 0;
        for (int i = 0; i < array.length; i++) {
            required += i == array.length - 1 ? array[i] : array[i] + 10;
        }
        if (required > d) {
            out.println(-1);
        } else {
            int freeTime = ((array.length - 1) * 10) / 5;
            int remain = d - required;
            out.println(freeTime + remain / 5);
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