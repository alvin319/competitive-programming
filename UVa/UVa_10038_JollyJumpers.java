import java.io.*;
import java.util.BitSet;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 9/10/16.
 */

public class UVa_10038_JollyJumpers {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String line = "";
        while ((line = input.readLine()) != null && !line.trim().equals("\n") && !line.trim().equals("")) {
            String[] lineArray = line.split(" ");
            int count = Integer.parseInt(lineArray[0]);
            int[] array = new int[count];
            for (int i = 0; i < count; i++) {
                array[i] = Integer.parseInt(lineArray[i + 1]);
            }
            BitSet bitSet = new BitSet();
            boolean isJolly = true;
            for (int i = 1; i < array.length; i++) {
                int difference = Math.abs(array[i] - array[i - 1]);
                if (difference < 1 || difference >= array.length || bitSet.get(difference)) {
                    isJolly = false;
                    break;
                }
                bitSet.set(difference);
            }
            out.println(isJolly ? "Jolly" : "Not Jolly");
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