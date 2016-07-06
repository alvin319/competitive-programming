import java.io.*;
import java.util.*;

/**
 * Created by alvin on 6/28/16.
 */
public class Codeforces_GoodBye_2013_NewYearRatingsChange {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Person(i, input.nextInt()));
        }
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return new Long(o1.ratings).compareTo(o2.ratings);
            }
        });
        long[] solutions = new long[n];
        long currentRating = 1;
        for (Person x : list) {
            if (currentRating >= x.ratings) {
                solutions[x.index] = currentRating;
                currentRating++;
            } else {
                solutions[x.index] = x.ratings;
                currentRating = x.ratings + 1;
            }
        }
        for (int i = 0; i < solutions.length; i++) {
            if (i == 0) {
                out.print(solutions[i]);
            } else {
                out.print(" " + solutions[i]);
            }
        }
        out.close();
    }

    public static class Person {
        int index;
        long ratings;

        public Person(int index, long ratings) {
            this.index = index;
            this.ratings = ratings;
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
