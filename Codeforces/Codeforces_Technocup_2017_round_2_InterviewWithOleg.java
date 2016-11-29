import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/29/16.
 */

public class Codeforces_Technocup_2017_round_2_InterviewWithOleg {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        char[] array = input.nextLine().toCharArray();
        StringBuilder buffer = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'o') {
                buffer.append(array[i]);
                int index = i + 1;
                boolean isO = true;
                while (index < array.length) {
                    if (array[index] == 'g' && isO) {
                        isO = false;
                        buffer.append('g');
                    } else if (array[index] == 'o' && !isO) {
                        isO = true;
                        buffer.append('o');
                    } else {
                        break;
                    }
                    index++;
                }
                if (buffer.length() >= 1) {
                    if (buffer.charAt(buffer.length() - 1) == 'g') {
                        buffer.deleteCharAt(buffer.length() - 1);
                        i = index - 2;
                    } else {
                        i = index - 1;
                    }
                    if (buffer.length() >= 3) {
                        answer.append("***");
                    } else {
                        answer.append(buffer);
                    }
                    buffer.setLength(0);
                }
            } else {
                answer.append(array[i]);
            }
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