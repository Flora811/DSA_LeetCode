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