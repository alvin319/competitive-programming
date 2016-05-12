import java.io.*;

/**
 * Created by Alvin on 5/12/2016.
 */

public class UVa_11559_EventPlanning {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String current;
        while (true) {
            current = input.readLine();
            if(current==null || current.isEmpty()) {
                break;
            }
            String[] array = current.split(" ");
            int participant = i(array[0]);
            int budget = i(array[1]);
            int hotel = i(array[2]);
            int week = i(array[3]);
            Hotel[] hotel_list = new Hotel[hotel];
            for (int i = 0; i < hotel; i++) {
                hotel_list[i] = new Hotel(i(input.readLine()), week);
                String[] x = input.readLine().split(" ");
                for (int j = 0; j < x.length; j++) {
                    hotel_list[i].size[j] = i(x[j]);
                }
            }
            int cheapest = Integer.MAX_VALUE;
            for (Hotel x : hotel_list) {
                int[] size = x.size;
                for (int i = 0; i < size.length; i++) {
                    if(size[i] >= participant) {
                        if((participant * x.cost) <= budget) {
                            cheapest = Math.min(cheapest, participant * x.cost);
                        }
                    }
                }
            }
            if(cheapest == Integer.MAX_VALUE) {
                System.out.println("stay home");
            } else {
                System.out.println(cheapest);
            }
        }
    }

    public static int i(String x) {
        return Integer.parseInt(x);
    }
    public static class Hotel {
        int cost;
        int[] size;

        public Hotel(int cost, int size) {
            this.cost = cost;
            this.size = new int[size];
        }
    }

}

