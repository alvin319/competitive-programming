import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/14/16.
 */

public class Codeforces_round_342_div_2_GuestFromThePast {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long currentMoney = input.nextLong();
        long plasticCost = input.nextLong();
        long glassCost = input.nextLong();
        long returnCost = input.nextLong();
        long glassCount = (currentMoney - returnCost) / (glassCost - returnCost);
        long remain = currentMoney - glassCount * (glassCost - returnCost);
        if(plasticCost > currentMoney && glassCost > currentMoney) {
            out.println(0);
        } else {
            if (plasticCost <= (glassCost - returnCost)) {
                out.println(currentMoney / plasticCost);
            } else if(glassCount > 0) {
                if (remain > 0) {
                    out.println(glassCount + (remain / plasticCost));
                } else {
                    out.println(glassCount);
                }
            } else {
                out.println(currentMoney / plasticCost);
            }
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