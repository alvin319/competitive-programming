import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 3/26/2017.
 */

public class Codeforces_round_141_div_2_IsYourHorseshoeOnTheOtherRoof {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        HashSet<String> set = new HashSet<>();
        String[] array = input.nextLine().split(" ");
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        out.println(4 - set.size());
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

