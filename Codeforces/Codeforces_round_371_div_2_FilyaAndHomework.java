import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 9/13/16.
 */

public class Codeforces_round_371_div_2_FilyaAndHomework {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] A = new int[input.nextInt()];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            A[i] = input.nextInt();
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
            set.add(A[i]);
        }
        if (A.length == 2 || set.size() == 2) {
            out.println("YES");
        } else {
            int midPoint = (max + min) / 2;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                int dist = Math.abs(midPoint - A[i]);
                if (dist != 0) {
                    map.put(dist, map.containsKey(dist) ? map.get(dist) + 1 : 1);
                }
            }
            out.println(map.keySet().size() <= 1 ? "YES" : "NO");
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