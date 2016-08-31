import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 8/31/16.
 */

public class Codeforces_round_292_div_2_DrazilAndHisHappyFriends {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int b = input.nextInt();
        int g = input.nextInt();
        HashSet<Integer> happyB = new HashSet<>();
        int bCount = input.nextInt();
        for (int i = 0; i < bCount; i++) {
            happyB.add(input.nextInt());
        }
        int gCount = input.nextInt();
        HashSet<Integer> happyG = new HashSet<>();
        for (int i = 0; i < gCount; i++) {
            happyG.add(input.nextInt());
        }
        int bIndex = 0;
        int gIndex = 0;
        for (int i = 1; i <= 2000000; i++) {
            if (happyB.size() == b && happyG.size() == g) {
                out.println("Yes");
                System.exit(0);
            }
            if (bIndex == b) {
                bIndex = 0;
            }
            if (gIndex == g) {
                gIndex = 0;
            }
            if (happyB.contains(bIndex) || happyG.contains(gIndex)) {
                happyB.add(bIndex);
                happyG.add(gIndex);
            }
            bIndex++;
            gIndex++;
        }
        out.println("No");
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