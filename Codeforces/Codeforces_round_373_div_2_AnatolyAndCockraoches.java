/**
 * Created by qicodeng on 9/28/16.
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforces_round_373_div_2_AnatolyAndCockraoches {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        char[] array = input.nextLine().toCharArray();
        char[] firstIter = new char[count];
        char[] secondIter = new char[count];
        char c = 'b';
        for (int i = 0; i < firstIter.length; i++) {
            firstIter[i] = c;
            c = c == 'b' ? 'r' : 'b';
        }
        c = 'r';
        for (int i = 0; i < secondIter.length; i++) {
            secondIter[i] = c;
            c = c == 'b' ? 'r' : 'b';
        }
        int rC = 0;
        int bC = 0;
        for (int i = 0; i < firstIter.length; i++) {
            if (array[i] != firstIter[i]) {
                rC += array[i] == 'r' ? 1 : 0;
                bC += array[i] == 'b' ? 1 : 0;
            }
        }
        int fICost = Math.min(rC, bC) + (Math.max(rC, bC) - Math.min(rC, bC));
        rC = 0;
        bC = 0;
        for (int i = 0; i < secondIter.length; i++) {
            if (array[i] != secondIter[i]) {
                rC += array[i] == 'r' ? 1 : 0;
                bC += array[i] == 'b' ? 1 : 0;
            }
        }
        int sICost = Math.min(rC, bC) + (Math.max(rC, bC) - Math.min(rC, bC));
        out.println(Math.min(fICost, sICost));
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
