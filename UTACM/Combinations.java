import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Combinations {

    static HashMap<Long, Long> map = new HashMap<Long, Long>();
    static HashMap<Long, Long> prefix = new HashMap<>();

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            long n = input.nextLong();
            long answer = getStairs(n);
            answer %= 1000000007;
            out.println(answer);
            prefix.clear();
            map.clear();
        }
        out.close();
    }

    public static long getStairs(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            map.put(0L, 1L);
            prefix.put(n, 1L);
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        long answer = 0;
        if (map.containsKey(n - 1)) {
            answer += map.get(n - 1);
        } else {
            answer += getStairs(n - 1);
        }
        answer %= 1000000007;
        if (map.containsKey(n - 2)) {
            answer += map.get(n - 2);
        } else {
            answer += getStairs(n - 2);
        }
        answer %= 1000000007;
        answer += prefix.get(n - 1);
        answer %= 1000000007;
        prefix.put(n, (prefix.get(n - 1) + answer) % 1000000007);
        map.put(n, answer);
        return answer;
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