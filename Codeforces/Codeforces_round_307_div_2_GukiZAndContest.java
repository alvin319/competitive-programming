import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 12/28/2016.
 */

public class Codeforces_round_307_div_2_GukiZAndContest {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int[] answer = new int[n];
        for (int i = 0; i < answer.length; i++) {
            int count = 1;
            for (int j = 0; j < answer.length; j++) {
                if (i != j && array[i] < array[j]) {
                    count++;
                }
            }
            answer[i] = count;
        }
        for (int i = 0; i < array.length; i++) {
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

