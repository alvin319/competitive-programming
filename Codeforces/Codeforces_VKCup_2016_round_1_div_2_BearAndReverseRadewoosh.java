import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/13/16.
 */

public class Codeforces_VKCup_2016_round_1_div_2_BearAndReverseRadewoosh {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int problems = input.nextInt();
        int constant = input.nextInt();
        int[] scores = new int[problems];
        for (int i = 0; i < problems; i++) {
            scores[i] = input.nextInt();
        }
        int[] time = new int[problems];
        for (int i = 0; i < problems; i++) {
            time[i] = input.nextInt();
        }
        long limScore = 0;
        long currentTimer = 0;
        for (int i = 0; i < problems; i++) {
            currentTimer += time[i];
            limScore += Math.max(0, scores[i] - (currentTimer * constant));
        }
        long radScore = 0;
        currentTimer = 0;
        for (int i = problems - 1; i >= 0; i--) {
            currentTimer += time[i];
            radScore += Math.max(0, scores[i] - (currentTimer * constant));
        }
        if(limScore > radScore) {
            out.println("Limak");
        } else if(limScore < radScore) {
            out.println("Radewoosh");
        } else {
            out.println("Tie");
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