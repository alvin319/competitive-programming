import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 12/21/2016.
 */

public class Codeforces_round_388_div_2_BachgoldProblem {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0) {
            if (n == 3) {
                n -= 3;
                list.add(3);
            } else if (n > 2) {
                n -= 2;
                list.add(2);
            } else {
                break;
            }
        }
        if (n != 0) {
            list.add(n);
        }
        out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            out.print(i == 0 ? list.get(i) : " " + list.get(i));
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

