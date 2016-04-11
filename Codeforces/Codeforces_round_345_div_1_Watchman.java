import java.util.*;

/**
 * Created by Alvin on 4/9/2016.
 */
public class Codeforces_round_345_div_1_Watchman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pair = input.nextInt();
        HashMap<Long, Long> xPlane = new HashMap<>();
        HashMap<Long, Long> yPlane = new HashMap<>();
        HashMap<Point, Long> points = new HashMap<>();
        for (int i = 0; i < pair; i++) {
            long x = input.nextLong();
            long y = input.nextLong();
            if(!xPlane.containsKey(x)) {
                xPlane.put(x, (long)1);
            } else {
                xPlane.put(x, xPlane.get(x) + 1);
            }
            if(!yPlane.containsKey(y)) {
                yPlane.put(y, (long)1);
            } else {
                yPlane.put(y, yPlane.get(y) + 1);
            }
            Point current = new Point(x, y);
            if(!points.containsKey(current)) {
                points.put(current, (long)1);
            } else {
                points.put(current, points.get(current) + 1);
            }
        }
        long summation = 0;
        for(long x : xPlane.keySet()) {
            long count = xPlane.get(x);
            summation += (count * (count - 1)) / 2;
        }
        for(long y : yPlane.keySet()) {
            long count = yPlane.get(y);
            summation += (count * (count - 1)) / 2;
        }
        for(Point current : points.keySet()) {
            long count = points.get(current);
            summation -= (count * (count - 1)) / 2;
        }
        System.out.println(summation);
    }
}

class Point {
    long x;
    long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
