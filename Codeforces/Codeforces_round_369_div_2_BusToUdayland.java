/**
 * Created by qicodeng on 10/23/16.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_round_369_div_2_BusToUdayland {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        String[] array = new String[count];
        for (int i = 0; i < count; i++) {
            array[i] = input.nextLine();
        }
        boolean yes = false;
        for (int i = 0; i < array.length; i++) {
            String[] parts = array[i].split("\\|");
            if (parts[0].equals("OO")) {
                array[i] = "++|" + parts[1];
                yes = true;
                break;
            } else if (parts[1].equals("OO")) {
                array[i] = parts[0] + "|" + "++";
                yes = true;
                break;
            }
        }
        if (yes) {
            out.println("YES");
            for (int i = 0; i < array.length; i++) {
                out.println(array[i]);
            }
        } else {
            out.println("NO");
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
