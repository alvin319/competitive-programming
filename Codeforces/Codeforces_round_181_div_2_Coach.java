import java.util.*;

public class Codeforces_round_181_div_2_Coach
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int positions[] = new int[n + 1];
        ArrayList<ArrayList<Integer>> teamList = new ArrayList<>();
        boolean validTeam = true;
        for(int i = 1; i < n + 1; i++)
            positions[i] = -1;
        for(int i = 0; i < m && validTeam; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            if (positions[x] == -1 && positions[y] == -1) {
                if (teamList.size() < n / 3) {
                    teamList.add(new ArrayList<Integer>());
                    int l = teamList.size() - 1;
                    teamList.get(l).add(x);
                    teamList.get(l).add(y);
                    positions[x] = l;
                    positions[y] = l;
                } else
                    validTeam = false;
            } else {
                if (positions[x] != -1 && positions[y] != -1) {
                    if (positions[x] != positions[y])
                        validTeam = false;
                } else {
                    if (positions[x] == -1) {
                        if (teamList.get(positions[y]).size() < 3) {
                            teamList.get(positions[y]).add(x);
                            positions[x] = positions[y];
                        } else
                            validTeam = false;
                    } else {
                        if (teamList.get(positions[x]).size() < 3) {
                            teamList.get(positions[x]).add(y);
                            positions[y] = positions[x];
                        } else
                            validTeam = false;
                    }
                }
            }
        }
        if(validTeam) {
            int l = teamList.size();
            for (int i = l; i < n / 3; i++)
                teamList.add(new ArrayList<Integer>());
            l = 0;
            for (int i = 1; i <= n; i++) {
                if (positions[i] == -1) {
                    while (teamList.get(l).size() >= 3)
                        l++;
                    positions[i] = l;
                    teamList.get(l).add(i);
                }
            }
            for (int i = 0; i < teamList.size(); i++) {
                for (int j = 0; j < teamList.get(i).size(); j++) {
                    if (j == teamList.get(i).size() - 1)
                        System.out.println(teamList.get(i).get(j));
                    else
                        System.out.print(teamList.get(i).get(j) + " ");
                }
            }
        }
        else
            System.out.println("-1");
    }
}