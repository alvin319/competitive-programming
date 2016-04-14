import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by WiNDWAY on 4/8/16.
 */
public class Codeforces_round_343_div_2_BabaeiAndBirthdayCake {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cake = input.nextInt();
        double[][] cache = new double[cake][2];
        for (int i = 0; i < cake; i++) {
            int r = input.nextInt();
            int h = input.nextInt();
            cache[i][0] = Math.pow(r, 2) * h;
            cache[i][1] = i;
        }
        Arrays.sort(cache, new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                if (a[0] != b[0])
                    return Double.compare(a[0], b[0]);
                return Double.compare(b[1], a[1]);
            }
        });
        SegmentTree tree = new SegmentTree(cache.length);
        double solution = 0;
        for (int i = 0; i < cache.length; i++) {
            double max = tree.query(0, (int) cache[i][1]);
            int index = (int) cache[i][1];
            double value = max + cache[i][0];
            tree.update(index, value);
            solution = Math.max(solution, value);
        }
        System.out.println(Math.PI * solution);
    }

    static class SegmentTree {

        private double tree[];
        int treeSize;

        public SegmentTree(int n) {
            tree = new double[4 * n];
            this.treeSize = n;
        }

        public void update(int index, double value) {
            constructTree(0, treeSize - 1, 0, index, value);
        }

        public void constructTree(int startIndex, int endIndex, int currentIndex, int destinationIndex, double value) {
            if(startIndex == endIndex) {
                tree[currentIndex] = value;
                return;
            }
            int midIndex = (startIndex + endIndex) >> 1;
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            if(destinationIndex <= midIndex) {
                constructTree(startIndex, midIndex, leftChildIndex, destinationIndex, value);
            } else {
                constructTree(midIndex + 1, endIndex, rightChildIndex, destinationIndex, value);
            }
            tree[currentIndex] = Math.max(tree[2 * currentIndex + 1], tree[2 * currentIndex + 2]);
        }

        public double query(int startRange, int endRange) {
            return get(0, treeSize - 1, 0, startRange, endRange);
        }

        public double get(int nodeStart, int nodeEnd, int currentIndex, int startRange, int endRange) {
            if (nodeStart == startRange && nodeEnd == endRange) {
                return tree[currentIndex];
            }
            int midIndex = (nodeStart + nodeEnd) >> 1;

            if(endRange <= midIndex) {
                return get(nodeStart, midIndex, 2 * currentIndex + 1, startRange, endRange);
            }
            if(startRange > midIndex) {
                return get(midIndex + 1, nodeEnd, 2 * currentIndex + 2, startRange, endRange);
            }
            return Math.max(get(nodeStart, midIndex, 2 * currentIndex + 1, startRange, midIndex), get(midIndex + 1, nodeEnd, 2 * currentIndex + 2, midIndex + 1, endRange));
        }
    }
}
