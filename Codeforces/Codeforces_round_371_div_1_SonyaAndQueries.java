import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 9/14/16.
 */

public class Codeforces_round_371_div_1_SonyaAndQueries {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        HashMap<String, Integer> map = new HashMap<>();
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            String[] info = input.nextLine().split(" ");
            String P = info[1];
            P = transform(P);
            switch (info[0]) {
                case "+" : {
                    map.put(P, map.containsKey(P) ? map.get(P) + 1 : 1);
                } break;
                case "-": {
                    int counter = map.get(P);
                    if (counter == 1) {
                        map.remove(P);
                    } else {
                        map.put(P, counter - 1);
                    }
                } break;
                default: {
                    int value = map.containsKey(P) ? map.get(P) : 0;
                    out.println(value);
                }
            }
        }
        out.close();
    }

    public static String transform(String P) {
        String newString = "";
        for (int i = 0; i < P.length(); i++) {
            newString += (P.charAt(i) - '0') % 2;
        }
        while (newString.length() != 18) {
            newString = '0' + newString;
        }
        return newString;
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