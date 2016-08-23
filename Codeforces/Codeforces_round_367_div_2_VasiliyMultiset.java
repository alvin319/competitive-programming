import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 8/20/16.
 */

public class Codeforces_round_367_div_2_VasiliyMultiset {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int iteration = input.nextInt();
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < iteration; i++) {
            String[] operations = input.nextLine().split(" ");
            int value = Integer.parseInt(operations[1]);
            if (operations[0].equals("+")) {
                tree.add(value);
            } else if (operations[0].equals("?")) {
                int bestFind = tree.find(value);
                out.println((bestFind ^ value) > value ? bestFind ^ value : value);
            } else {
                tree.delete(value);
            }
        }
        out.close();
    }

    static class BinaryTree {

        Node root;

        public BinaryTree() {
            root = new Node();
            root.parent = null;
            add(0);
        }

        private class Node {
            int count;
            Node leftOne, rightZero, parent;

            public Node() {
                count = 1;
            }
        }

        public static String paddingZero(String binaryString) {
            String prepend = "";
            for (int i = 1; i <= 32 - binaryString.length(); i++) {
                prepend += "0";
            }
            return prepend + binaryString;
        }

        private int[] getBitArray(int value) {
            String binaryString = paddingZero(Integer.toBinaryString(value));
            int[] array = new int[32];
            for (int i = 0; i < binaryString.length(); i++) {
                array[i] = binaryString.charAt(i) == '0' ? 0 : 1;
            }
            return array;
        }

        public void delete(int value) {
            int[] bitArray = getBitArray(value);
            Node currentNode = root;
            boolean removal = false;
            for (int i = 0; i < bitArray.length; i++) {
                currentNode = bitArray[i] == 1 ? currentNode.leftOne : currentNode.rightZero;
                if (i == bitArray.length - 1) {
                    currentNode.count--;
                    if (currentNode.count == 0) {
                        removal = true;
                    }
                }
            }

            while (removal) {
                if (currentNode.parent.leftOne == currentNode) {
                    currentNode.parent.leftOne = null;
                } else if (currentNode.parent.rightZero == currentNode) {
                    currentNode.parent.rightZero = null;
                }
                if (currentNode.parent.leftOne != null || currentNode.parent.rightZero != null) {
                    removal = false;
                } else {
                    currentNode = currentNode.parent;
                }
            }
        }

        public int find(int value) {
            int[] bitArray = getBitArray(value);
            int[] resultArray = new int[bitArray.length];
            Node currentNode = root;
            for (int i = 0; i < bitArray.length; i++) {
                if (bitArray[i] == 1) {
                    if (currentNode.rightZero != null) {
                        currentNode = currentNode.rightZero;
                    } else if (currentNode.leftOne != null) {
                        resultArray[i] = 1;
                        currentNode = currentNode.leftOne;
                    }
                } else {
                    if (currentNode.leftOne != null) {
                        resultArray[i] = 1;
                        currentNode = currentNode.leftOne;
                    } else if (currentNode.rightZero != null) {
                        currentNode = currentNode.rightZero;
                    }
                }
            }
            int solution = 0;
            for (int i = 0; i < resultArray.length; i++) {
                solution += resultArray[i] == 1 ? 1 << (31 - i) : 0;
            }
            return solution;
        }

        public void add(int value) {
            int[] bitArray = getBitArray(value);
            Node currentNode = root;
            boolean repeatedPath = false;
            for (int i = 0; i < bitArray.length; i++) {
                if (bitArray[i] == 1) {
                    if (currentNode.leftOne != null) {
                        currentNode = currentNode.leftOne;
                    } else {
                        Node newNode = new Node();
                        newNode.parent = currentNode;
                        currentNode.leftOne = newNode;
                        currentNode = newNode;
                        repeatedPath = true;
                    }
                } else {
                    if (currentNode.rightZero != null) {
                        currentNode = currentNode.rightZero;
                    } else {
                        Node newNode = new Node();
                        newNode.parent = currentNode;
                        currentNode.rightZero = newNode;
                        currentNode = newNode;
                        repeatedPath = true;
                    }
                }
            }
            if (!repeatedPath) {
                currentNode.count++;
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