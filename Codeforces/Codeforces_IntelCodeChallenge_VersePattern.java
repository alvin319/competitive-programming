/**
 * Created by qicodeng on 10/1/16.
 */

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Codeforces_IntelCodeChallenge_VersePattern {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('y');
        int[] req = new int[n];
        for (int i = 0; i < req.length; i++) {
            req[i] = input.nextInt();
        }
        int[] have = new int[n];
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            int count = 0;
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (set.contains(c)) {
                    count++;
                }
            }
            have[i] = count;
        }
        boolean good = true;
        for (int i = 0; i < have.length; i++) {
            if (have[i] != req[i]) {
                good = false;
                break;
            }
        }
        out.println(good ? "YES" : "NO");
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
