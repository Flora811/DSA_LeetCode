import java.util.*;

class Solution {
    int M = 1_000_000_000 + 7;

    public int fastPow(int a, int b){
        if(b==0) return 1;
        int half = fastPow(a, b/2);
        long res = ((long)half * half)%M;
        if(b%2==1) res = (res* a)%M;

        return (int)res;
    }
    public int assignEdgeWeights(int[][] edges) {
        //find the depth of the graph like tree

        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int d = getMaxDepth(adj, 1, -1);
        System.out.println("max Depth: "+d);
        //no. of odd costs = no. of even costs 
        //Total possibilities = 2^d / 2 = 2^(d-1), where d could be a big number
        return fastPow(2, d-1);
    }

    public int getMaxDepth(Map<Integer, ArrayList<Integer>> adj, int root, int parent){
        int maxDepth = 0;
        for(int nei: adj.get(root)){
            if(nei == parent) continue;
            maxDepth = Math.max(maxDepth, getMaxDepth(adj, nei, root)+1);
        }
        return maxDepth;
    }
}