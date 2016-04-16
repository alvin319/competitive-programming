import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 2/22/16.
 */
public class CircularBarn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int next = Integer.parseInt(br.readLine());
            System.out.println(next);
        }
    }
}
