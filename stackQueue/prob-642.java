class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> queueRadiant = new LinkedList<>();
        Queue<Integer> queueDire = new LinkedList<>();

        int count = 0;
        for (Character c: senate.toCharArray()) {
            if (c == 'R')
                queueRadiant.add(count);
            else
                queueDire.add(count);
            count++;
        }

        while (queueRadiant.size() > 0 && queueDire.size() > 0) {
            Integer indRad = queueRadiant.poll();
            Integer indDir = queueDire.poll();
            if (indRad < indDir) {
                queueRadiant.add(indRad+n);
            } else {
                queueDire.add(indDir+n);
            }
        }
        if (queueRadiant.size() > 0)
            return "Radiant";
        return "Dire";
    }
}