import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjointSet set = new DisjointSet();
        HashMap<String, HashSet<Integer>> ownerMap = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> accountInfo = accounts.get(i);
            String ownerName = accountInfo.get(0);
            List<String> emails = new ArrayList<>();

            for (int j = 1; j < accountInfo.size(); j++) {
                String currentEmail = accountInfo.get(j);
                emails.add(currentEmail);
                if (!ownerMap.containsKey(currentEmail)) {
                    ownerMap.put(currentEmail, new HashSet<>());
                }
                ownerMap.get(currentEmail).add(i);
            }

            set.createSet(i, ownerName, emails);
        }
        for (String email : ownerMap.keySet()) {
            if (ownerMap.get(email).size() > 1) {
                int previousIndex = -1;
                for (int index : ownerMap.get(email)) {
                    if (previousIndex != -1) {
                        set.unionSet(previousIndex, index);
                    }
                    previousIndex = index;
                }
            }
        }
        HashMap<Integer, HashSet<String>> unionMap = new HashMap<>();
        for (int x : set.map.keySet()) {
            int parentID = set.findSet(x);
            if (!unionMap.containsKey(parentID)) {
                unionMap.put(parentID, new HashSet<>());
            }
            unionMap.get(parentID).addAll(set.map.get(x).emails);
        }
        List<List<String>> finalAnswer = new ArrayList<>();
        for (int parentID : unionMap.keySet()) {
            String name = set.map.get(parentID).owner;
            List<String> account = new ArrayList<>();
            account.addAll(unionMap.get(parentID));
            Collections.sort(account);
            account.add(0, name);
            finalAnswer.add(account);
        }
        return finalAnswer;
    }

    static class DisjointSet {
        HashMap<Integer, Node> map;

        public DisjointSet() {
            map = new HashMap<>();
        }

        public void createSet(int data, String owner, List<String> emails) {
            Node node = new Node(data, owner, emails, 0);
            node.parent = node;
            map.put(data, node);
        }

        public int findSet(int data) {
            int parentData = map.get(data).parent.data;
            if (parentData == data) {
                return data;
            } else {
                return findSet(parentData);
            }
        }

        public boolean unionSet(int firstSet, int secondSet) {
            int firstParentID = findSet(firstSet);
            int secondParentID = findSet(secondSet);
            Node firstParent = map.get(firstParentID);
            Node secondParent = map.get(secondParentID);

            // If they are part of same set do nothing
            if (firstParentID == secondParentID) {
                return false;
            }

            if (firstParent.rank > secondParent.rank) {
                secondParent.parent = firstParent;
            } else if (firstParent.rank < secondParent.rank) {
                firstParent.parent = secondParent;
            } else {
                firstParent.rank++;
                secondParent.parent = firstParent;
            }
            map.put(firstParentID, firstParent);
            map.put(secondParentID, secondParent);

            return true;
        }
    }

    static class Node {
        int data;
        List<String> emails;
        String owner;
        Node parent;
        int rank;

        public Node(int data, String owner, List<String> emails, int rank) {
            this.data = data;
            this.owner = owner;
            this.emails = emails;
            this.rank = rank;
        }
    }
}