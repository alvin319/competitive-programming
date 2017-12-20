/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    public static HashMap<Integer, Integer> map;
    public static int best;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        best = 0;
        helper(root);
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int key : map.keySet()) {
            if (map.get(key) == best) {
                list.add(key);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int total = helper(root.left) + helper(root.right) + root.val;
        int count = map.getOrDefault(total, 0);
        map.put(total, count + 1);
        best = Math.max(best, map.get(total));
        return total;
    }
}
