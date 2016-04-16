import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 2/22/16.
 */
public class MilkPails {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int xCount = m / x;
        int yCount = m / y;
        int maxMilk = Integer.MIN_VALUE;
        for (int i = 0; i <= xCount; i++) {
            for (int j = 0; j <= yCount; j++) {
                int current = i * x + j * y;
                if(current <= m)
                    maxMilk = Math.max(current, maxMilk);
            }
        }
        pw.println(maxMilk);
        pw.close();
    }
}