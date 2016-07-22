import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by alvin on 7/21/16.
 */
public class Codeforces_round_111_div_2_UnluckyTicket {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int index = input.nextInt();
        String totalNum = input.nextLine();
        char[] firstPart = totalNum.substring(0, index).toCharArray();
        char[] secondPart = totalNum.substring(index, totalNum.length()).toCharArray();
        Arrays.sort(firstPart);
        Arrays.sort(secondPart);
        boolean greaterThan = true;
        boolean lessThan = true;
        for (int i = 0; i < firstPart.length; i++) {
            if (firstPart[i] <= secondPart[i]) {
                greaterThan = false;
            }
        }
        for (int i = 0; i < firstPart.length; i++) {
            if (firstPart[i] >= secondPart[i]) {
                lessThan = false;
            }
        }
        out.println(greaterThan || lessThan ? "YES" : "NO");
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