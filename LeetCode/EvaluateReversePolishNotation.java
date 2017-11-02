import java.math.*;
import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> list = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        for (String x : tokens) {
            if (!set.contains(x)) {
                list.add(Integer.parseInt(x));
            } else {
                int second = list.removeLast();
                int first = list.removeLast();
                switch (x) {
                    case "+": {
                        list.add(first + second);
                    } break;
                    case "-": {
                        list.add(first - second);
                    } break;
                    case "*": {
                        list.add(first * second);
                    } break;
                    default: {
                        list.add(first / second);
                    }
                }
            }
        }
        
        return list.removeLast();
    }
}