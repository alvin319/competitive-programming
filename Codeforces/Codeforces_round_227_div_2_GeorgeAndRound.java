import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created by alvin on 8/16/16.
 */
public class Codeforces_round_227_div_2_GeorgeAndRound {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] array = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int current = input.nextInt();
            map.put(current, map.containsKey(current) ? map.get(current) + 1 : 1);
        }
        for (int i = 0; i < n; i++) {
            int currentNeed = array[i];
            if (!map.containsKey(currentNeed)) {
                Integer higher = map.ceilingKey(currentNeed);
                if (higher == null) {
                    answer++;
                } else {
                    int currentCount = map.get(higher);
                    currentCount--;
                    if (currentCount == 0) {
                        map.remove(higher);
                    } else {
                        map.put(higher, currentCount);
                    }
                }
            }
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
