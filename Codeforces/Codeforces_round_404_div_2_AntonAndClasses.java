import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Codeforces_round_404_div_2_AntonAndClasses {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        Range[] f = new Range[n];
        for (int i = 0; i < n; i++) {
            f[i] = new Range(input.nextInt(), input.nextInt());
        }
        int m = input.nextInt();
        Range[] s = new Range[m];
        for (int i = 0; i < m; i++) {
            s[i] = new Range(input.nextInt(), input.nextInt());
        }
        Arrays.sort(f, new Comparator<Range>() {
            @Override
            public int compare(Range o1, Range o2) {
                return new Integer(o1.e).compareTo(o2.e);
            }
        });
        Arrays.sort(s, new Comparator<Range>() {
            @Override
            public int compare(Range o1, Range o2) {
                return -1 * new Integer(o1.s).compareTo(o2.s);
            }
        });
        int result = s[0].s - f[0].e;
        Arrays.sort(s, new Comparator<Range>() {
            @Override
            public int compare(Range o1, Range o2) {
                return new Integer(o1.e).compareTo(o2.e);
            }
        });
        Arrays.sort(f, new Comparator<Range>() {
            @Override
            public int compare(Range o1, Range o2) {
                return -1 * new Integer(o1.s).compareTo(o2.s);
            }
        });
        int result2 = f[0].s - s[0].e;
        out.println(Math.max(0, Math.max(result, result2)));
        out.close();
    }

    static class Range {
        int s;
        int e;

        public Range(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public String toString() {
            return s + " " + e;
        }
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