import java.util.HashMap;

/**
 * Created by Alvin on 5/28/2016.
 */
public class UnionFindDisjointSet {

    public static void main(String args[]) {
        DisjointSet set = new DisjointSet();
        set.createSet(1);
        set.createSet(2);
        set.createSet(3);
        set.createSet(4);
        set.createSet(5);
        set.createSet(6);
        set.createSet(7);

        set.unionSet(1, 2);
        set.unionSet(2, 3);
        System.out.println("parent: " + set.findSet(3));
        set.unionSet(4, 5);
        System.out.println("parent: " + set.findSet(5));
        set.unionSet(6, 7);
        System.out.println("parent: " + set.findSet(7));
        set.unionSet(5, 6);
        System.out.println("parent: " + set.findSet(7));
        System.out.println("parent: " + set.findSet(2));
        set.unionSet(3, 7);
        for (int i = 1; i <= 7; i++) {
            System.out.println("findSet(" + i + ") = " + set.findSet(i));
        }
    }

    static class DisjointSet {

        HashMap<Integer, Node> map;

        public DisjointSet() {
            map = new HashMap<>();
        }

        public void createSet(int data) {
            Node node = new Node(data, 0);
            node.parent = node;
            map.put(data, node);
        }

        public int findSet(int data) {
            int parentData = map.get(data).parent.data;
            if (parentData == data) {
                return data;
            } else {
                return findSet(parentData);
            }
        }

        public boolean unionSet(int firstSet, int secondSet) {
            int firstParentID = findSet(firstSet);
            int secondParentID = findSet(secondSet);
            Node firstParent = map.get(firstParentID);
            Node secondParent = map.get(secondParentID);

            // If they are part of same set do nothing
            if (firstParentID == secondParentID) {
                return false;
            }

            if (firstParent.rank > secondParent.rank) {
                secondParent.parent = firstParent;
            } else if (firstParent.rank < secondParent.rank) {
                firstParent.parent = secondParent;
            } else {
                firstParent.rank++;
                secondParent.parent = firstParent;
            }
            map.put(firstParentID, firstParent);
            map.put(secondParentID, secondParent);

            return true;
        }
    }

    static class Node {
        int data;
        Node parent;
        int rank;

        public Node(int data, int rank) {
            this.data = data;
            this.rank = rank;
        }
    }
}
