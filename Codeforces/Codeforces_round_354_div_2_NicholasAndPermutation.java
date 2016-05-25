import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/25/16.
 */

public class Codeforces_round_354_div_2_NicholasAndPermutation {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        int smallIndex = -1;
        int bigIndex = -1;
        for(int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
            if(array[i] == 1) {
                smallIndex = i;
            } else if(array[i] == array.length) {
                bigIndex = i;
            }
        }
        int first = array.length - 1 - smallIndex;
        int second = smallIndex;
        int third = array.length - 1 - bigIndex;
        int fourth = bigIndex;
        out.println(Math.max(first, Math.max(second, Math.max(third, fourth))));
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
