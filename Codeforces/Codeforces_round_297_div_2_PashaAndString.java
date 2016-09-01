import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 9/1/16.
 */

public class Codeforces_round_297_div_2_PashaAndString {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuilder current = new StringBuilder(input.nextLine());
        int[] reverse = new int[current.length()];
        int days = input.nextInt();
        for (int i = 0; i < days; i++) {
            int index = input.nextInt() - 1;
            reverse[index]++;
        }
        int count = 0;
        for (int i = 0; i < reverse.length / 2; i++) {
            count += reverse[i];
            if (count % 2 == 1) {
                char currentChar = current.charAt(i);
                current.setCharAt(i, current.charAt(current.length() - i - 1));
                current.setCharAt(current.length() - i - 1, currentChar);
            }
        }
        out.println(current);
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