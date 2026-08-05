class Solution {
    // only idea: if a is not affected and b is affected 
    //        --> outside node calling inside the grp. 
    //              In that case return all the nodes, not possible to remove the affected node

    // Otherwise return only the unaffected nodes.

    //TC: O(V+E)
    //SC: O(V+E)
    
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++) adj.add(i, new ArrayList<>());

        for(int invoke[]: invocations){
            int a = invoke[0];
            int b = invoke[1];

            adj.get(a).add(b);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean affected[] = new boolean [n];

        q.add(k);
        affected[k] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int neigh: adj.get(curr)){
                if(!affected[neigh]){
                    q.add(neigh);
                    affected[neigh] = true;
                }
            }
        }

        List<Integer> remaining = new ArrayList<>();

         for(int invoke[]: invocations){
            int a = invoke[0];
            int b = invoke[1];

            if(!affected[a] && affected[b])
            {
                for(int i=0; i<n; i++) remaining.add(i);
                return remaining;
            }
        }

        for(int i=0; i<n; i++){
            if(!affected[i])
                remaining.add(i);
        }

        return remaining;
    }
}