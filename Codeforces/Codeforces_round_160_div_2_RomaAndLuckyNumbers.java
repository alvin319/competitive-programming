import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 8/18/2016.
 */

public class Codeforces_round_160_div_2_RomaAndLuckyNumbers {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        int limit = input.nextInt();
        int answer = 0;
        String[] array = input.nextLine().split(" ");
        for (int i = 0; i < array.length; i++) {
            String current = array[i];
            int[] counter = new int[2];
            for (int j = 0; j < current.length(); j++) {
                if (current.charAt(j) == '4') {
                    counter[0]++;
                } else if (current.charAt(j) == '7') {
                    counter[1]++;
                }
            }
            if (counter[0] + counter[1] <= limit) {
                answer++;
            }
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

