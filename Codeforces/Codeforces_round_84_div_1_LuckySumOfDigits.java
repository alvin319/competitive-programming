import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by alvin on 6/5/16.
 */
public class Codeforces_round_84_div_1_LuckySumOfDigits {

    static ArrayList<String> list;
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int digitsSum = input.nextInt();
        int count4 = -1;
        int count7 = -1;
        for (int i = digitsSum / 4; i >= 0; i--) {
            int remain = digitsSum - (i * 7);
            if(remain >= 0 && remain % 4 == 0) {
                count4 = remain / 4;
                count7 = i;
                break;
            }
        }
        if(count4 == -1 && count7 == -1) {
            out.println(-1);
        } else {
            StringBuilder current = new StringBuilder();
            for (int i = 0; i < count4; i++) {
                current.append('4');
            }
            for (int i = 0; i < count7; i++) {
                current.append('7');
            }
            out.println(current.toString());
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
