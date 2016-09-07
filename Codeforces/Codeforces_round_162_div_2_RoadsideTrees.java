import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 9/7/16.
 */

public class Codeforces_round_162_div_2_RoadsideTrees {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        long total = array[0];
        total += 1;
        long currentLevel = array[0];
        for (int i = 1; i < array.length; i++) {
            long minHeight = Math.min(currentLevel, array[i]);
            total += Math.abs(currentLevel - minHeight) + 1;
            currentLevel = minHeight;
            total += Math.abs(array[i] - currentLevel) + 1;
            currentLevel = array[i];
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