import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class KEmptySlots {
    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] flowers = new int[]{6, 5, 8, 9, 7, 1, 10, 2, 3, 4};
        int k = 2;
        out.println(kEmptySlots(flowers, k));
        out.close();
    }

    public static int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int location = flowers[i];
            set.add(location);
            Integer below = set.lower(location);
            Integer above = set.higher(location);
            if (below != null) {
                int belowDiff = Math.abs(location - below - 1);
                if (belowDiff == k) {
                    return i + 1;
                }
            }
            if (above != null) {
                int aboveDiff = Math.abs(above - location - 1);
                if (aboveDiff == k) {
                    return i + 1;
                }
            }
        }
        return -1;
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

