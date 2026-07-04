class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int r[] : roads){
            int u = r[0];
            int v = r[1];
            int d = r[2];
            adj.get(u).add(new int[] {v,d});
            adj.get(v).add(new int[] {u, d});
        }

        boolean visited[] = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        int ans = Integer.MAX_VALUE;

        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()){
            int curr = q.poll();

            for(int neigh[]: adj.get(curr)){
                int v = neigh[0];
                int d = neigh[1];

                ans = Math.min(ans, d);
                
                if(!visited[v]){
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
        return ans;
    }
}