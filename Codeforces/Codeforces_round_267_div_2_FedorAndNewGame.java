import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/18/2016.
 */

public class Codeforces_round_267_div_2_FedorAndNewGame {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        String[] array = new String[m + 1];
        for (int i = 0; i <= m; i++) {
            array[i] = input.nextLine();
        }
        int answer = 0;
        String checking = array[array.length - 1];
        for (int i = 0; i < m; i++) {
            String binaryResult = new BigInteger(array[i]).xor(new BigInteger(checking)).toString(2);   
            int count = 0;
            boolean nope = true;
            for (int j = 0; j < binaryResult.length(); j++) {
                count += binaryResult.charAt(j) == '1' ? 1 : 0;
                if (count > k) {
                    nope = false;
                    break;
                }
            }
            if (nope) {
                answer++;
            }
        }
        out.println(answer);
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

