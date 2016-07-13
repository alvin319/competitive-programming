import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/14/2016.
 */

public class UVa_11586_TrainTracks {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            String currentLine = input.nextLine();
            String[] array = currentLine.split(" ");
            for (int j = 0; j < currentLine.length(); j++) {
                char currentChar = currentLine.charAt(j);
                map.put(currentChar, map.containsKey(currentChar) ? map.get(currentChar) + 1 : 1);
            }
            if (map.get('M').equals(map.get('F')) && array.length > 2) {
                out.println("LOOP");
            } else if (map.get('M').equals(map.get('F')) && array.length == 2) {
                if (array[0].equals("MF") && array[1].equals("MF")) {
                    out.println("LOOP");
                } else if (array[0].equals("MM") && array[1].equals("FF")) {
                    out.println("LOOP");
                } else {
                    out.println("NO LOOP");
                }
            } else {
                out.println("NO LOOP");
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

