class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        Set<Integer> duplet = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                duplet.add(nums[i]^nums[j]);
            }
        }

        Set<Integer> triplet = new HashSet<>();
        for(int dup: duplet){
            for(int num: nums){
                triplet.add(dup^num);
            }
        }

        return triplet.size();
    }
}