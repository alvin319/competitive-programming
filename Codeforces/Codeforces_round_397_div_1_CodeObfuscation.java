import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Codeforces_round_397_div_1_CodeObfuscation {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String line = input.nextLine();
        HashSet<Character> set = new HashSet<>();
        char current = 'a';
        for (int i = 0; i < line.length(); i++) {
            if (!set.contains(line.charAt(i))) {
                if (line.charAt(i) == current) {
                    set.add(current);
                    current = (char)(current + 1);
                } else {
                    out.println("NO");
                    System.exit(0);
                }
            }
        }
        out.println("YES");
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