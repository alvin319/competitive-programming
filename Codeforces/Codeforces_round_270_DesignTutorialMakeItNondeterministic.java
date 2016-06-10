import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by alvin on 6/10/16.
 */

public class Codeforces_round_270_DesignTutorialMakeItNondeterministic {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] array = input.nextLine().split(" ");
            list.add(new Person(array[0], array[1]));
        }
        String previousOrder = "";
        for (int i = 0; i < n; i++) {
            Person current = list.get(input.nextInt() - 1);
            String firstName = current.first;
            String lastName = current.last;
            previousOrder = nextName(firstName, lastName, previousOrder);
        }
        out.println("YES");
        out.close();
    }

    public static String nextName(String firstName, String lastName, String previousName) {
        int fp = firstName.compareTo(previousName);
        int lp = lastName.compareTo(previousName);
        int fl = firstName.compareTo(lastName);
        if(fp < 0 && lp < 0) {
            out.println("NO");
            System.exit(0);
        }
        if(fp > 0 && lp > 0) {
            return fl > 0 ? lastName : firstName;
        }
        if(fp > 0 && lp < 0) {
            return firstName;
        }
        return lastName;
    }


    static class Person {
        String first;
        String last;

        public Person(String f, String s) {
            first = f;
            last = s;
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
