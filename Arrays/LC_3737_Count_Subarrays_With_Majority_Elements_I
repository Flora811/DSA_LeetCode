class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            int t_count = 0;
            for(int j=i; j<nums.length; j++){
                if(nums[j] == target) t_count++;
                if(t_count > (j-i+1)/2) count++;
            }
        }
        return count;
    }
}