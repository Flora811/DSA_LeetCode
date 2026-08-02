class Solution {
    int t[][];

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        t = new int[n+1][n+1];

        for(int x[]: t) Arrays.fill(x, -1);

        return solve(0, n-1, piles) > 0;
    }

    public int solve(int i, int j, int[] piles){
        if(i>j) return 0;
        if(i==j) return piles[i];

        if(t[i][j] != -1) return t[i][j];

        int take_i = piles[i] - solve(i+1, j, piles);
        int take_j = piles[j] - solve(i, j-1, piles);

        return t[i][j] = Math.max(take_i, take_j);
    }
}