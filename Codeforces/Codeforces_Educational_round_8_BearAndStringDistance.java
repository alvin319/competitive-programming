import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 4/17/2016.
 */

public class Codeforces_Educational_round_8_BearAndStringDistance {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int req = input.nextInt();
        StringBuilder check = new StringBuilder(input.nextLine());
        int index = 0;
        while (req > 0 && index < check.length()) {
            int zDiff = Math.abs('z' - check.charAt(index));
            int aDiff = Math.abs(check.charAt(index) - 'a');
            if (zDiff > aDiff) {
                if (zDiff > req) {
                    check.setCharAt(index, (char) ((int) check.charAt(index) + req));
                    req = 0;
                } else {
                    check.setCharAt(index, (char) ((int) check.charAt(index) + zDiff));
                    req -= zDiff;
                }
            } else {
                if (aDiff > req) {
                    check.setCharAt(index, (char) ((int) check.charAt(index) - req));
                    req = 0;
                } else {
                    check.setCharAt(index, (char) ((int) check.charAt(index) - aDiff));
                    req -= aDiff;
                }
            }
            index++;
        }
        if(req == 0) {
            out.println(check);
        } else {
            out.println(-1);
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

