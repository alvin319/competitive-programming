import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 6/2/16.
 */

public class Codeforces_round_321_div_2_KefaAndFirstSteps {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int maxLength = 0;
        int length = 1;
        int previousNumber = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] >= previousNumber) {
                length++;
            } else {
                maxLength = Math.max(maxLength, length);
                length = 1;
            }
            previousNumber = array[i];
        }
        out.println(Math.max(maxLength, length));
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