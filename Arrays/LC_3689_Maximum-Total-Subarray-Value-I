//Honestly, this is the easy question - we are using the greedy solution. 

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long min = Long.MAX_VALUE;
        long max = -1;

        for(int n: nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        return (long)k * (max-min);
    }
}