import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/20/16.
 */

public class CodeJam2016_round_1A_TheLastWord {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            String current = input.nextLine();
            LinkedList<Character> answer = new LinkedList<>();
            answer.addFirst(current.charAt(0));
            int maxIndex = 0;
            for (int j = 1; j < current.length(); j++) {
                char now = current.charAt(j);
                if ((int) now > (int) answer.getFirst()) {
                    answer.addFirst(now);
                    maxIndex = 0;
                } else if ((int) now < (int) answer.getFirst()) {
                    answer.addLast(now);
                } else {
                    answer.add(maxIndex + 1, now);
                    maxIndex++;
                }
            }
            String finalAns = "";
            for (char x : answer) {
                finalAns += x;
            }
            out.println("Case #" + (i + 1) + ": " + finalAns);
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