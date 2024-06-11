class Solution {
    public int maximumDetonation(int[][] bombs) {
        int noBombs = bombs.length;
        int max = 1;
        for (int i = 0; i <noBombs; i++) {
            int currDiff = findTotalBombDiffused(bombs,i);
            if ( currDiff == noBombs)
                return noBombs;
            else
                max = Math.max(max,currDiff);
        }
        return max;
    }

    private double calculateDistance(int x1, int y1, int x2, int y2) {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    private int findTotalBombDiffused(int[][] bombs, int center) {
        int noBombs = bombs.length;
        boolean[] visited = new boolean[noBombs];
        visited[center] = true;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i <noBombs; i++) {
            if (i == center) {
                continue;
            }
            if (calculateDistance(bombs[center][0],bombs[center][1],bombs[i][0],bombs[i][1]) <= bombs[center][2]) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int topElem = q.remove();
            visited[topElem] = true;
            for (int i = 0; i <noBombs; i++) {
                if (!visited[i]) {
                    double dist = calculateDistance(bombs[topElem][0],bombs[topElem][1],bombs[i][0],bombs[i][1]);

                    if (dist <= bombs[topElem][2]) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
                
            }
        }


        int totalBombs = 0;
        for (int i = 0; i <noBombs; i++) {
            if (visited[i])
                totalBombs++;
        }

        return totalBombs;

    }
}