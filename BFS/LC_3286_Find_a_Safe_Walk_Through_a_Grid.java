class Solution { // TC: O(mn*log(mn))
                 // SC: O(mn)
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int dir[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int m = grid.size();
        int n = grid.get(0).size();
        //health | r | c
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        boolean visited[][] = new boolean[m][n];

        health -= grid.get(0).get(0);
        if(health < 1) return false;
        pq.add(new int[] {health, 0, 0});
        visited[0][0] = true;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currHealth = curr[0];
            int i = curr[1];
            int j = curr[2];

            if(currHealth<1) continue;

            if(i==m-1 && j==n-1) return true;


            for(int d[]: dir){
                int new_i = i+d[0];
                int new_j = j+d[1];

                if(new_i<0 || new_i>=m || new_j<0 || new_j>=n || visited[new_i][new_j]) 
                    continue;
                
                int new_health = currHealth - grid.get(new_i).get(new_j);

                pq.add(new int[]{new_health, new_i, new_j});
                visited[new_i][new_j] = true;

            }
        }
        return false;
    }
}