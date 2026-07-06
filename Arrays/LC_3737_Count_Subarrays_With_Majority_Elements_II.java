class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int cumSum = 0;
        //cumulative sum : freq --> how many times have I seen it in the past?
        Map<Integer, Integer> map = new HashMap<>();

        // we have seen cumulative sum 0 one time. 
        map.put(0, 1);
        long validLeftPoints = 0;
        long res = 0;
        for(int i=0; i<n; i++){
            if(nums[i]==target){
                validLeftPoints += map.getOrDefault(cumSum, 0);
                cumSum += 1;
            }
            else{
                cumSum -= 1;
                validLeftPoints -= map.getOrDefault(cumSum, 0);
            }
            res += validLeftPoints;
            map.put(cumSum, map.getOrDefault(cumSum, 0)+1);
        }

        return res;
    }
}