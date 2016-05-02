import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/2/16.
 */

public class Codeforces_round_305_div_2_MikeAndFun {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        int q = input.nextInt();
        int[][] bears = new int[n][m];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bears[i][j] = input.nextInt();
            }
            map.put(i, consec(bears[i]));
        }

        for (int i = 0; i < q; i++) {
            int max = 0;
            int r = input.nextInt() - 1;
            int c = input.nextInt() - 1;
            bears[r][c] = bears[r][c] == 0 ? 1 : 0;
            map.put(r, consec(bears[r]));
            for(int x : map.keySet()) {
                max = Math.max(map.get(x), max);
            }
            out.println(max);
        }
        out.close();
    }

    public static int consec(int[] bears) {
        int maxSum = 0;
        int currentSum = 0;
        for (int i = 0; i < bears.length; i++) {
            int current = bears[i];
            if(current == 1) {
                currentSum++;
                maxSum = Math.max(currentSum, maxSum);
            } else {
                currentSum = 0;
            }
        }
        return maxSum;
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