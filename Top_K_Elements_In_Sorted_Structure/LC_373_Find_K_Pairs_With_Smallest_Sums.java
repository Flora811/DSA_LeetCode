import java.util.*;
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return ans;

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]) );

        for (int j = 0; j < nums2.length && j < k; j++) {
            pq.add(new int[]{nums1[0] + nums2[j], 0, j});
        }

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int i = curr[1];
            int j = curr[2];
            ans.add(List.of(nums1[i], nums2[j]));
            if(ans.size() == k) return ans;

            if(i+1 < nums1.length) pq.add(new int[] {nums1[i+1] + nums2[j], i+1, j});
        }
        return ans;
    }
}