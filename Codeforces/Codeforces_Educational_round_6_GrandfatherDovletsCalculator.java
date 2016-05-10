import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/8/2016.
 */

public class Codeforces_Educational_round_6_GrandfatherDovletsCalculator {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String[] number = input.nextLine().split(" ");
        int[] translate = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        long total = 0;
        for (Integer i = i(number[0]); i <= i(number[1]); i++) {
            for (int j = 0; j < i.toString().length(); j++) {
                total += translate[i.toString().charAt(j) - '0'];
            }
        }
        out.println(total);
        out.close();
    }

    public static int i(String a) {
        return Integer.parseInt(a);
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

