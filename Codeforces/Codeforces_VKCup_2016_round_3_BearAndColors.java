import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/9/16.
 */

public class Codeforces_VKCup_2016_round_3_BearAndColors {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int balls = input.nextInt();
        int[] interval = new int[balls];
        int[] answer = new int[balls];
        for (int i = 0; i < interval.length; i++) {
            interval[i] = input.nextInt();
        }

        for (int i = 0; i < interval.length; i++) {
            int[] overallCount = new int[balls];
            int currentCount = 1;
            int currentDominantIndex = interval[i] - 1;
            answer[interval[i] - 1]++;
            overallCount[interval[i] - 1]++;
            for (int j = i + 1; j < interval.length; j++) {
                overallCount[interval[j] - 1]++;
                if(overallCount[interval[j] - 1] > currentCount) {
                    currentCount = overallCount[interval[j] - 1];
                    currentDominantIndex = interval[j] - 1;
                } else if(overallCount[interval[j] - 1] == currentCount && (interval[j] - 1) < currentDominantIndex) {
                    currentDominantIndex = interval[j] - 1;
                }
                answer[currentDominantIndex]++;
            }
        }
        for (int i = 0; i < answer.length; i++) {
            out.print(i == 0 ? answer[i] : " " + answer[i]);
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