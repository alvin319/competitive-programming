import java.util.*;

/**
 * Created by Alvin on 10/20/2015.
 */
public class Codeforces_round_303_div_2_Woodcutters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        LinkedList<Pair> treeList = new LinkedList<Pair>();
        ArrayList<Integer> rangeList = new ArrayList<Integer>();
        for(int i = 1; i <= count; i++) {
            int x = input.nextInt();
            rangeList.add(x);
            treeList.add(new Pair(x, input.nextInt()));
        }
        Collections.sort(treeList, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.h < o2.h ? -1 : 1;
            }
        });
    }
}

class Pair {
    int x;
    int h;

    public Pair(int x, int h) {
        this.x = x;
        this.h = h;
    }
}
