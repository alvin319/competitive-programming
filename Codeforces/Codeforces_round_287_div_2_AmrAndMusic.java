import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by alvin on 6/3/16.
 */
public class Codeforces_round_287_div_2_AmrAndMusic {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        Instrument[] instr = new Instrument[input.nextInt()];
        int k = input.nextInt();
        for (int i = 0; i < instr.length; i++) {
            instr[i] = new Instrument(input.nextInt(), i + 1);
        }
        Arrays.sort(instr, new Comparator<Instrument>() {
            @Override
            public int compare(Instrument o1, Instrument o2) {
                return new Integer(o1.cost).compareTo(o2.cost);
            }
        });
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < instr.length; i++) {
            if(instr[i].cost <= k) {
                k -= instr[i].cost;
                list.add(instr[i].id);
            } else {
                break;
            }
        }
        out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            if(i == 0) {
                out.print(list.get(i));
            } else {
                out.print(" " + list.get(i));
            }
        }
        out.close();
    }

    static class Instrument {
        int cost;
        int id;

        public Instrument(int cost, int id) {
            this.id = id;
            this.cost = cost;
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
