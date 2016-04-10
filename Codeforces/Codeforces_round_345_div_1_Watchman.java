import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Alvin on 4/9/2016.
 */
public class Codeforces_round_345_div_1_Watchman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pair = input.nextInt();
        ArrayList<long[]> info = new ArrayList<>();
        for (int i = 0; i < pair; i++) {
            long[] newInfo = new long[2];
            newInfo[0] = input.nextLong();
            newInfo[1] = input.nextLong();
            info.add(newInfo);
        }
        Collections.sort(info, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return new Long(o1[0]).compareTo(o2[0]);
            }
        });
        int totalSame = 0;
        for (int i = 0; i < info.size(); i++) {
            for (int j = i + 1; j < info.size(); j++) {
                long[] first = info.get(i);
                long[] second = info.get(j);
                if(first[0] == second[0] || first[1] == second[1]) {
                    double manhatthan = Math.abs(first[0] - second[0]) +
                            Math.abs(first[1] - second[1]);
                    double distance = Math.sqrt(Math.pow(first[0] - second[0], 2) + Math.pow(first[1] - second[1], 2));
                    if (manhatthan == distance) {
                        totalSame++;
                    }
                }
            }
        }
        System.out.println(totalSame);
    }
}
