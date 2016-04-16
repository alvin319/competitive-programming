import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by WiNDWAY on 2/22/16.
 */
public class LoadBalancing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int B = Integer.parseInt(split[1]);
        Coordinate[] list = new Coordinate[N];
        for (int i = 0; i < N; i++) {
            String[] result = br.readLine().split(" ");
            list[i] = new Coordinate(Integer.parseInt(result[0]), Integer.parseInt(result[1]));
        }
        int minNumber = Integer.MAX_VALUE;

        for (int li = 0; li < list.length; li++) {
            for (int lj = 0; lj < list.length; lj++) {
                int[] var = {-1, 1};
                for (int var_i = 0; var_i < var.length; var_i++) {
                    for (int var_j = 0; var_j < var.length; var_j++) {
                        int i = list[li].y + var[var_i];
                        int j = list[lj].x + var[var_j];
                        int[] size = new int[4];
                        for (int k = 0; k < list.length; k++) {
                            Coordinate current = list[k];
                            if (current.x < i && current.y > j)
                                size[0]++;
                            else if (current.x > i && current.y > j)
                                size[1]++;
                            else if (current.x < i && current.y < j)
                                size[2]++;
                            else if (current.x > i && current.y < j)
                                size[3]++;
                        }

                        Arrays.sort(size);
                        minNumber = Math.min(minNumber, size[3]);
                    }
                }
            }
        }
        pw.println(minNumber);
        pw.close();
    }

    public static class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
