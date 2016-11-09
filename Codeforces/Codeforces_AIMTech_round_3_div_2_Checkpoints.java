import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/13/16.
 */

public class Codeforces_AIMTech_round_3_div_2_Checkpoints {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        int current = input.nextInt();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        Arrays.sort(array);
        if (array.length == 1) {
            out.println(0);
        } else if (array.length == 2) {
            out.println(Math.min(Math.abs(current - array[0]), Math.abs(current - array[1])));
        } else if (current <= array[0]) {
            out.println(array[array.length - 2] - current);
        } else if (current >= array[array.length - 1]) {
            out.println(current - array[1]);
        } else {
            int d1 = (current - array[0]) * 2 + array[array.length - 2] - current;
            int d2 = current - array[0] + (array[array.length - 2] - current) * 2;
            int d3 = (array[array.length - 1] - current) * 2 + current - array[1];
            int d4 = array[array.length - 1] - current + (current - array[1]) * 2;
            if (array[0] < current && current <= array[1]) {
                out.println(Math.min(array[array.length - 1] - current, Math.min(d1, d2)));
            } else if (array[array.length - 2] <= current && current < array[array.length - 1]) {
                out.println(Math.min(current - array[0], Math.min(d3, d4)));
            } else {
                out.println(Math.min(Math.min(d1, d2), Math.min(d3, d4)));
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