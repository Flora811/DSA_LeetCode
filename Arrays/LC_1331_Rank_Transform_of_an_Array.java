class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;

        int ans[] = new int[n];
        if(n==0) return ans;

        //number | idx
        int sorted[][] = new int[n][2];
        for(int i=0; i<n; i++){
            sorted[i][0] = arr[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));

        int rank = 1;
        ans[sorted[0][1]] = 1;
        for(int i=1; i<n; i++){
            int idx = sorted[i][1];
            if(sorted[i][0] == sorted[i-1][0]){
                ans[idx] = ans[sorted[i-1][1]];
            }
            else{
                ans[idx] = ++rank;
            }
        }

        return ans;
    }
}