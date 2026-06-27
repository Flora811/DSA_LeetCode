//Key points to consider : 
/*
    What if the nums consists of all 1s?
    We are looking for x*x -> which could go up to 10^9, Integer overflow??
*/
class Solution { //TC: O(n*log(n)) SC:O(1) + recursion stack of log n
    public int maximumLength(int[] nums) {
        // n = 2*(n-1)+1
        Map<Long, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put((long)num, map.getOrDefault((long)num, 0)+1);
        }
        
        int maxLen = 0;
        for(long key: map.keySet()){
            int subsetSz;
            if(key == 1){
                int freq = map.get(key);
                subsetSz = (freq%2==0)? freq-1: freq; 
            }
            else{
                int levels = solve(key, map);
                subsetSz = 2*(levels-1) + 1;
            }
            maxLen = Math.max(maxLen, subsetSz);
        }
        return maxLen;
    }

    public int solve(long key, Map<Long, Integer> map){
        if(!map.containsKey(key)) return 0;
        if(map.get(key)==1) return 1;
        return 1 + solve(key*key, map);
    }
}