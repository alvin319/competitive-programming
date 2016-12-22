import java.io.*;
import java.util.*;

/**
 * Created by WiNDWAY on 12/22/16.
 */

public class Codeforces_round_388_div_2_Voting {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        char[] info = input.nextLine().toCharArray();
        Queue<Integer> dQueue = new LinkedList<>();
        Queue<Integer> rQueue = new LinkedList<>();
        for (int i = 0; i < info.length; i++) {
            if (info[i] == 'D') {
                dQueue.add(i);
            } else {
                rQueue.add(i);
            }
        }
        while (!dQueue.isEmpty() && !rQueue.isEmpty()) {
            int d = dQueue.peek();
            int r = rQueue.peek();
            if (d < r) {
                dQueue.add(d + n);
            } else {
                rQueue.add(r + n);
            }
            rQueue.poll();
            dQueue.poll();
        }
        out.println(dQueue.isEmpty() ? 'R' : 'D');
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