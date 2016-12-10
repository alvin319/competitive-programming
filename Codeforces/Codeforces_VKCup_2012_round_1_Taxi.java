import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 12/17/16.
 */

public class Codeforces_VKCup_2012_round_1_Taxi {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int i = input.nextInt();
        String line = input.nextLine();
        int[] nums = {0, 0, 0, 0, 0};
        for (int j = 0; j < i * 2; j += 2) {
            nums[Character.getNumericValue(line.charAt(j))] += 1;
        }
        if (nums[1] > nums[3]) {
            nums[1] -= nums[3];
        } else {
            nums[1] = 0;
        }
        if (nums[2] % 2 == 1 && nums[1] > 0) {
            nums[1] -= (nums[1] == 1 ? 1 : 2);
        }
        System.out.println((nums[1] + 3) / 4 + (nums[2] + 1) / 2 + nums[3] + nums[4]);
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