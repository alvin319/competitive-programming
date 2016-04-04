
import java.util.*;

/**
 * Created by Alvin on 4/4/2016.
 */
public class Codeforces_IndiaHack_2016_BearAndThreeBalls {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        TreeSet<Integer> balls = new TreeSet<Integer>();
        for (int i = 0; i < count; i++) {
            balls.add(input.nextInt());
        }
        ArrayList<Integer> ballList = new ArrayList<Integer>(balls);
        boolean found = false;
        for (int i = 0; i < ballList.size(); i++) {
            if(i + 2 < ballList.size()) {
                int first = ballList.get(i);
                int second = ballList.get(i+1);
                int third = ballList.get(i+2);
                int difference = Math.max(Math.abs(first - second), Math.max(Math.abs(second - third), Math.abs(first - third)));
                if(difference <= 2) {
                    found = true;
                    break;
                }
            }
        }
        if(found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
