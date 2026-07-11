class Solution {
    int n;
    int parent[];
    int rank[];

    public int find(int i){//parent[]
        if(parent[i] == i){
            return i;
        }
        return parent[i] = find(parent[i]);
    }
    public void union(int x, int y){//parent[], rank[]
        int x_parent = find(x);
        int y_parent = find(y);

        if(x_parent == y_parent) return;

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else if (rank[y_parent] > rank[x_parent]){
            parent[x_parent] = y_parent;
        }
        else{
            parent[x_parent] = y_parent;
            rank[y_parent] += 1;
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        this.n = n;
        parent = new int[n];
        //starting me saab ka parent wo khud hi hai
        for(int i=0; i<n; i++) parent[i] = i;

        //starting me saab ka rank 0 hai
        rank = new int[n];

        boolean ans[] = new boolean[queries.length];

        for(int i=0; i<n-1; i++){
            if(nums[i+1]-nums[i] <= maxDiff){
                union(i, i+1);
            }
        }

        int i=0;
        for(int q[]: queries){
            int u = q[0];
            int v = q[1];
            if(find(u) == find(v))
                ans[i++] = true;
            else 
                ans[i++] = false;
        }

        return ans;
    }
}   