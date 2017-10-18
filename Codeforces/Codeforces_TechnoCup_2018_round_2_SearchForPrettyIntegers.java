import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Codeforces_TechnoCup_2018_round_2_SearchForPrettyIntegers {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] array = new int[n];
        int firstMin = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
            firstMin = Math.min(firstMin, array[i]);
        }
        int[] secondArray = new int[m];
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = input.nextInt();
            secondMin = Math.min(secondMin, secondArray[i]);
        }
        Arrays.sort(array);
        Arrays.sort(secondArray);
        for (int i = 1; i <= 9; i++) {
            if (Arrays.binarySearch(array, i) >= 0 && Arrays.binarySearch(secondArray, i) >= 0) {
                out.println(i);
                System.exit(0);
            }
        }
        if (firstMin == secondMin) {
            out.println(firstMin);
        } else if (firstMin > secondMin) {
            out.println(secondMin + "" + firstMin);
        } else {
            out.println(firstMin + "" + secondMin);
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

