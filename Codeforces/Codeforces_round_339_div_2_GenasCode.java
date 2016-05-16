import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/15/2016.
 */

public class Codeforces_round_339_div_2_GenasCode {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        String specialString = "1";
        long total = 0;
        for (int i = 0; i < n; i++) {
            String current = input.next();
            char[] array = current.toCharArray();
            if(array.length == 1 && array[0] == '0') {
                out.println(0);
                System.exit(0);
            }
            int countOne = 0;
            int countZero = 0;
            int countOthers = 0;
            for (int j = 0; j < array.length; j++) {
                if(array[j] == '1') {
                    countOne++;
                } else if(array[j] == '0') {
                    countZero++;
                } else {
                    countOthers++;
                }
            }
            if(countOne > 1 || countOthers > 0) {
                specialString = current;
            } else {
                total += countZero;
            }
        }
        StringBuilder answer = new StringBuilder(specialString);
        for (int i = 0; i < total; i++) {
            answer = answer.append('0');
        }
        out.println(answer.toString());
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

