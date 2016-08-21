import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 8/20/16.
 */

public class Codeforces_round_367_div_2_VasiliyMultiset {

    public static int global_id = 0;
    public static HashMap<Integer, Node> bMap = new HashMap<>();

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        Node currentNode = new Node();
        bMap.put(global_id++, currentNode);

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
                constructTree(binaryString, value);
            } else if (array[0].equals("?")) {
                int bestValue = findValue(binaryString);
                int answer = (value ^ bestValue) > value ? value ^ bestValue : value;
                System.out.println(answer);
            } else {
                deleteValue(binaryString, value);
            }
        }
        out.close();
    }

    public static void deleteValue(String binaryString, int value) {
        int currentID = 0;
        for (int i = 0; i < binaryString.length() - 1; i++) {
            char currentChar = binaryString.charAt(i);
            Node currentNode = bMap.get(currentID);
            if (currentChar == '1') {
                currentID = currentNode.leftOne;
            } else {
                currentID = currentNode.rightZero;
            }
        }
        int counter = bMap.get(currentID).map.get(value) - 1;
        if (counter > 0) {
            bMap.get(currentID).map.put(value, counter);
        } else {
            bMap.get(currentID).map.remove(value);
        }
        System.out.println(bMap.get(currentID).map);
        int recursionID = currentID;
        Node currentNode = bMap.get(recursionID);
        System.out.println(currentNode.leftOne);

        int index = binaryString.length() - 1;
        while ((currentNode.map == null || currentNode.map.isEmpty()) && currentNode.leftOne == -1 && currentNode.rightZero == -1) {
            System.out.println("deletion");
            Node parentNode = bMap.get(currentNode.parentID);
            char currentChar = binaryString.charAt(index);
            if (currentChar == '1') {
                parentNode.leftOne = -1;
            } else {
                parentNode.rightZero = -1;
            }
            bMap.remove(recursionID);
            currentNode = bMap.get(currentNode.parentID);
            recursionID = currentNode.parentID;
            index--;
        }
    }

    public static int findValue(String binaryString) {
        int currentID = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char currentChar = binaryString.charAt(i);
            Node currentNode = bMap.get(currentID);
            if (currentChar == '1') {
                if (currentNode.rightZero != -1) {
                    currentID = currentNode.rightZero;
                } else if (currentNode.leftOne != -1) {
                    currentID = currentNode.leftOne;
                }
            } else {
                if (currentNode.leftOne != -1) {
                    currentID = currentNode.leftOne;
                } else if (currentNode.rightZero != -1) {
                    currentID = currentNode.rightZero;
                }
            }
        }
        int bestValue = 0;
        if (bMap.get(currentID).map != null) {
            for (int value : bMap.get(currentID).map.keySet()) {
                bestValue = value;
                break;
            }
        }
        return bestValue;
    }

    public static void constructTree(String binaryString, int value) {
        int currentID = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char currentChar = binaryString.charAt(i);
            Node currentNode = bMap.get(currentID);
            if (currentChar == '1') {
                if (currentNode.leftOne == -1) {
                    Node nextNode = new Node();
                    nextNode.parentID = currentID;
                    currentNode.leftOne = global_id;
                    bMap.put(global_id++, nextNode);
                }
                currentID = currentNode.leftOne;
            } else {
                if (currentNode.rightZero == -1) {
                    Node nextNode = new Node();
                    nextNode.parentID = currentID;
                    currentNode.rightZero = global_id;
                    bMap.put(global_id++, nextNode);
                }
                currentID = currentNode.rightZero;
            }
            if (i == binaryString.length() - 1) {
                currentNode.leftOne = -1;
                currentNode.rightZero = -1;
                currentNode.map = currentNode.map == null ? new HashMap<>() : currentNode.map;
                currentNode.map.put(value, currentNode.map.containsKey(value) ? currentNode.map.get(value) + 1 : 1);
                bMap.put(currentID, currentNode);
            }
        }
    }

    static class Node {
        int parentID;
        int leftOne;
        int rightZero;
        HashMap<Integer, Integer> map;

        public Node() {
            map = null;
            leftOne = -1;
            rightZero = -1;
            parentID = -1;
        }

        public String toString() {
            return "l: " + leftOne + " r: " + rightZero + " p: " + parentID;
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