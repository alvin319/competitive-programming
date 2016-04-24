import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/24/16.
 */

public class Codeforces_round_327_div_2_Rebranding {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int l = input.nextInt();
        int query = input.nextInt();
        char[] replacement = input.nextLine().toCharArray();
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char)(i + 'a');
        }
        for (int i = 0; i < query; i++) {
            char x = input.next().charAt(0);
            char y = input.next().charAt(0);
            if(x != y) {
                for (int j = 0; j < alphabet.length; j++) {
                    if(alphabet[j] == x) {
                        alphabet[j] = y;
                    } else if(alphabet[j] == y) {
                        alphabet[j] = x;
                    }
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < replacement.length; i++) {
            answer.append(alphabet[replacement[i] - 'a']);
        }
        out.println(answer);
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