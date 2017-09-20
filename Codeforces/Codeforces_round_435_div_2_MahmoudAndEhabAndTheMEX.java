import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Codeforces_round_435_div_2_MahmoudAndEhabAndTheMEX {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int x = input.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(input.nextInt());
        }
        int count = 0;
        if (set.contains(x)) {
            set.remove(x);
            count++;
        }
        for (int i = 0; i < x; i++) {
            if (!set.contains(i)) {
                count++;
                set.add(i);
            }
        }
        int answer = -1;
        for (int i = 0; i <= x; i++) {
            if (!set.contains(i)) {
                answer = i;
                break;
            }
        }
        if (answer == x) {
            out.println(count);
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

