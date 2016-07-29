import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/28/2016.
 */

public class Codeforces_round_260_div_2_Laptops {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        Laptop[] array = new Laptop[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Laptop(input.nextInt(), input.nextInt());
        }
        Arrays.sort(array, new Comparator<Laptop>() {
            @Override
            public int compare(Laptop o1, Laptop o2) {
                return new Integer(o1.quality).compareTo(o2.quality);
            }
        });
        for (int i = 1; i < array.length; i++) {
            Laptop current = array[i];
            Laptop previous = array[i - 1];
            if (current.quality > previous.quality && current.price < previous.price) {
                out.println("Happy Alex");
                System.exit(0);
            }
        }
        out.println("Poor Alex");
        out.close();
    }

    static class Laptop {
        int price;
        int quality;

        public Laptop(int price, int quality) {
            this.price = price;
            this.quality = quality;
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

