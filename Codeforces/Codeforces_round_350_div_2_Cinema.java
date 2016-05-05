import java.io.*;
import java.util.*;

/**
 * Created by WiNDWAY on 5/5/16.
 */

public class Codeforces_round_350_div_2_Cinema {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = input.nextInt();
            if(!map.containsKey(k)) {
                map.put(k, 1);
            } else {
                map.put(k , map.get(k) + 1);
            }
        }
        int movies = input.nextInt();
        int[] audio = new int[movies];
        int[] subs = new int[movies];
        for (int i = 0; i < movies; i++) {
            audio[i] = input.nextInt();
        }
        for (int i = 0; i < movies; i++) {
            subs[i] = input.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        int maxMovieIndex = -1;
        int maxMovieA = -1;
        int maxMovieS = -1;
        for (int i = 0; i < movies; i++) {
            int currentA = audio[i];
            int currentS = subs[i];
            if(map.containsKey(currentA)) {
                if(map.get(currentA) > maxMovieA) {
                    maxMovieA = map.get(currentA);
                    maxMovieS = map.get(currentS) == null ? 0 : map.get(currentS);
                    maxMovieIndex = i + 1;
                } else if(map.get(currentA) == maxMovieA) {
                    if(map.containsKey(currentS)) {
                        if(map.get(currentS) > maxMovieS) {
                            maxMovieA = map.get(currentA);
                            maxMovieS = map.get(currentS);
                            maxMovieIndex = i + 1;
                        }
                    }
                }
            }
        }
        if(maxMovieIndex == -1) {
            for (int i = 0; i < movies; i++) {
                int currentS = subs[i];
                if(map.containsKey(currentS)) {
                    if(map.get(currentS) > maxMovieS) {
                        maxMovieS = map.get(currentS);
                        maxMovieIndex = i + 1;
                    }
                }
            }
        }
        if(maxMovieIndex == -1) {
            out.println(1);
        } else {
            out.println(maxMovieIndex);
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