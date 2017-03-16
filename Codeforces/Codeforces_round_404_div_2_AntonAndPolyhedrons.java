import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Codeforces_round_404_div_2_AntonAndPolyhedrons {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        HashMap<String, Integer> m = new HashMap<>();
        m.put("Tetrahedron", 4);
        m.put("Cube", 6);
        m.put("Octahedron", 8);
        m.put("Dodecahedron", 12);
        m.put("Icosahedron", 20);
        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += m.get(input.nextLine());
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