import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/30/2016.
 */

public class Codeforces_round_149_div_2_BigSegment {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        Pair[] array = new Pair[count];
        HashMap<Pair, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            array[i] = new Pair(input.nextInt(), input.nextInt());
            indexMap.put(array[i], i);
        }
        Arrays.sort(array, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return -1 * new Integer(o1.end - o1.start).compareTo(o2.end - o2.start);
            }
        });
        Pair bestPair = array[0];
        for (int i = 1; i < array.length; i++) {
            Pair cp = array[i];
            boolean valid = bestPair.start <= cp.start && bestPair.end >= cp.end;
            if (!valid) {
                out.println("-1");
                System.exit(0);
            }
        }
        out.println(indexMap.get(bestPair) + 1);
        out.close();
    }

    public static class Pair {
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

