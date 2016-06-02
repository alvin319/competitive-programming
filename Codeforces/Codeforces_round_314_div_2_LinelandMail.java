import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 6/1/16.
 */

public class Codeforces_round_314_div_2_LinelandMail {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        long[] array = new long[count];
        for (int i = 0; i < count; i++) {
            array[i] = input.nextLong();
        }
        for (int i = 0; i < array.length; i++) {
            if(i == 0) {
                out.println(Math.abs(array[i] - array[1]) + " " + Math.abs(array[i] - array[array.length - 1]));
            } else if(i == array.length - 1) {
                out.println(Math.abs(array[i] - array[i - 1]) + " " + Math.abs(array[i] - array[0]));
            } else {
                out.println(Math.min(Math.abs(array[i] - array[i - 1]), Math.abs(array[i] - array[i + 1])) + " " +
                        Math.max(Math.abs(array[i] - array[0]), Math.abs(array[i] - array[array.length - 1])));
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