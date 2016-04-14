import java.util.*;

/**
 * Created by WiNDWAY on 9/16/15.
 */
public class Codeforces_round_103_div_2_MissileSilos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cities = input.nextInt();
        int roads = input.nextInt();
        int capital = input.nextInt();
        ArrayList<City> nodes = new ArrayList<City>();
        HashSet<Integer> nodeList = new HashSet();
        for (int i = 0; i < cities; i++) {
            nodes.add(new City(i, Integer.MAX_VALUE));
            nodeList.add(i);
        }
        for (int i = 0; i < roads; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            int weight = input.nextInt();
            City startCity = nodes.get(start - 1);
            City endCity = nodes.get(end - 1);
            if (!startCity.edges.containsKey(end - 1)) {
                startCity.edges.put(end - 1, weight);
            } else {
                int storedValue = startCity.edges.get(end - 1);
                if (weight < storedValue) {
                    startCity.edges.put(end - 1, weight);
                }
            }
            if (!endCity.edges.containsKey(start - 1)) {
                endCity.edges.put(start - 1, weight);
            } else {
                int storedValue = endCity.edges.get(start - 1);
                if (weight < storedValue) {
                    endCity.edges.put(start - 1, weight);
                }
            }
        }
//        for(City x : nodes) {
//            System.out.println("C ID: " + x.id);
//            for(Integer y : x.edges.keySet()) {
//                System.out.println(x.id + " " + y + " " + x.edges.get(y));
//            }
//        }
        int capitalDistance = input.nextInt();
        int answer = 0;
        PriorityQueue<City> queue = new PriorityQueue<City>(cities, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.totalCost - o2.totalCost;
            }
        });
        nodes.get(capital - 1).totalCost = 0;
        queue.add(nodes.get(capital - 1));
        while (!queue.isEmpty()) {
            City current = queue.poll();
            if (!current.visited) {
                current.visited = true;
                for (Integer e : current.edges.keySet()) {
                    City target = nodes.get(e);
                    if (!target.visited) {
                        int calculatedCost = current.totalCost + current.edges.get(e);
                        if (target.totalCost > calculatedCost) {
                            target.totalCost = calculatedCost;
                        }
                        queue.add(target);
                    }
                }
            }
        }

        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).totalCost == capitalDistance)
                answer++;
            for (Integer end : nodes.get(i).edges.keySet()) {
                int endPoint = end;
                int weight = nodes.get(i).totalCost + nodes.get(i).edges.get(end);

                if (nodes.get(i).totalCost < capitalDistance && weight > capitalDistance) {
                    int ww = weight - capitalDistance + nodes.get(endPoint).totalCost;
                    if (ww > capitalDistance || (ww == capitalDistance && i < endPoint))
                        answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static class City {
        int id;
        int totalCost;
        boolean visited;
        HashMap<Integer, Integer> edges;

        public City(int id, int totalCost) {
            this.id = id;
            this.totalCost = totalCost;
            edges = new HashMap<Integer, Integer>();
            visited = false;
        }
    }
}

