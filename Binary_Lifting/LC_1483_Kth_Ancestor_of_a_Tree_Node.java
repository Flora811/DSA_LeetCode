class TreeAncestor {
    int[][] ancestor;
    int cols;
    public TreeAncestor(int n, int[] parent) {
        this.cols = (int)(Math.log(n) / Math.log(2))+1;
        this.ancestor = new int[n][cols];
        for(int i=0; i<n; i++){
            ancestor[i][0] = parent[i];
        }
        for(int j=1; j<cols; j++){
            for(int node = 0; node<n; node++){
                if(ancestor[node][j-1] != -1)
                    ancestor[node][j] = ancestor[ancestor[node][j-1]][j-1];
                else
                    ancestor[node][j] = -1;
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int jump = 0;
        while(k>0){
            if((k&1) == 1)
                node = ancestor[node][jump];
            if(node==-1) return -1;
            jump++;
            k >>= 1;
        }
        return node;
    }  
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */