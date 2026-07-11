class Solution {
    //TC: E * alpha (V)
    public int find(int x, int parent[]){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }

    public void union(int x, int y, int[] parent, int size[]){
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if(x_parent == y_parent) return;

        if(size[x_parent] > size[y_parent]){
            parent[y_parent] = x_parent;
            size[x_parent] += size[y_parent];
        }
        else if (size[y_parent] > size[x_parent]){
            parent[x_parent] = y_parent;
            size[y_parent] += size[x_parent];
        }
        else{
            parent[x_parent] = y_parent;
            size[y_parent] += size[x_parent];
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        //At the Start -> everyone is its own parent
        for(int i=0; i<n; i++) parent[i] = i;

        int[] size = new int[n];
        Arrays.fill(size, 1);

        Map<Integer, Integer> map = new HashMap<>();

        for(int e[]: edges){
            union(e[0], e[1], parent, size);
        }

        for(int e[]: edges){
            int p = find(e[0], parent);
            map.put(p, map.getOrDefault(p, 0)+1);
        }

        int ans =0;
        boolean visited[] = new boolean[n];
        for(int i=0; i<n; i++){
            int p = parent[i];
            if(visited[p]) continue;

            visited[p] = true;
            int v = size[p];
            int e = map.getOrDefault(p, 0);

            if( (v*(v-1)/2) == e) ans++;
        }

        return ans;
    }
}