class Solution {
    int n;
    int t[];
    public String stoneGameIII(int[] stoneValue) {
        this.n = stoneValue.length;
        this.t = new int[n+1];
        Arrays.fill(t, Integer.MIN_VALUE);

        int scoreDiff = solve(0, stoneValue);

        if(scoreDiff > 0) return "Alice";
        if (scoreDiff == 0) return "Tie";
        return "Bob";
    }

    public int solve(int i, int[] stones){
        if(i >= n) return 0;

        if(t[i] != Integer.MIN_VALUE) return t[i];

        int diff = Integer.MIN_VALUE;
        
        diff = Math.max(diff, stones[i] - solve(i+1, stones));

        if(i+1 < n){
            diff = Math.max(diff, stones[i] + stones[i+1] - solve(i+2, stones));
        }
        if(i+2 < n){
            diff = Math.max(diff, stones[i] + stones[i+1] + stones[i+2] - solve(i+3, stones));
        }

        return t[i] = diff;
    }
}

/**
    Approach 2 - Bottom Up : 
    TC: O(n);
    SC: O(n);
*/

class Solution {
    int n;
    int t[];
    public String stoneGameIII(int[] stoneValue) {
        this.n = stoneValue.length;
        this.t = new int[n+1];

        //Bottom Up
        //t[n] = 0

        for(int i=n-1; i>=0; i--){
            int diff = Integer.MIN_VALUE;
            
            diff = Math.max(diff, stoneValue[i] - t[i+1]);
            if(i+1 < n)
                diff = Math.max(diff, stoneValue[i] + stoneValue[i+1] - t[i+2]);
            if(i+2 < n)
                diff = Math.max(diff, stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - t[i+3]);
            
            t[i] = diff;
        }

        //int scoreDiff = solve(0, stoneValue);
        int scoreDiff = t[0];

        if(scoreDiff > 0) return "Alice";
        if (scoreDiff == 0) return "Tie";
        return "Bob";
    }
}