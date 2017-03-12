import java.util.*;

/**
 * Created by alvindeng on 3/24/17.
 */

public class DeserializeBinaryTree {
    public static void main(String[] args) {
        String line = "1 5 # # 2 3 2 # # 7 # # 1 5 # # 1 # #";
        int searchValue = 5;
        StringTokenizer st = new StringTokenizer(line);
        if (line.equals("#")) {
            System.out.println("It's an empty tree.");
        } else {
            Node rootNode = constructTree(st);
            System.out.println(getPath(rootNode, searchValue));
        }
    }


    public static ArrayList<String> getPath(Node rootNode, int searchValue) {
        ArrayList<String> answer = new ArrayList<>();
        Queue<State> queue = new LinkedList<>();
        HashSet<Node> freshSet = new HashSet<>();
        queue.add(new State(rootNode, 0, ""));
        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            if (currentState.currentNode != null) {
                currentState.currentSum += Integer.parseInt(currentState.currentNode.value);
                currentState.currentPath += currentState.currentNode.value;
                if (currentState.currentSum == searchValue) {
                    answer.add(currentState.currentPath);
                } else {
                    queue.add(new State(currentState.currentNode.leftNode, currentState.currentSum, currentState.currentPath));
                    queue.add(new State(currentState.currentNode.rightNode, currentState.currentSum, currentState.currentPath));
                    if (!freshSet.contains(currentState.currentNode.leftNode)) {
                        freshSet.add(currentState.currentNode.leftNode);
                        queue.add(new State(currentState.currentNode.leftNode, 0, ""));
                    }
                    if (!freshSet.contains(currentState.currentNode.rightNode)) {
                        freshSet.add(currentState.currentNode.rightNode);
                        queue.add(new State(currentState.currentNode.rightNode, 0, ""));
                    }
                }
            }
        }
        return answer;
    }

    static class State {
        Node currentNode;
        int currentSum;
        String currentPath;

        public State(Node node, int sum, String path) {
            currentNode = node;
            currentSum = sum;
            currentPath = path;
        }
    }

    static Node constructTree(StringTokenizer st) {
        if (st.hasMoreTokens()) {
            String currentToken = st.nextToken();
            if (currentToken.equals("#")) {
                return null;
            } else {
                Node currentNode = new Node(currentToken);
                currentNode.leftNode = constructTree(st);
                currentNode.rightNode = constructTree(st);
                return currentNode;
            }
        }
        return null;
    }

    static class Node {
        String value;
        Node leftNode;
        Node rightNode;

        public Node(String value) {
            this.value = value;
            leftNode = null;
            rightNode = null;
        }
    }
}
