import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/26/16.
 */

public class Codeforces_Educational_round_5_ComparingTwoLongIntegers {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String first = input.nextLine().replaceFirst("^0+(?!$)", "");
        String second = input.nextLine().replaceFirst("^0+(?!$)", "");
        if(first.length() > second.length()) {
            System.out.println(">");
            System.exit(0);
        } else if(first.length() < second.length()) {
            System.out.printf("<");
            System.exit(0);
        } else {
            for (int i = 0; i < first.length(); i++) {
                char a = first.charAt(i);
                char b = second.charAt(i);
                if(a == b) {
                    continue;
                } else if(a > b) {
                    System.out.println(">");
                    System.exit(0);
                } else {
                    System.out.println("<");
                    System.exit(0);
                }
            }
        }
        System.out.println("=");
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