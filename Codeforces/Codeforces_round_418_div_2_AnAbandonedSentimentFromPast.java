import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 6/17/17.
 */

public class Codeforces_round_418_div_2_AnAbandonedSentimentFromPast {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextInt();
        }
        int[] b = new int[k];
        for (int i = 0; i < b.length; i++) {
            b[i] = input.nextInt();
        }
        Arrays.sort(b);
        boolean lessThan = true;
        int sum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            int current = a[i];
            int next = a[i + 1];
            if (current != 0 && current > next) {
                lessThan = false;
            }
            sum += current;
        }
        if (!lessThan || sum == 0) {
            int lastIndex = b.length - 1;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 0 && lastIndex >= 0) {
                    a[i] = b[lastIndex];
                    lastIndex--;
                }
            }
        } else {
            int index = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 0 && index < b.length) {
                    a[i] = b[index];
                    index++;
                }
            }
        }
        for (int i = 0; i < a.length - 1; i++) {
            int current = a[i];
            int next = a[i + 1];
            if (current > next) {
                out.println("Yes");
                System.exit(0);
            }
        }
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] != a[i + 1]) {
                out.println("No");
                System.exit(0);
            }
        }
        out.println("Yes");
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