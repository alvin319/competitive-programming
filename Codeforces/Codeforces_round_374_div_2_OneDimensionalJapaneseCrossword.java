import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 10/15/16.
 */

public class Codeforces_round_374_div_2_OneDimensionalJapaneseCrossword {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        String line = input.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        int c = 0;
        boolean cont = false;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'B' && !cont) {
                cont = true;
                c++;
            } else if (line.charAt(i) == 'B' && cont) {
                c++;
            } else if (line.charAt(i) != 'B' && cont) {
                cont = false;
                list.add(c);
                c = 0;
            }
        }
        if (c != 0) {
            list.add(c);
        }
        out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            out.print(i == 0 ? list.get(i) : " " + list.get(i));
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