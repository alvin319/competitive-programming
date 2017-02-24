/**
 * Created by qicodeng on 2/23/17.
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Codeforces_round_400_div_2_MollysChemicals {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        int k = input.nextInt();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        long[] prefix = new long[array.length];
        prefix[0] = array[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + array[i];
        }
        long answer = 0;
        long upperBound = (long)(Math.pow(10, 14));
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        if (k == 1 || k == -1) {
            upperBound = 1;
        }
        for (int i = 0; i < prefix.length; i++) {
            int iteration = 0;
            for (long j = 1; j <= upperBound; j *= k) {
                long remainValue = prefix[i] - j;
                if (map.containsKey(remainValue)) {
                    answer += map.get(remainValue);
                }
                iteration++;
                if (k == 1 && iteration == 1) {
                    break;
                }
                if (k == -1 && iteration == 2) {
                    break;
                }
            }
            map.put(prefix[i], map.containsKey(prefix[i]) ? map.get(prefix[i]) + 1 : 1);
        }
        out.println(answer);
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