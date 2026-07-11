class Solution {
    //TC: O(V+E) DFS
    //SC: O(V+E) adj list
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(i, new ArrayList<>());

        for(int e[]: edges){
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean visited[] = new boolean[n];
        int ans=0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                // Edge | vertex
                int evCount[] = countEdges(i, adj, visited);
                int v = evCount[1];
                int e = evCount[0];
                if(v*(v-1) == e) ans++;
            }
        }
        return ans;
    }
    public int[] countEdges(int node, List<List<Integer>> adj, boolean visited[]){

        visited[node] = true;

        int edges = adj.get(node).size();
        int vertices = 1;

        for(int neigh: adj.get(node)){
            if(!visited[neigh]){
                int[] ev = countEdges(neigh, adj, visited);
                edges += ev[0];
                vertices += ev[1];
            }
        }
        return new int[] {edges, vertices};
    }
}