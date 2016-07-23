import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by alvin on 7/23/16.
 */
public class Codeforces_round_364_div_2_Cards {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        Card[] array = new Card[count];
        int total = 0;
        for (int i = 0; i < count; i++) {
            array[i] = new Card(i + 1, input.nextInt());
            total += array[i].value;
        }
        Arrays.sort(array, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return new Integer(o1.value).compareTo(o2.value);
            }
        });
        int average = total / (count / 2);
        int start = 0;
        int end = array.length - 1;
        for (int i = 0; i < count / 2; i++) {
            out.println(array[start].index + " " + array[end].index);
            start++;
            end--;
        }

        out.close();
    }

    static class Card {
        int index;
        int value;

        public Card(int index, int value) {
            this.index = index;
            this.value = value;
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
