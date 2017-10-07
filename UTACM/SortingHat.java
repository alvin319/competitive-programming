import java.io.*;
import java.util.*;


public class SortingHat {

    static HashSet<Character> set = new HashSet<>();
    static HashSet<Integer> monthSet = new HashSet<>();

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        monthSet.add(6);
        monthSet.add(7);
        monthSet.add(8);
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split(" ");
            list.add(new User(line[0], line[1], i(line[2]), i(line[3]), i(line[4])));
        }
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int o1Vowel = set.contains(o1.fname.charAt(0)) ? 1 : 0;
                int o2Vowel = set.contains(o2.fname.charAt(0)) ? 1 : 0;

                if (o1Vowel != o2Vowel) {
                    if (o1Vowel == 1) {
                        return 1;
                    }
                    return -1;
                }

                if (o1.siblings != o2.siblings) {
                    return new Integer(o1.siblings).compareTo(o2.siblings);
                }

                int o1Month = monthSet.contains(o1.month) ? 1 : 0;
                int o2Month = monthSet.contains(o2.month) ? 1 : 0;

                if (o1Month != o2Month) {
                    if (o1Month == 1) {
                        return 1;
                    }
                    return -1;
                }

                int o1Dist = Math.abs(o1.day - 1);
                int o2Dist = Math.abs(o2.day - 1);

                if (o1Dist != o2Dist) {
                    return -new Integer(o1Dist).compareTo(o2Dist);
                }

                return o1.lname.compareTo(o2.lname);
            }
        });
        for (User current : list) {
            out.println(current.fname + " " + current.lname);
        }
        out.close();
    }

    static int i (String num) {
        return Integer.parseInt(num);
    }

    static class User {
        String fname;
        String lname;
        int siblings;
        int month;
        int day;

        public User(String fname, String lname, int siblings, int month, int day) {
            this.fname = fname;
            this.lname = lname;
            this.siblings = siblings;
            this.month = month;
            this.day = day;
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