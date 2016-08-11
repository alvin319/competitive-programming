import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by alvin on 8/11/16.
 */
public class Codeforces_round_262_div_2_LittleDimaAndEquation {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        ArrayList<Long> answerList = new ArrayList<>();
        for (int i = 1; i <= 81; i++) {
            long solution = (long) (b * Math.pow(i, a) + c);
            long answer = 0;
            String solutionstring = solution + "";
            for (int j = 0; j < solutionstring.length(); j++) {
                answer += (long) (solutionstring.charAt(j) - '0');
            }
            if (answer == i && solution > 0 && solution < (long)Math.pow(10, 9)) {
                answerList.add(solution);
            }
        }
        out.println(answerList.size());
        for (int i = 0; i < answerList.size(); i++) {
            out.print(i == 0 ? answerList.get(i) : " " + answerList.get(i));
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
