import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/25/16.
 */

public class Codeforces_round_96_div_2_HQ9Plus {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        char[] array = input.nextLine().toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add('H');
        set.add('Q');
        set.add('9');
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                out.println("YES");
                System.exit(0);
            }
        }
        out.println("NO");
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