import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 4/23/2016.
 */

public class Codeforces_Educational_round_3_USBFlashDrives {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int usb = input.nextInt();
        int size = input.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < usb; i++) {
            list.add(input.nextInt());
        }
        Collections.sort(list, Collections.reverseOrder());
        int answer = 0;
        int index = 0;
        while(size > 0) {
            size -= list.get(index);
            answer++;
            index++;
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

