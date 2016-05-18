import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/17/2016.
 */

public class Codeforces_Educational_round_7_TheTime {
    public static void main(String[] args) throws IOException {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");
        DecimalFormat format = new DecimalFormat("00");
        String current = input.nextLine();
        try {
            Date currentDate = simpleDate.parse(current);
            Calendar gc = new GregorianCalendar();
            gc.setTime(currentDate);
            gc.add(GregorianCalendar.MINUTE, input.nextInt());
            out.println(format.format(gc.getTime().getHours()) + ":" + format.format(gc.getTime().getMinutes()));
        } catch (ParseException e) {

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

