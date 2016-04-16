import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * Created by WiNDWAY on 4/11/16.
 */

public class Codeforces_round_344_div_2_Report {
    public static void main(String[] args) {
        FScanner in = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] r = new int[m];
        int[] t = new int[m];
        int[] suffixR = new int[m + 1];
        suffixR[m] = -1;

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 0; i < m; i++) {
            t[i] = in.nextInt();
            r[i] = in.nextInt() - 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            suffixR[i] = Math.max(suffixR[i + 1], r[i]);
        }

        int[] b = new int[suffixR[0] + 1];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];
        }

        Arrays.sort(b);
        int left = 0;
        int right = b.length - 1;

        for (int i = 0; i < m; i++) {
            if (r[i] <= suffixR[i + 1]) {
                continue;
            } else if (t[i] == 1) {
                for (int k = r[i]; k > suffixR[i + 1]; k--) {
                    a[k] = b[right];
                    right--;
                }
            } else {
                for (int k = r[i]; k > suffixR[i + 1]; k--) {
                    a[k] = b[left];
                    left++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(a[i] + " ");
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