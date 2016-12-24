import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 12/23/2016.
 */

public class Codeforces_round_387_div_2_MammothsGenomeDecoding {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        String line = input.nextLine();
        if (n % 4 != 0) {
            out.println("===");
        } else {
            int equal = n / 4;
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('A', 0);
            map.put('G', 0);
            map.put('C', 0);
            map.put('T', 0);
            map.put('?', 0);
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);
                map.put(currentChar, map.get(currentChar) + 1);
            }
            for (char x : map.keySet()) {
                if (x != '?' && map.get(x) > equal) {
                    out.println("===");
                    System.exit(0);
                }
            }
            for (int i = 0; i < line.length(); i++) {
                char x = line.charAt(i);
                if (x != '?') {
                    out.print(x);
                } else {
                    char missing = ' ';
                    for (char y : map.keySet()) {
                        if (map.get(y) < equal) {
                            missing = y;
                            map.put(y, map.get(y) + 1);
                            break;
                        }
                    }
                    out.print(missing);
                }
            }
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

