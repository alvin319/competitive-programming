import java.util.Scanner;

public class Capacity {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int count = input.nextInt();

        for (int i = 1; i <= count; i++) {

            int number = input.nextInt();
            int size = input.nextInt();

            int[] profit = new int[number + 1];
            int[] weight = new int[number + 1];

            for (int n = 1; n <= number; n++) {
                weight[n] = input.nextInt();
                profit[n] = input.nextInt();
            }

            int[][] opt = new int[number+1][size+1];
            boolean[][] sol = new boolean[number+1][size+1];

            for (int n = 1; n <= number; n++) {
                for (int w = 1; w <= size; w++) {

                    int option1 = opt[n - 1][w];
                    int option2 = Integer.MIN_VALUE;
                    if (weight[n] <= w)
                        option2 = profit[n] + opt[n - 1][w - weight[n]];

                    opt[n][w] = Math.max(option1, option2);
                    sol[n][w] = (option2 > option1);
                }
            }

            boolean[] take = new boolean[number + 1];
            for (int n = number, w = size; n > 0; n--) {
                if (sol[n][w]) {
                    take[n] = true;
                    w = w - weight[n];
                } else {
                    take[n] = false;
                }
            }

            int total = 0;

            for(int check = 1; check < take.length; check++) {
                if(take[check])
                    total += profit[check];
            }

            System.out.println(total);
        }
    }
}
