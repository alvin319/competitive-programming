import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 8/20/16.
 */

public class Codeforces_round_367_div_2_VasiliyMultiset {

    public static Node root;

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        root = new Node();
        for (int i = 0; i < count; i++) {
            String[] array = input.nextLine().split(" ");
            int value = Integer.parseInt(array[1]);
            String binaryString = Integer.toBinaryString(value);
            String prepend = "";
            for (int j = 1; j <= 30 - (binaryString.length()); j++) {
                prepend += "0";
            }
            binaryString = prepend + binaryString;
            if (array[0].equals("+")) {
                constructTree(0, binaryString, value, root);
            } else if (array[0].equals("?")) {
                int bestValue = findValue(0, binaryString, root);
                System.out.println((value ^ bestValue) > value ? value ^ bestValue : value);
            } else {
                deleteValue(0, binaryString, value, root);
            }
        }
        Node wat = root;
        for (int i = 0; i < "00000000000000000000000000".length(); i++) {
            wat = wat.rightZero;
        }
        System.out.println(wat.leftOne.rightZero.rightZero.rightZero);

        System.out.println("answer: " + findValue(0, "000000000000000000000000001000", root));
        out.close();
    }

    public static void deleteValue(int index, String binaryString, int value, Node currentNode) {
        char currentChar = binaryString.charAt(index);
        if (index == binaryString.length() - 1) {
            if (currentChar == '1') {
                int counter = currentNode.leftOne.map.get(value);
                if (counter - 1 == 0) {
                    currentNode.leftOne.map.remove(value);
                } else {
                    currentNode.leftOne.map.put(value, counter - 1);
                }
                if (currentNode.leftOne.map.isEmpty()) {
                    currentNode.leftOne = null;
                }
                if (currentNode.leftOne == null && currentNode.rightZero == null && (currentNode.map == null || currentNode.map.isEmpty())) {
                    currentNode = null;
                }
            } else {
                int counter = currentNode.rightZero.map.get(value);
                if (counter - 1 == 0) {
                    currentNode.rightZero.map.remove(value);
                } else {
                    currentNode.rightZero.map.put(value, counter - 1);
                }
                if (currentNode.rightZero.map.isEmpty()) {
                    currentNode.rightZero = null;
                }
                if (currentNode.rightZero == null && currentNode.rightZero == null && (currentNode.map == null || currentNode.map.isEmpty())) {
                    currentNode = null;
                }
            }
        } else {
            if (currentChar == '1') {
                deleteValue(index + 1, binaryString, value, currentNode.leftOne);
                System.out.println("ind: " + index + " " + currentNode.leftOne + " " + currentNode.rightZero + " ");
                if (currentNode.leftOne == null && currentNode.rightZero == null && (currentNode.map == null || currentNode.map.isEmpty())) {
                    currentNode = null;
                }
            } else {
                deleteValue(index + 1, binaryString, value, currentNode.rightZero);
                if (currentNode.leftOne == null && currentNode.rightZero == null && (currentNode.map == null || currentNode.map.isEmpty())) {
                    currentNode = null;
                }
            }
        }
    }

    public static int findValue(int index, String binaryString, Node currentNode) {
        if (index == binaryString.length() - 1) {
            char currentChar = binaryString.charAt(index);
            if (currentChar == '0') {
                if (currentNode.leftOne != null) {
                    return findValue(index, binaryString, currentNode.leftOne);
                } else if (currentNode.rightZero != null) {
                    return findValue(index, binaryString, currentNode.rightZero);
                }
            } else {
                if (currentNode.rightZero != null) {
                    return findValue(index, binaryString, currentNode.rightZero);
                } else if (currentNode.leftOne != null) {
                    return findValue(index, binaryString, currentNode.leftOne);
                }
            }
            int bestValue = 0;
            if (currentNode.map != null) {
                for (int value : currentNode.map.keySet()) {
                    bestValue = value;
                    break;
                }
            }
            return bestValue;
        }
        char currentChar = binaryString.charAt(index);
        if (currentChar == '1') {
            if (currentNode.rightZero != null) {
                return findValue(index + 1, binaryString, currentNode.rightZero);
            } else if (currentNode.leftOne != null) {
                return findValue(index + 1, binaryString, currentNode.leftOne);
            }
        } else {
            if (currentNode.leftOne != null) {
                return findValue(index + 1, binaryString, currentNode.leftOne);
            } else if (currentNode.rightZero != null) {
                return findValue(index + 1, binaryString, currentNode.rightZero);
            }
        }
        return 0;
    }

    public static void constructTree(int index, String binaryString, int value, Node currentNode) {
        if (index == binaryString.length() - 1) {
            if (currentNode == root) {
                char lastChar = binaryString.charAt(index);
                if (lastChar == '1') {
                    if (root.leftOne == null) {
                        root.leftOne = new Node();
                        root.leftOne.map = new HashMap<>();
                    }
                    root.leftOne.map.put(1, root.leftOne.map.containsKey(1) ? root.leftOne.map.get(1) + 1 : 1);
                }
            } else {
                char currentChar = binaryString.charAt(index);
                if (currentChar == '1') {
                    if (currentNode.leftOne == null) {
                        currentNode.leftOne = new Node();
                        currentNode.leftOne.map = new HashMap<>();
                    }
                    currentNode.leftOne.map.put(value, currentNode.leftOne.map.containsKey(value) ? currentNode.leftOne.map.get(value) + 1 : 1);
                } else {
                    if (currentNode.rightZero == null) {
                        currentNode.rightZero = new Node();
                        currentNode.rightZero.map = new HashMap<>();
                    }
                    currentNode.rightZero.map.put(value, currentNode.rightZero.map.containsKey(value) ? currentNode.rightZero.map.get(value) + 1 : 1);
                }
            }
        } else {
            char currentChar = binaryString.charAt(index);
            if (currentChar == '1') {
                if (currentNode.leftOne == null) {
                    currentNode.leftOne = new Node();
                }
                constructTree(index + 1, binaryString, value, currentNode.leftOne);
            } else if (currentChar == '0') {
                if (currentNode.rightZero == null) {
                    currentNode.rightZero = new Node();
                }
                constructTree(index + 1, binaryString, value, currentNode.rightZero);
            }
        }
    }

    static class Node {
        Node leftOne;
        Node rightZero;
        HashMap<Integer, Integer> map;

        public Node() {
            map = null;
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