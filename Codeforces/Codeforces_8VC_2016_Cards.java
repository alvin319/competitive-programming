import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/14/16.
 */

public class Codeforces_8VC_2016_Cards {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int cards = input.nextInt();
        HashMap<Character, Integer> map = new HashMap<>();
        String current = input.nextLine();
        for (int i = 0; i < current.length(); i++) {
            char now = current.charAt(i);
            map.put(now, !map.containsKey(now) ? 1 : map.get(now) + 1);
        }
        int blue = map.containsKey('B') ? map.get('B') : 0;
        int red = map.containsKey('R') ? map.get('R') : 0;
        int green = map.containsKey('G') ? map.get('G') : 0;
        if(blue == 0 && green == 0) {
            out.println("R");
        } else if(blue == 0 && red == 0) {
            out.println("G");
        } else if(red == 0 && green == 0) {
            out.println("B");
        } else if((red >= 1 && blue >= 1 && green >= 1) || (blue >= 2 && green >= 2) || (blue >= 2 && red >= 2) || (red >= 2 && green >= 2)) {
            out.println("BGR");
        } else if(red == 1 && blue == 1) {
            out.println("G");
        } else if(blue == 1 && green == 1) {
            out.println("R");
        } else if(red == 1 && green == 1) {
            out.println("B");
        } else if((red >= 2 && blue == 1) || (red >= 2 && green == 1)) {
            out.println("BG");
        } else if((blue >= 2 && green == 1) || (blue >= 2 && red == 1)) {
            out.println("GR");
        } else {
            out.println("BR");
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