import java.util.*;

/**
 * Created by Alvin on 5/28/2016.
 */
public class KruskalMST {
    static HashMap<Integer, ArrayList<Edge>> graph;
    static HashSet<Integer> vertices;
    static ArrayList<Edge> allEdges;

    public static void main(String[] args) {
        init();

        addEdge(1, 2, 4);
        addEdge(1, 3, 1);
        addEdge(2, 5, 1);
        addEdge(2, 6, 3);
        addEdge(2, 4, 2);
        addEdge(6, 5, 2);
        addEdge(6, 4, 3);
        addEdge(4, 7, 2);
        addEdge(3, 4, 5);
        addEdge(3, 7, 8);
        ArrayList<Edge> list = getMST();
        for(Edge current: list) {
            System.out.println(current.start + " " + current.end + " " + current.weight);
        }
    }

    public static ArrayList<Edge> getMST() {
        ArrayList<Edge> solutionList = new ArrayList<>();
        Collections.sort(allEdges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return new Integer(o1.weight).compareTo(o2.weight);
            }
        });

        for (int current : vertices) {
            DisjointSet.createSet(current);
        }

        for(Edge currentEdge : allEdges) {

            // Obtain the sets of two vertices of the edge
            int startRoot = DisjointSet.findSet(currentEdge.start);
            int endRoot = DisjointSet.findSet(currentEdge.end);

            // Check if the vertices are in same set or different set
            // If vertices are in same set then ignore the edge
            // Will create a cycle or unnecessary edge
            if(startRoot == endRoot) {
                continue;
            } else {
                solutionList.add(currentEdge);
                DisjointSet.unionSet(currentEdge.start, currentEdge.end);
            }
        }

        return solutionList;
    }

    public static void init() {
        graph = new HashMap<>();
        allEdges = new ArrayList<>();
        vertices = new HashSet<>();
    }


    public static void addEdge(int start, int end, int weight) {
        ArrayList<Edge> list = graph.containsKey(start) ? graph.get(start) : new ArrayList<>();
        Edge currentEdge = new Edge(start, end, weight);
        allEdges.add(currentEdge);
        vertices.add(start);
        vertices.add(end);
        list.add(currentEdge);
        graph.put(start, list);
    }


    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int s, int e, int weight) {
            this.start = s;
            this.end = e;
            this.weight = weight;
        }
    }

    static class DisjointSet {
        static HashMap<Integer, Node> map = new HashMap<>();

        public static void createSet(int data) {
            Node node = new Node(data, 0);
            node.parent = node;
            map.put(data, node);
        }

        public static int findSet(int data) {
            int parentData = map.get(data).parent.data;
            if (parentData == data) {
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
}
