import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Codeforces_AIMTech_round_4_Diversity {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String line = input.nextLine();
        int k = input.nextInt();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < line.length(); i++) {
            set.add(line.charAt(i));
        }
        if (set.size() >= k) {
            out.println(0);
        } else {
            if (line.length() - set.size() >= Math.abs(set.size() - k)) {
                out.println(Math.abs(set.size() - k));
            } else {
                out.println("impossible");
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