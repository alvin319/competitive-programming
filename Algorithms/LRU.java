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
//        Node currentNode = cache.head;
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
//        out.println("capacity: " + cache.capacity);
//        out.println("1: " + cache.get(1));
//        out.println("7: " + cache.get(7));
//        out.println("head : " + cache.head.value);
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
        Node head;
        Node tail;
        int capacity;

        public LRUCache(int currentCapacity) {
            map = new HashMap<>();
            head = null;
            tail = null;
            capacity = currentCapacity;
        }

        public String toString() {
            Node currentNode = head;
            StringBuilder builder = new StringBuilder();
            while (currentNode != null) {
                builder.append(!builder.toString().equals("") ? " " + currentNode.value : currentNode.value);
                currentNode = currentNode.next;
            }
            return builder.toString();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node currentNode = map.get(key);
                remove(currentNode);
                setHead(currentNode);
                return currentNode.value;
            } else {
                return -1;
            }
        }

        public void set(int key, int value) {
            if (map.containsKey(key)) {
                Node currentNode = map.get(key);
                currentNode.value = value;
                remove(currentNode);
                setHead(currentNode);
                map.put(key, currentNode);
            } else {
                if (capacity == map.keySet().size()) {
                    int tailKey = tail.key;
                    remove(tail);
                    map.remove(tailKey);
                }
                if (capacity > map.keySet().size()) {
                    Node newNode = new Node(key, value);
                    setHead(newNode);
                    map.put(key, newNode);
                }
            }
        }

        private void remove(Node node) {
            if (node.previous != null && node.next != null) {
                node.previous.next = node.next;
                node.next.previous = node.previous;
            } else if (node.previous == null) {
                head = node.next;
                if (head != null) {
                    head.previous = null;
                }
            } else {
                tail = node.previous;
                if (tail != null) {
                    tail.next = null;
                }
            }
        }

        private void setHead(Node node) {
            if (head == null) {
                head = node;
            } else {
                Node previousHead = head;
                head = node;
                previousHead.previous = head;
                head.next = previousHead;
                head.previous = null;
            }
            if (tail == null) {
                tail = node;
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