import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by WiNDWAY on 9/21/15.
 */
public class Codeforces_round_265_div_1_RestoreCube {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Vertex> list = new ArrayList<Vertex>();
        for(int i = 0; i < 8; i++) {
            list.add(new Vertex(input.nextInt(), input.nextInt(), input.nextInt()));
        }
        if(startCube(list, 0)) {
            System.out.println("YES");
            for(Vertex x : list) {
                System.out.println(x.x + " " + x.y + " " + x.z);
            }
        } else {
            System.out.println("NO");
        }

    }

    public static boolean startCube(ArrayList<Vertex> list, int index) {

        if(index >= 8) {
            return vadliateCube(list);
        }

        // Exit condition where all points are satisfied as a cube or start looping with its orignal form first
        if(vadliateCube(list) || startCube(list, index + 1)) {
            return true;
        }

        Vertex alter = list.get(index);

        list.set(index, new Vertex(alter.x, alter.z, alter.y));
        if(startCube(list, index + 1)) {
            return true;
        }

        list.set(index, new Vertex(alter.y, alter.x, alter.z));
        if(startCube(list, index + 1)) {
            return true;
        }

        list.set(index, new Vertex(alter.y, alter.z, alter.x));
        if(startCube(list, index + 1)) {
            return true;
        }

        list.set(index, new Vertex(alter.z, alter.y, alter.x));
        if(startCube(list, index + 1)) {
            return true;
        }

        list.set(index, new Vertex(alter.z, alter.x, alter.y));
        if(startCube(list, index + 1)) {
            return true;
        }

        return false;
    }

    public static boolean vadliateCube(ArrayList<Vertex> list) {

        for (int i = 0; i < 8; i++) {
            int iteration = 0;
            long firstMin = Long.MAX_VALUE;
            long secondMin = Long.MAX_VALUE;
            int secondIteration = 0;
            for(int j = 0; j < 8; j++) {
                // Don't compare if they are having the same points
                if(j == i) continue;
                long diffDistance = list.get(i).diff(list.get(j));
                if(diffDistance == 0) {
                    return false;
                }
                if(diffDistance == secondMin) {
                    secondIteration++;
                } else if(diffDistance < firstMin) {
                    secondMin = firstMin;
                    firstMin = diffDistance;
                    secondIteration = iteration;
                    iteration = 1;
                } else if (diffDistance == firstMin) {
                    iteration++;
                } else if (diffDistance > firstMin && diffDistance < secondMin) {
                    secondMin = diffDistance;
                    secondIteration = 1;
                }
            }
            if(iteration != 3 || secondIteration != 3) {
                return false;
            }
        }
        return true;
    }
}

class Vertex {
    int x;
    int y;
    int z;

    public Vertex(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long diff(Vertex o) {
        long xDiff = (long)(o.x-x)*(o.x-x);
        long yDiff = (long)(o.y-y)*(o.y-y);
        long zDiff = (long)(o.z-z)*(o.z-z);
        return xDiff + yDiff + zDiff;
    }
}