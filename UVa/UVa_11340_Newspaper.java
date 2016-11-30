import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 9/11/16.
 */

public class UVa_11340_Newspaper {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int N = input.nextInt();
        for (int i = 0; i < N; i++) {
            int K = input.nextInt();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < K; j++) {
                String[] array = input.nextLine().split(" ");
                map.put(array[0].charAt(0), Integer.parseInt(array[1]));
            }
            int M = input.nextInt();
            long totalCost = 0;
            for (int j = 0; j < M; j++) {
                String line = input.nextLine();
                for (int k = 0; k < line.length(); k++) {
                    char currentChar = line.charAt(k);
                    totalCost += map.containsKey(currentChar) ? map.get(currentChar) : 0;
                }
            }
            out.printf(Locale.ENGLISH, "%.2f$%n", (double) totalCost / 100.0);
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