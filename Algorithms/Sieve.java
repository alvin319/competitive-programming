import java.util.Arrays;

class Sieve {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("The prime array " + Arrays.toString(getSieve(n)));
    }

    static boolean[] getSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int factor = 2; factor * factor <= n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor; factor * j <= n; j++) {
                    isPrime[factor * j] = false;
                }
            }
        }

        return isPrime;
    }
}