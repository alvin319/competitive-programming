import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/30/2016.
 */

public class Codeforces_Educational_round_15_PowerOfTwo {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long[] array = new long[input.nextInt()];
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextLong();
        }
        long[] twoNum = new long[31];
        for (int i = 0; i < twoNum.length; i++) {
            twoNum[i] = (long)Math.pow(2, i + 1);
        }
        long answer = 0;
        for (int i = 0; i < array.length; i++) {
            long current = array[i];
            for (int j = 0; j < twoNum.length; j++) {
                long currentTwo = twoNum[j];
                if (currentTwo - current >= 1) {
                    if (map.containsKey(currentTwo - current)) {
                        answer += map.get(currentTwo - current);
                    }
                }
            }
            map.put(current, map.containsKey(current) ? map.get(current) + 1 : 1);
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