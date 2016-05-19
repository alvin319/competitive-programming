import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/18/2016.
 */

public class Codeforces_round_353_div_2_TreeConstruction {

    public static Node root;
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int nodes = input.nextInt() - 1;
        root = new Node(input.nextInt());
        for (int i = 0; i < nodes; i++) {
            int current = input.nextInt();
            insertNode(root, current);
        }

        out.close();
    }

    public static void insertNode(Node root, int value) {
        if(value > root.value) {
            if(root.right == null) {
                root.right = new Node(value);
                out.print(root.value + " ");
            } else {
                insertNode(root.right, value);
            }
        } else {
            if(root.left == null) {
                root.left = new Node(value);
                out.print(root.value + " ");
            } else {
                insertNode(root.left, value);
            }
        }
    }

    static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
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

