import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 8/8/2016.
 */

public class Codeforces_round_213_div_2_GoodNumber {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int k = input.nextInt();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            String current = input.nextLine();
            for (int j = 0; j < current.length(); j++) {
                set.add(current.charAt(j));
            }
            boolean ok = true;
            for (int j = 0; j <= k; j++) {
                if (!set.contains((char)(j + (int)'0'))) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
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

