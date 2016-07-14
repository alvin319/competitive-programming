import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/14/2016.
 */

public class Codeforces_round_362_div_2_Barnicle {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String[] array = input.nextLine().split("e");
        if (array[1].equals("0")) {
            if (array[0].split("\\.")[1].equals("0")) {
                out.println(array[0].split("\\.")[0]);
            } else {
                out.println(array[0]);
            }
        } else {
            int count = Integer.parseInt(array[1]);
            int indexCount = 0;
            String[] number = array[0].split("\\.");
            StringBuilder builder = new StringBuilder();
            builder.append(number[0]);
            for (int i = 0; i < number[1].length(); i++) {
                if (i < count) {
                    builder.append(number[1].charAt(i));
                    indexCount++;
                } else {
                    break;
                }
            }
            for (int i = indexCount; i < count; i++) {
                builder.append("0");
            }
            builder.append(".");
            for (int i = count; i < number[1].length(); i++) {
                builder.append(number[1].charAt(i));
            }
            if (builder.charAt(builder.length() - 1) == '.') {
                builder.deleteCharAt(builder.length() - 1);
            }
            out.println(builder);
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

