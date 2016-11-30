import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/28/2016.
 */

public class UVa_10141_RequestForProposal {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int p = input.nextInt();
        int caseNum = 1;
        while (n != 0 && p != 0) {
            for (int i = 0; i < n; i++) {
                input.nextLine();
            }
            String bestBrand = "";
            int bestReqCount = 0;
            double bestCost = Double.MAX_VALUE;
            for (int i = 0; i < p; i++) {
                String currentBrand = input.nextLine();
                double currentCost = input.nextDouble();
                int currentReq = input.nextInt();
                for (int j = 0; j < currentReq; j++) {
                    input.nextLine();
                }
                if (currentReq > bestReqCount) {
                    bestBrand = currentBrand;
                    bestCost = currentCost;
                    bestReqCount = currentReq;
                } else if (currentReq == bestReqCount) {
                    if (bestCost > currentCost) {
                        bestCost = currentCost;
                        bestBrand = currentBrand;
                        bestReqCount = currentReq;
                    }
                }
            }
            if (caseNum == 1) {
                out.println("RFP #" + caseNum);
                out.println(bestBrand);
            } else {
                out.println();
                out.println("RFP #" + caseNum);
                out.println(bestBrand);
            }
            caseNum++;
            n = input.nextInt();
            p = input.nextInt();
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

