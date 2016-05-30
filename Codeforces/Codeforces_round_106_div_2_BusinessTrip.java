import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/30/2016.
 */

public class Codeforces_round_106_div_2_BusinessTrip {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int k = input.nextInt();
        Integer[] months = new Integer[12];
        for (int i = 0; i < months.length; i++) {
            months[i] = input.nextInt();
        }
        Arrays.sort(months, Collections.reverseOrder());
        int total = 0;
        int count = 0;
        if(k == 0) {
            System.out.println(0);
        } else {
            for (int i = 0; i < months.length; i++) {
                total += months[i];
                if (total < k) {
                    count++;
                } else {
                    count++;
                    System.out.println(count);
                    System.exit(0);
                }
            }
            if(total < k) {
                System.out.println(-1);
            }
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

