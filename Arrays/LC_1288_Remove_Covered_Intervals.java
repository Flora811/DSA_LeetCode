class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;

        int rem = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(intervals[j][0]<=intervals[i][0] && intervals[j][1]>=intervals[i][1]){
                    rem++;
                    break;
                }
            }
        }

        return n-rem;
    }
}