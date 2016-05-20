import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/19/2016.
 */

public class Codeforces_round_343_div_2_FarRelativesProblem {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] boys = new int[366];
        int[] girls = new int[366];
        int friends = input.nextInt();
        for (int i = 0; i < friends; i++) {
            String[] current = input.nextLine().split(" ");
            int start = Integer.parseInt(current[1]) - 1;
            int end = Integer.parseInt(current[2]) - 1;
            if(current[0].charAt(0) == 'M') {
                for (int j = start; j <= end; j++) {
                    boys[j]++;
                }
            } else {
                for (int j = start; j <= end; j++) {
                    girls[j]++;
                }
            }
        }
        int maximum = -1;
        for (int i = 0; i < 366; i++) {
            maximum = Math.max(maximum, 2 * Math.min(boys[i], girls[i]));
        }
        out.println(maximum);
        out.close();
    }

    static class Friend {
        char gender;
        int start;
        int end;

        public Friend(char g, int s, int e) {
            gender = g;
            start = s;
            end = e;
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

