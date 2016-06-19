import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 6/20/16.
 */

public class Codeforces_round_261_div_2_PashmakAndFlowers {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        long[] array = new long[n];
        HashMap<Long, Long> countMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextLong();
            countMap.put(array[i], countMap.containsKey(array[i]) ? countMap.get(array[i]) + 1 : 1);
        }
        Arrays.sort(array);
        long smallCount = countMap.get(array[0]);
        long bigCount = countMap.get(array[array.length - 1]);
        long longVer = (long) array.length;
        if (countMap.containsValue((long) array.length)) {
            out.println("0 " + longVer * (longVer - 1) / 2);
        } else {
            out.println(array[array.length - 1] - array[0] + " " + smallCount * bigCount);
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