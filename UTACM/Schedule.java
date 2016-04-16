import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/15/16.
 */

public class Schedule {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long count = input.nextLong();
        for (int i = 0; i < count; i++) {
            long cases = input.nextLong();
            Interval[] list = new Interval[(int)cases];
            for (int j = 0; j < cases; j++) {
                long start = input.nextLong();
                long duration = input.nextLong();
                list[j] = new Interval(start, start + duration);
            }
            Arrays.sort(list, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return new Long(o1.end).compareTo(o2.end);
                }
            });
            long maximum = 1;
            long previousEnd = list[0].end;
            for (int j = 1; j < list.length; j++) {
                Interval current = list[j];
                if(current.start >= previousEnd) {
                    maximum++;
                    previousEnd = current.end;
                }
            }
            out.println(maximum);
        }
        out.close();
    }

    public static class Interval {
        long start;
        long end;
        public Interval(long start, long end) {
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