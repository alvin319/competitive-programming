import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 4/13/2016.
 */
public class Codeforces_round_336_div_2_SaitamaDestroysHotel {
    public static void main(String[] args) throws IOException {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int starting = input.nextInt();
        Passenger[] list = new Passenger[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new Passenger(input.nextInt(), input.nextInt());
        }
        Arrays.sort(list, new Comparator<Passenger>() {
            @Override
            public int compare(Passenger o1, Passenger o2) {
                return -1 * new Integer(o1.floor).compareTo(o2.floor);
            }
        });
        long total = 0;
        for (int i = 0; i < list.length; i++) {
            Passenger current = list[i];
            if(starting > current.floor) {
                total += starting - current.floor;
                starting = current.floor;
            }
            if(total < current.wait) {
                total += current.wait - total;
            }
        }
        total += starting;
        System.out.println(total);
        out.close();
    }

    static class Passenger {
        int floor;
        int wait;

        public Passenger(int floor, int wait) {
            this.floor = floor;
            this.wait = wait;
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
