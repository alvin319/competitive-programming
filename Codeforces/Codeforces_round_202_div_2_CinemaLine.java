import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/26/2016.
 */

public class Codeforces_round_202_div_2_CinemaLine {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(25, 0);
        map.put(50, 0);
        map.put(100, 0);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 25) {
                map.put(25, map.get(25) + 1);
            } else if (array[i] == 50) {
                if (map.get(25) <= 0) {
                    out.println("NO");
                    System.exit(0);
                } else {
                    map.put(25, map.get(25) - 1);
                    map.put(50, map.get(50) + 1);
                }
            } else {
                int twoFiveCount = map.get(25);
                int fiveCount = map.get(50);
                if (twoFiveCount >= 1 && fiveCount >= 1) {
                    map.put(100, map.get(100) + 1);
                    map.put(25, twoFiveCount - 1);
                    map.put(50, fiveCount - 1);
                } else if (twoFiveCount >= 3) {
                    map.put(100, map.get(100) + 1);
                    map.put(25, twoFiveCount - 3);
                } else {
                    out.println("NO");
                    System.exit(0);
                }
            }
        }
        out.println("YES");
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

