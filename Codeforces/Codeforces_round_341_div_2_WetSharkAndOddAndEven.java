import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/26/16.
 */

public class Codeforces_round_341_div_2_WetSharkAndOddAndEven {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        BigInteger solution = BigInteger.ZERO;
        long[] number = new long[input.nextInt()];
        for (int i = 0; i < number.length; i++) {
            number[i] = input.nextLong();
            solution = solution.add(BigInteger.valueOf(number[i]));
        }
        if(solution.mod(BigInteger.ONE.add(BigInteger.ONE)).equals(BigInteger.ZERO)) {
            out.println(solution.toString());
        } else {
            Arrays.sort(number);
            for (int i = 0; i < number.length; i++) {
                if(number[i] % 2 == 1) {
                    solution = solution.subtract(BigInteger.valueOf(number[i]));
                    if (solution.mod(BigInteger.ONE.add(BigInteger.ONE)).equals(BigInteger.ZERO)) {
                        out.println(solution.toString());
                        System.exit(0);
                    }
                }
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