
class Pair {
    int x;
    int y;
    int t;
    Pair (int x,int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        int totalFreshOranges = 0;

        for (int i = 0; i<m ; i++ ){
            for (int j = 0; j<n ; j++ ){
                if (grid[i][j] == 2) {
                    q.add(new Pair(i,j,0));
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    totalFreshOranges++;
                }
            }
        }

        int[] rowTraverse = new int[]{-1,0,1,0};
        int[] colTraverse = new int[]{0,1,0,-1}; 
        int maxT = 0;
        int countRottingOranges = 0;

        while (!q.isEmpty()) {
            Pair currElem = q.remove();
            int x = currElem.x;
            int y = currElem.y;
            int t = currElem.t;
            maxT = Math.max(t,maxT);

            for (int i = 0 ; i < 4 ; i++) {
                int row = x + rowTraverse[i];
                int col = y + colTraverse[i];
                if (row >= 0 && row <m && col >= 0 && col < n && !visited[row][col] && grid[row][col] == 1 ) {
                    visited[row][col] = true;
                    q.add(new Pair(row,col,t+1));
                    countRottingOranges++;
                }
            }
        }

        if (countRottingOranges != totalFreshOranges)
            return -1;
        
        return maxT;
        
    }
}