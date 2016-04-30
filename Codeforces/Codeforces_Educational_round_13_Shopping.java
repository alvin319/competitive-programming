import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/29/16.
 */

public class Codeforces_Educational_round_13_Shopping {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            list.addLast(input.nextInt());
        }
        long total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int item = input.nextInt();
                total += list.indexOf(item)  + 1;
                list.remove(new Integer(item));
                list.addFirst(item);
            }
        }
        out.println(total);

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