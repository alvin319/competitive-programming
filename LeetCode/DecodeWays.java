public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(numDecodings("10"));
    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if ("".equals(s) || "0".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i <= s.length(); i++) {
            String first = String.valueOf(s.charAt(i - 1));
            if (1 <= Integer.parseInt(first) && Integer.parseInt(first) <= 9) {
                dp[i] += dp[i - 1];
            }
            if (i - 2 >= 0) {
                String second = s.substring(i - 2, i);
                if (10 <= Integer.parseInt(second) && Integer.parseInt(second) <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }
}