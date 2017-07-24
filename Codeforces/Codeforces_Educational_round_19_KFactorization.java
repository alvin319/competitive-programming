import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Codeforces_Educational_round_19_KFactorization {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int num = input.nextInt();
        int k = input.nextInt();
        primeFactors(num, k);
        out.close();
    }

    public static void primeFactors(int number, int limit) {
        int upperBound = limit - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (number % 2 == 0 && list.size() < upperBound) {
            number /= 2;
            list.add(2);
        }

        for (int i = 3; i <= Math.sqrt(number) && list.size() < upperBound; i += 2) {
            while (number % i == 0 && list.size() < upperBound) {
                list.add(i);
                number /= i;
            }
        }
        if (number > 1) {
            list.add(number);
        }
        if (list.size() == limit) {
            for (int i = 0; i < list.size(); i++) {
                out.print(i == 0 ? list.get(i) : " " + list.get(i));
            }
        } else {
            out.println(-1);
        }
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