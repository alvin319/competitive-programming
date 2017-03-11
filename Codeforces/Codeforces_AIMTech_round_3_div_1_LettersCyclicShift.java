import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_AIMTech_round_3_div_1_LettersCyclicShift {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String original = input.nextLine();
        StringBuilder line = new StringBuilder(original);
        int index = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != 'a') {
                break;
            } else {
                index++;
            }
        }
        for (int i = index; i < line.length(); i++) {
            if (line.charAt(i) != 'a') {
                line.setCharAt(i, (char) ((int) line.charAt(i) - 1));
            } else {
                break;
            }
        }
        if (line.toString().equals(original)) {
            int i = line.length() - 1;
            if (line.charAt(i) != 'a') {
                line.setCharAt(i, (char) ((int) line.charAt(i) - 1));
            } else {
                line.setCharAt(i, 'z');
            }
            out.println(line);
        } else {
            out.println(line);
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