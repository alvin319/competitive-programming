import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/25/16.
 */

public class Codeforces_round_163_div_2_StonesOnTheTable {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        char[] array = input.nextLine().toCharArray();
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            int currentChar = array[i];
            int next = i + 1;
            int count = 1;
            while (next < array.length && array[next] == currentChar) {
                count++;
                next++;
            }
            answer += count - 1;
            i = next - 1;
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