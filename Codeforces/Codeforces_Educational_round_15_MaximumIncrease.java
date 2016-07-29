import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/30/2016.
 */

public class Codeforces_Educational_round_15_MaximumIncrease {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int maxLength = 1;
        int currentLength = 1;
        int currentValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > currentValue) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            currentValue = array[i];
            maxLength = Math.max(currentLength, maxLength);
        }
        out.println(maxLength);
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

