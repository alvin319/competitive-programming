import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by WiNDWAY on 10/30/15.
 */

/*
2
3 3
1 2 3
1 2 2
3 3
1 2 3
2 3 4
 */

public class Meeting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        for(int i = 1; i <= count; i++) {
            ArrayList<Integer> meetings = new ArrayList<Integer>();
            ArrayList<Integer> people = new ArrayList<>();
            int total = 0;
            int room = input.nextInt();
            int person = input.nextInt();
            for(int j = 1; j <= person; j++) {
                people.add(input.nextInt());
            }
            for(int j = 1; j <= room; j++) {
                meetings.add(input.nextInt());
            }
            Collections.sort(meetings);
            Collections.sort(people);
            int mStart = 0;
            int pStart = 0;
            while(mStart < meetings.size() && pStart < meetings.size()) {
                int mVal = meetings.get(mStart);
                int pVal = people.get(pStart);
                if(mVal >= pVal) {
                    pStart++;
                    mStart++;
                    total++;
                } else {
                    mStart++;
                }
            }
            System.out.println(total);
        }
    }
}
