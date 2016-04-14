import java.util.*;

public class Codeforces_round_189_div_2_PingPong {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int queries = input.nextInt();
        HashMap<Integer, Number> pingList = new HashMap<>();
        ArrayList<Integer> queryList[] = new ArrayList[5000];
        int starting = 1;
        for (int i = 1; i <= queries; i++) {
            int type = input.nextInt();
            int x = input.nextInt();
            int y = input.nextInt();
            if (type == 1) {
                for (int key : pingList.keySet()) {
                    if ((pingList.get(key).begin < x && x < pingList.get(key).end) || (pingList.get(key).begin < y
                            && y < pingList.get(key).end)) {
                        if (queryList[starting] == null)
                            queryList[starting] = new ArrayList<Integer>();
                        queryList[starting].add(key);
                    }
                    if ((x < pingList.get(key).begin && pingList.get(key).begin < y) || (x < pingList.get(key).end &&
                            pingList.get(key).end < y)) {
                        if (queryList[key] == null)
                            queryList[key] = new ArrayList<Integer>();
                        queryList[key].add(starting);
                    }
                }
                pingList.put(starting, new Number(x, y));
                starting++;
            } else {
                int answer = 0;
                int[] visited = new int[5000];
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.add(x);
                while (!queue.isEmpty()) {
                    int poll = queue.poll();
                    if (poll == y) {
                        answer = 1;
                        break;
                    }
                    if (queryList[poll] != null) {
                        for (int check : queryList[poll]) {
                            if (visited[check] == 0) {
                                visited[check] = 1;
                                queue.add(check);
                            }
                        }
                    }
                }
                System.out.println(answer == 1 ? "YES" : "NO");
            }
        }
    }

    static class Number {
        int begin;
        int end;

        public Number(int x, int y) {
            begin = x;
            end = y;
        }

        public boolean equals(Object n1) {
            Number n = (Number) n1;
            return begin == n.begin && end == n.end;
        }

    }
}
