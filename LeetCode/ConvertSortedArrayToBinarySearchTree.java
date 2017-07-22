import java.io.*;
import java.util.StringTokenizer;


public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] sortedArray = new int[]{1, 2, 3, 5, 8, 9, 10};
        Node root = binarySearchTree(sortedArray);
        System.out.println("root = " + root.value);
        out.close();
    }

    static Node binarySearchTree(int[] array) {
        return buildTree(array, 0, array.length);
    }

    // Recursively building up the tree, and always remember that the range is [start, end)
    static Node buildTree(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            Node newNode = new Node(array[mid]);
            newNode.left = buildTree(array, start, mid);
            newNode.right = buildTree(array, mid + 1, end);
            return newNode;
        }
        return null;
    }

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
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