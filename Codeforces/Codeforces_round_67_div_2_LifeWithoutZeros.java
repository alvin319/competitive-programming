import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/12/2016.
 */

public class Codeforces_round_67_div_2_LifeWithoutZeros {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String first = input.nextLine();
        String second = input.nextLine();
        String result = new BigInteger(first).add(new BigInteger(second)).toString();
        StringBuilder compareResult = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            compareResult = compareResult.append(result.charAt(i));
        }
        StringBuilder finalCompare = new StringBuilder();
        for (int i = 0; i < compareResult.length(); i++) {
            if (compareResult.charAt(i) != '0') {
                finalCompare = finalCompare.append(compareResult.charAt(i));
            }
        }

        StringBuilder firstSB = new StringBuilder();
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != '0') {
                firstSB.append(first.charAt(i));
            }
        }
        StringBuilder secondSB = new StringBuilder();
        for (int i = 0; i < second.length(); i++) {
            if (second.charAt(i) != '0') {
                secondSB.append(second.charAt(i));
            }
        }

        String result2 = new BigInteger(firstSB.toString()).add(new BigInteger(secondSB.toString())).toString();
        out.println(result2.equals(finalCompare.toString()) ? "YES" : "NO");
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

