import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/28/16.
 */

public class Codeforces_round_333_div_2_ApproximatingAConstantRange {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int size = input.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int maxLength = 0;
        int maxStart = 0;
        int maxEnd = 0;

        int currentLength = 0;
        int currentLowest = Integer.MAX_VALUE;
        int currentHighest = -1;

        int currentStart = 0;
        int currentEnd = 0;
        for (int i = 0; i < array.length; i++) {
            int currentValue = array[i];
            currentLowest = Math.min(currentLowest, currentValue);
            currentHighest = Math.max(currentHighest, currentValue);
            currentEnd = i;
            if(currentHighest - currentLowest >= 2) {
                i--;
                currentStart = i;
                currentLowest = currentValue;
                currentHighest = currentValue;
                currentLength = 1;
            } else {
                currentLength++;
                if(currentLength >= maxLength) {
                    maxStart = currentStart;
                    maxEnd = currentEnd;
                    maxLength = currentLength;
                }
            }
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