import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 9/16/2016.
 */

public class UVa_11608_NoProblem {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int T = input.nextInt();
        int caseNum = 1;
        while (T >= 0) {
            out.println("Case " + caseNum + ":");
            int[] hasArray = new int[12];
            int[] needArray = new int[12];
            for (int i = 0; i < hasArray.length; i++) {
                hasArray[i] = input.nextInt();
            }
            for (int i = 0; i < needArray.length; i++) {
                needArray[i] = input.nextInt();
            }
            int currentNum = T;
            for (int i = 0; i < needArray.length; i++) {
                out.println(needArray[i] > currentNum ? "No problem. :(" : "No problem! :D");
                currentNum += needArray[i] > currentNum ? hasArray[i] : hasArray[i] - needArray[i];
            }
            T = input.nextInt();
            caseNum++;
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

