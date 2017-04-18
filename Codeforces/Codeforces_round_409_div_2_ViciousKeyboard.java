import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_round_409_div_2_ViciousKeyboard {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String line = input.nextLine();
        int answer = 0;
        for (int i = 0; i < line.length(); i++) {
            StringBuilder builder = new StringBuilder(line);
            if (line.charAt(i) == 'K') {
                builder.setCharAt(i, 'V');
                answer = Math.max(answer, getNum(builder.toString()));
            } else {
                builder.setCharAt(i, 'K');
                answer = Math.max(answer, getNum(builder.toString()));
            }
        }
        out.println(Math.max(answer, getNum(line)));
        out.close();
    }

    public static int getNum(String line) {
        int answer = 0;
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (current.length() >= 2) {
                current = current.deleteCharAt(0);
            }
            current = current.append(line.charAt(i));
            if (current.length() == 2 && current.toString().equals("VK")) {
                answer++;
            }
        }
        return answer;
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