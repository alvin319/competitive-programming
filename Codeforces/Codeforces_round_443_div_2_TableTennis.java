import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Codeforces_round_443_div_2_TableTennis {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        long k = input.nextLong();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            int win = 0;
            if (i - 1 >= 0 && array[i] > array[i - 1]) {
                win++;
            }
            while (j >= 0) {
                if (j == array.length) {
                    j = 0;
                }
                if (win >= k || i == j) {
                    out.println(array[i]);
                    System.exit(0);
                }
                if (array[i] > array[j]) {
                    win++;
                } else {
                    break;
                }
                j++;
            }
        }
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