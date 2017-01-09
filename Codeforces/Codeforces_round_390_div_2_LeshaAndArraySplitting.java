import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 1/8/2017.
 */

public class Codeforces_round_390_div_2_LeshaAndArraySplitting {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int[] prefix = new int[array.length];
        int current = 0;
        for (int i = 0; i < array.length; i++) {
            current += array[i];
            prefix[i] = current;
        }
        if (current != 0) {
            out.println("YES");
            out.println(1);
            out.println(1 + " " + array.length);
        } else {
            int index = 0;
            for (int i = 0; i < prefix.length; i++) {
                if (prefix[i] != 0) {
                    index = i + 1;
                    break;
                }
            }
            if (index == 0) {
                out.println("NO");
            } else {
                out.println("YES");
                out.println(2);
                out.println(1 + " " + index);
                out.println(index + 1 + " " + array.length);
            }
        }
        out.close();
    }

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return start + " " + end;
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

