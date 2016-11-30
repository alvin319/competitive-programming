import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Created by WiNDWAY on 5/13/16.
 */

public class Candies {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        int[] leftCandies = new int[array.length];
        int[] rightCandies = new int[array.length];
        Arrays.fill(leftCandies, 1);
        Arrays.fill(rightCandies, 1);

        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        for (int i = 1; i < leftCandies.length; i++) {
            if (array[i] > array[i - 1]) {
                leftCandies[i] = leftCandies[i - 1] + 1;
            }
        }

        for (int i = rightCandies.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1]) {
                rightCandies[i] = rightCandies[i + 1] + 1;
            }
        }
        long sum = 0;
        for (int i = 0; i < leftCandies.length; i++) {
            sum += Math.max(leftCandies[i], rightCandies[i]);
        }
        out.println(sum);
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