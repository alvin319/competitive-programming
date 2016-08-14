import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by alvin on 8/14/16.
 */
public class Codeforces_round_271_div_2_Worms {

    static Pair[] array;

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        array = new Pair[input.nextInt()];
        int startRange = 0;
        int endRange = input.nextInt() - 1;
        array[0] = new Pair(startRange, endRange);
        startRange = endRange + 1;
        for (int i = 1; i < array.length; i++) {
            int currentEnd = input.nextInt() - 1;
            endRange = startRange + currentEnd;
            array[i] = new Pair(startRange, endRange);
            startRange = endRange + 1;
        }
        int q = input.nextInt();
        for (int i = 0; i < q; i++) {
            int find = input.nextInt() - 1;
            out.println(binarySearch(find, 0, array.length) + 1);
        }
        out.close();
    }

    public static int binarySearch(int find, int start, int end) {
        int mid = (start + end) / 2;
        if (array[mid].start <= find && array[mid].end >= find) {
            return mid;
        } else if (array[mid].start >= find) {
            return binarySearch(find, start, mid);
        }
        return binarySearch(find, mid, end);
    }

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
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