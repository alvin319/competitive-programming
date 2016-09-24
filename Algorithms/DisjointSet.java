import java.util.HashMap;

/**
 * Created by Alvin on 5/28/2016.
 */
public class DisjointSet {

    static HashMap<Integer, Node> map = new HashMap<>();

    public static void createSet(int data) {
        Node node = new Node(data, 0);
        node.parent = node;
        map.put(data, node);
    }

    public static int findSet(int data) {
        int parentData = map.get(data).parent.data;
        if(parentData == data) {
            return data;
        } else {
            return findSet(parentData);
        }
    }

    public static boolean unionSet(int firstSet, int secondSet) {
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

    public static void main(String args[]) {
        createSet(1);
        createSet(2);
        createSet(3);
        createSet(4);
        createSet(5);
        createSet(6);
        createSet(7);

        unionSet(1, 2);
        unionSet(2, 3);
        System.out.println("parent: "  + findSet(3));
        unionSet(4, 5);
        System.out.println("parent: "  + findSet(5));
        unionSet(6, 7);
        System.out.println("parent: "  + findSet(7));
        unionSet(5, 6);
        System.out.println("parent: "  + findSet(7));
        System.out.println("parent: "  + findSet(2));
        unionSet(3, 7);
        for (int i = 1; i <= 7; i++) {
            System.out.println("findSet(i) = " + findSet(i));
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
