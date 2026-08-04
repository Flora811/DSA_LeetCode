/* 
Approach 1 -> sorting the array
TC: O(n*log(n))
SC: O(1) + ans
*/
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();

        int currNum = nums[0];
        for(int i=0; i<n; i++){
            while(nums[i] != currNum) {
                ans.add(currNum++);
            }
            currNum ++;
        }

        return ans;
    }
}
/*
Approach 2 - using HashSet -> 
TC: O(n) --> improved
SC: O(n)
*/

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i= min+1; i<max; i++){
            if(!set.contains(i)) ans.add(i);
        }

        return ans;
    }
}
