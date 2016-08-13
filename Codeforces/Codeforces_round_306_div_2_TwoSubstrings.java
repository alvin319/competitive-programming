import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/26/16.
 */

public class Codeforces_round_306_div_2_TwoSubstrings {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String current = input.nextLine();
        LinkedList<Pair> abList = new LinkedList<>();
        LinkedList<Pair> baList = new LinkedList<>();
        for (int i = 0; i < current.length(); i++) {
            char now = current.charAt(i);
            char prev = (i - 1) >= 0 ? current.charAt(i - 1) : 'a';
            char next = (i + 1) < current.length() ? current.charAt(i + 1) : 'a';
            if (now == 'A') {
                if (prev != 'a' && prev == 'B') {
                    baList.add(new Pair(i - 1, i));
                }
                if (next != 'a' && next == 'B') {
                    abList.add(new Pair(i, i + 1));
                }
            } else if (now == 'B') {
                if (prev != 'a' && prev == 'A') {
                    abList.add(new Pair(i - 1, i));
                }
                if (next != 'a' && next == 'A') {
                    baList.add(new Pair(i, i + 1));
                }
            }
        }
        if (!abList.isEmpty() && !baList.isEmpty()) {
            Pair ab = abList.getFirst();
            Pair ba = baList.getLast();
            Pair abLast = abList.getLast();
            Pair baFirst = baList.getFirst();
            if (ab.start != ba.start && ab.start != ba.end && ab.end != ba.end && ab.end != ba.start) {
                out.println("YES");
                System.exit(0);
            } else if (abLast.start != ba.start && abLast.start != ba.end && abLast.end != ba.start && abLast.end != ba.end) {
                out.println("YES");
                System.exit(0);
            } else if (abLast.start != baFirst.start && abLast.start != baFirst.end && abLast.end != baFirst.start && abLast.end != baFirst.end) {
                out.println("YES");
                System.exit(0);
            } else if (ab.start != baFirst.start && ab.start != baFirst.end && ab.end != baFirst.start && ab.end != baFirst.end) {
                out.println("YES");
                System.exit(0);
            }
        }
        out.println("NO");
        out.close();
    }

    static class Pair {
        int start;
        int end;

        public Pair (int start, int end) {
            this.start = start;
            this.end = end;
        }
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