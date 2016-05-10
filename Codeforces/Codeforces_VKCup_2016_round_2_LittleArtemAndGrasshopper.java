import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/6/2016.
 */

public class Codeforces_VKCup_2016_round_2_LittleArtemAndGrasshopper {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        String current = input.nextLine();
        int[] array = new int[count];
        boolean[] visited = new boolean[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int currentIndex = 0;
        while(true) {
            if(currentIndex < 0 || currentIndex >= count) {
                out.println("FINITE");
                break;
            }
            if(!visited[currentIndex]) {
                visited[currentIndex] = true;
                if(current.charAt(currentIndex) == '>') {
                    currentIndex += array[currentIndex];
                } else {
                    currentIndex -= array[currentIndex];
                }
            } else {
                out.println("INFINITE");
                break;
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

