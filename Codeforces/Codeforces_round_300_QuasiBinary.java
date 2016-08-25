import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 8/25/16.
 */

public class Codeforces_round_300_QuasiBinary {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String number = input.nextLine();
        int length = -1;
        for (int i = 0; i < number.length(); i++) {
            length = Math.max(length, number.charAt(i) - '0');
        }
        int digitLength = number.length();
        int count = Integer.parseInt(number);
        String[] array = new String[length];
        for (int i = 0; i < array.length; i++) {
            String currentSolution = generateNumber(number, digitLength);
            array[i] = currentSolution;
            count -= Integer.parseInt(currentSolution);
            number = count + "";
        }
        out.println(array.length);
        for (int i = 0; i < array.length; i++) {
            out.print(i == 0 ? array[i] : " " + array[i]);
        }
        out.close();
    }

    public static String generateNumber(String number, int digitLength) {
        String answer = "";
        for (int i = 0; i < number.length(); i++) {
            int currentDigit = number.charAt(i) - '0';
            if (currentDigit > 0) {
                answer += '1';
            } else {
                answer += '0';
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