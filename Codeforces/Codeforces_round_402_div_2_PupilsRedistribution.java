import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Codeforces_round_402_div_2_PupilsRedistribution {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int[] first = new int[n];
        int[] second = new int[n];
        HashMap<Integer, Integer> m = new HashMap<>();
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i < first.length; i++) {
            first[i] = input.nextInt();
            m.put(first[i], m.containsKey(first[i]) ? m.get(first[i]) + 1 : 1);
            f.put(first[i], f.containsKey(first[i]) ? f.get(first[i]) + 1 : 1);
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = input.nextInt();
            m.put(second[i], m.containsKey(second[i]) ? m.get(second[i]) + 1 : 1);
        }
        for (int k : m.keySet()) {
            if (m.get(k) % 2 == 1) {
                out.println(-1);
                System.exit(0);
            }
        }
        int answer = 0;
        Arrays.sort(first);
        Arrays.sort(second);
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                if (!f.containsKey(second[i])) {
                    f.put(second[i], 1);
                    answer++;
                } else {
                    if (f.get(second[i]) < m.get(second[i]) / 2) {
                        answer++;
                        f.put(second[i], f.get(second[i]) + 1);
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