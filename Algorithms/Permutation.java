import java.util.ArrayList;

/**
 * Created by WiNDWAY on 1/30/16.
 */

public class Permutation {
    public static void main(String[] args) {
        String testCase = "abc";
        ArrayList<Character> testSet = new ArrayList<>();
        for(Character x : testCase.toCharArray()) {
            testSet.add(x);
        }
        System.out.println("Combination");
        getCombination(testSet, "", 0);
        System.out.println("Permutation");
        getPermutation(testSet, "");

        String[][] matrix = {{"a","b","c"}, {"a","b","c"}, {"a", "b", "c"}};
        System.out.println("Google Permutation");
        googlePermutation(matrix, "", 0);
    }

    public static void getPermutation(ArrayList<Character> current, String prefix) {
        if(current.size() == 0) {
          System.out.println(prefix);
        } else {
            for (int i = 0; i < current.size(); i++) {
                String newString = prefix + current.get(i);
                ArrayList<Character> newSet = new ArrayList<>(current);
                newSet.remove(i);
                getPermutation(newSet, newString);
            }
        }
    }

    public static void getCombination(ArrayList<Character> current, String prefix, int index) {
        if(index == current.size()) {
            System.out.println(prefix);
        } else {
            String newString = prefix;
            getCombination(current, newString, index + 1); // not choosing
            char leftOver = current.get(index);
            newString += leftOver;
            getCombination(current, newString, index + 1); // choosing
        }
    }

    public static void googlePermutation(String[][] matrix, String prefix, int outerIndex) {
        if (outerIndex == matrix.length) {
            System.out.println(prefix);
        } else {
            String[] current = matrix[outerIndex];
            for (int j = 0; j < current.length; j++) {
                googlePermutation(matrix, prefix + current[j], outerIndex + 1);
            }
        }
    }
}
