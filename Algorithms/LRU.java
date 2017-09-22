import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 7/6/17.
 */

public class LRU {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
//        LRUCache cache = new LRUCache(4);
//        cache.set(1, 1);
//        cache.set(2, 2);
//        cache.set(3, 3);
//        cache.set(1, 1);
//        cache.set(4, 4);
//        cache.set(5, 5);
//        Node currentNode = cache.currentHead;
//        while (currentNode != null) {
//            out.println(currentNode.value);
//            currentNode = currentNode.next;
//        }
//        out.println("second part");
//        cache = new LRUCache(3);
//        cache.set(1, 22);
//        cache.set(2, 23);
//        cache.set(3, 27);
//        cache.set(4, 29);
//        cache.set(5, 28);
//        cache.set(6, 21);
//        cache.set(7, 24);
//        out.println("currentCapacity: " + cache.currentCapacity);
//        out.println("1: " + cache.get(1));
//        out.println("7: " + cache.get(7));
//        out.println("currentHead : " + cache.currentHead.value);
        int n = input.nextInt();
        LRUCache cache = new LRUCache(9);
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            String[] info = line.split(" ");
            out.println(line);
            if (line.contains("GET")) {
                int num = Integer.parseInt(info[1]);
                out.println("SHOWING " + cache.get(num));
            } else {
                int key = Integer.parseInt(info[1]);
                int value = Integer.parseInt(info[2]);
                cache.set(key, value);
            }
            out.println("Queue: " + cache.toString());
            out.println();
        }
        out.close();
    }

    static class Node {
        Node previous;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            previous = null;
            next = null;
        }
    }

    static class LRUCache {
        HashMap<Integer, Node> map;
        Node currentHead;
        Node currentTail;
        int currentCapacity;

        public LRUCache(int currentCapacity) {
            map = new HashMap<>();
            currentHead = null;
            currentTail = null;
            this.currentCapacity = currentCapacity;
        }

        public String toString() {
            Node currentNode = currentHead;
            StringBuilder builder = new StringBuilder();
            while (currentNode != null) {
                builder.append(builder.toString().equals("") ? currentNode.value : " " + currentNode.value);
                currentNode = currentNode.next;
            }
            return builder.toString();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node currentNode = map.get(key);
                removeNode(currentNode);
                setHeadNode(currentNode);
                return currentNode.value;
            } else {
                return -1;
            }
        }

        public void set(int key, int value) {
            if (map.containsKey(key)) {
                Node currentNode = map.get(key);
                currentNode.value = value;
                removeNode(currentNode);
                setHeadNode(currentNode);
                map.put(key, currentNode);
            } else {
                if (currentCapacity == map.keySet().size()) {
                    int tailKey = currentTail.key;
                    removeNode(currentTail);
                    map.remove(tailKey);
                }
                if (currentCapacity > map.keySet().size()) {
                    Node newNode = new Node(key, value);
                    setHeadNode(newNode);
                    map.put(key, newNode);
                }
            }
        }

        private void removeNode(Node node) {
            if (node.previous != null && node.next != null) { // Node is in between 2 nodes
                node.previous.next = node.next;
                node.next.previous = node.previous;
            } else if (node.previous == null) { // Head
                currentHead = node.next;
                if (currentHead != null) {
                    currentHead.previous = null;
                }
            } else { // Tail
                currentTail = node.previous;
                currentTail.next = null;
            }
        }

        private void setHeadNode(Node node) {
            if (currentHead == null) { // No currentHead node, proceed to set the node to be the currentHead
                currentHead = node;
            } else { // Head node exists, proceed to move it to the next node
                Node previousHead = currentHead;
                currentHead = node;
                previousHead.previous = currentHead;
                currentHead.next = previousHead;
                currentHead.previous = null;
            }
            if (currentTail == null) { // If the currentTail node doesn't exist, then the node should be currentTail as well
                currentTail = node;
            }
        }
    }

    public static PrintWriter out;

    public static class FScanner {
        BufferedReader br;
        StringTokenizer st;

        public FScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}