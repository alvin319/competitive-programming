import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by alvindeng on 1/19/2017.
 */

public class Codeforces_round_391_div_2_BashBigDay {
    public static void main(String[] args) throws IOException {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
            map.put(array[i], map.containsKey(array[i]) ? map.get(array[i]) + 1 : 1);
        }
        boolean[] sieve = getSieve(100000);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                set.add(i);
            }
        }
        int answer = 0;
        for (int check : set) {
            int current = 0;
            for (int i = check; i <= 100000; i += check) {
                if (map.containsKey(i)) {
                    current += map.get(i);
                }
            }
            answer = Math.max(answer, current);
        }
        out.println(Math.max(answer, 1));
        out.close();
    }

    static boolean[] getSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int factor = 2; factor * factor <= n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor; factor * j <= n; j++) {
                    isPrime[factor * j] = false;
                }
            }
        }

        return isPrime;
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

