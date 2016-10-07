import java.util.HashSet;

/**
 * Created by WiNDWAY on 10/7/16.
 */
public class BinarySearchTreeValidation {

    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {

    }

    boolean checkBST(Node root) {
        set.add(root.data);
        return helper(root.left, Integer.MIN_VALUE, root.data) && helper(root.right, root.data, Integer.MAX_VALUE);
    }

    public static boolean helper(Node currentNode, int min, int max) {
        if (currentNode != null) {
            if (set.contains(currentNode.data)) {
                return false;
            } else {
                set.add(currentNode.data);
            }
            return currentNode.data > min && currentNode.data < max &&
                    helper(currentNode.left, min, currentNode.data) && helper(currentNode.right, currentNode.data, max);
        }
        return true;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
