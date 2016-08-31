import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 8/31/16.
 */

public class Codeforces_round_356_div_2_BearAndFindingCriminals {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        int index = input.nextInt() - 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int maxDist = Math.max(Math.abs(0 - index), Math.abs(array.length - index - 1));
        int answer = 0;
        if (array[index] == 1) {
            answer++;
        }
        for (int i = 1; i <= maxDist; i++) {
            int leftIndex = index - i;
            int rightIndex = index + i;
            if (leftIndex >= 0 && rightIndex >= array.length) {
                if (array[leftIndex] == 1) {
                    answer++;
                }
            } else if (leftIndex >= 0 && rightIndex < array.length) {
                if (array[leftIndex] == 1 && array[rightIndex] == 1) {
                    answer += 2;
                }
            } else if (rightIndex < array.length && leftIndex < 0) {
                if (array[rightIndex] == 1) {
                    answer++;
                }
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