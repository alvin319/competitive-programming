
/**
 * Created by WiNDWAY on 4/13/16.
 */

public class GCDSegmentTree {
    public static void main(String[] args) {
        long[] array = {3, 6, 7, 8, 32, 36};
        GCDSTree current = new GCDSTree(array.length);
        for (int i = 0; i < array.length; i++) {
            current.update(i, array[i]);
        }
        System.out.println(current.query(4, 5));
    }
}
class GCDSTree {

    private long tree[];
    int treeSize;

    public GCDSTree(int n) {
        tree = new long[4 * n];
        this.treeSize = n;
    }

    public void update(int index, long value) {
        constructTree(0, treeSize - 1, 0, index, value);
    }

    public void constructTree(int startIndex, int endIndex, int currentIndex, int destinationIndex, long value) {
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
        tree[currentIndex] = gcd(tree[2 * currentIndex + 1], tree[2 * currentIndex + 2]);
    }

    public long query(int startRange, int endRange) {
        return get(0, treeSize - 1, 0, startRange, endRange);
    }

    public long get(int nodeStart, int nodeEnd, int currentIndex, int startRange, int endRange) {
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
        return gcd(get(nodeStart, midIndex, 2 * currentIndex + 1, startRange, midIndex), get(midIndex + 1, nodeEnd, 2 * currentIndex + 2, midIndex + 1, endRange));
    }

    public long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
}