import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by WiNDWAY on 4/5/16.
 */

public class Codeforces_round_345_div_2_BeautifulPaintings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < n; i++) {
            int current = input.nextInt();
            list.add(current);
        }
        Collections.sort(list);
        if(list.size() == 1) {
            System.out.println(0);
        } else {
            int initSize = 0;
            do {
                System.out.println();
                initSize = list.size();
                HashSet<Integer> removal = new HashSet<>();
                for (int i = 1; i < list.size(); i++) {
                    int previous = list.get(i - 1);
                    int current = list.get(i);
                    if(current > previous) {
                        removal.add(current);
                        removal.add(previous);
                        total++;
                    }
                }
                for(int x : removal) {
                    list.remove(new Integer(x));
                }
            } while(list.size() != initSize);
            System.out.println(total);
        }
    }
}
