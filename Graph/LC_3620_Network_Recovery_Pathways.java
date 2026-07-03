class Solution { //TC: (binarySearch: log(r-l) * isPossible (Elog(v)))
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        //adjecency list
        // u->v {{v,cost}, {v', cost'}....}
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<int[]>());
        }

        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;

        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            if(!online[u] || !online[v]) continue;
            adj.get(u).add(new int[] {v, cost});

            l = Math.min(l, cost);
            r = Math.max(r, cost);
        }

        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(isPossible(mid, adj, n, k)){
                ans = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return ans;
    }

    public boolean isPossible(int mid, List<List<int[]>> adj, int n, long k){
        //res[i] = min cost from source path to ith node
        long res[] = new long[n];
        Arrays.fill(res, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0], b[0]));

        res[0] = 0;
        pq.add(new long[] {0, 0});

        while(!pq.isEmpty()){
            long curr[] = pq.poll();
            long cost = curr[0];
            int node = (int)curr[1];

            if(cost > k) return false;
            if(node == n-1) return true;

            //the result of reaching from source to node = d;
            if(res[node] < cost) continue;

            for(int[] neigh: adj.get(node)){
                int adjNode = neigh[0];
                int cost2 = neigh[1];

                if(cost2<mid) continue;
                if(cost + cost2 < res[adjNode]){
                    res[adjNode] = cost + cost2;
                    pq.add(new long[] {res[adjNode], adjNode});
                }
            }
        }
        return false;
    }
}