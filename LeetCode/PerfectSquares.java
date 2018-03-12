import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int capped = (int) Math.sqrt(n + 1);
        int[] possible = new int[capped + 1];
        for (int i = 0; i < possible.length; i++) {
            possible[i] = (int) (Math.pow(i, 2));
        }
        int[] answers = new int[n + 1];
        Arrays.fill(answers, Integer.MAX_VALUE - 500);
        answers[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int denomination : possible) {
                if (i - denomination >= 0) {
                    answers[i] = Math.min(answers[i], answers[i - denomination] + 1);
                }
            }
        }

        return answers[answers.length - 1];
    }
}