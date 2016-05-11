import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/10/16.
 */

public class Codeforces_round_191_div_2_FlippingGame {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int maxZ = -1;
        int maxS = -1;
        int maxE = -1;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j <= array.length; j++) {
                int currentZ = 0;
                for (int k = i; k < j; k++) {
                    if (array[k] == 0) {
                        currentZ++;
                    } else {
                        currentZ--;
                    }
                }
                if (currentZ > maxZ) {
                    maxZ = currentZ;
                    maxS = i;
                    maxE = j;
                }
            }
        }
        if (maxZ != -1) {
            for (int i = maxS; i < maxE; i++) {
                array[i] = array[i] == 1 ? 0 : 1;
            }
        } else {
            array[0] = array[0] == 1 ? 0 : 1;
        }
        long total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        out.println(total);
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