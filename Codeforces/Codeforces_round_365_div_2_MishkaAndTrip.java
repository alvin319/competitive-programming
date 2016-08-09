import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 8/4/2016.
 */

public class Codeforces_round_365_div_2_MishkaAndTrip {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int cities = input.nextInt();
        int capital = input.nextInt();
        HashSet<Integer> capitalSet = new HashSet<>();
        int[] capitalArray = new int[capital];
        long[] beauty = new long[cities];
        long answer = 0;
        for (int i = 0; i < cities; i++) {
            beauty[i] = input.nextLong();
        }
        for (int i = 0; i < capital; i++) {
            capitalArray[i] = input.nextInt() - 1;
            capitalSet.add(capitalArray[i]);
        }
        for (int i = 1; i < beauty.length; i++) {
            long currentBeauty = beauty[i];
            long previousBeauty = beauty[i - 1];
            if (!capitalSet.contains(i) && !capitalSet.contains(i - 1)) {
                answer += currentBeauty * previousBeauty;
            }
        }
        if(!capitalSet.contains(0) && !capitalSet.contains(beauty.length - 1)) {
            answer += beauty[0] * beauty[beauty.length - 1];
        }
        long nonCapitalSum = 0;
        long capitalSum = 0;
        for (int i = 0; i < cities; i++) {
            if(!capitalSet.contains(i)) {
                nonCapitalSum += beauty[i];
            } else {
                capitalSum += beauty[i];
            }
        }
        for (int i = 0; i < capital; i++) {
            long currentCapital = beauty[(int)capitalArray[i]];
            answer += currentCapital * (nonCapitalSum);
        }
        int currentCapitalSum = 0;
        for (int i = 0; i < capital; i++) {
            long currentCapitalBeauty = beauty[(int)capitalArray[i]];
            answer += (capitalSum - currentCapitalBeauty - currentCapitalSum) * currentCapitalBeauty;
            currentCapitalSum += currentCapitalBeauty;
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

