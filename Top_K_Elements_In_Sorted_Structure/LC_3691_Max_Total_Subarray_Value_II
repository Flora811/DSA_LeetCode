class SegmentTree{

    int[] segmentTree;
    boolean isMinTree;

    SegmentTree(int[] nums, boolean flag){
        int n = nums.length;
        this.isMinTree = flag;

        segmentTree = new int[4*n];

        buildSegmentTree(0, 0, n-1, nums);
    }

    public void buildSegmentTree (int i, int l, int r, int[] nums){
        if(l==r){
            segmentTree[i] = nums[l];
            return;
        }
        int mid = l + (r-l)/2;

        buildSegmentTree(2*i+1, l, mid, nums);
        buildSegmentTree(2*i+2, mid+1, r, nums);

        if(isMinTree)
            segmentTree[i] = Math.min(segmentTree[2*i+1], segmentTree[2*i+2]);
        else
            segmentTree[i] = Math.max(segmentTree[2*i+1], segmentTree[2*i+2]);
    }

    public int querySegmentTree(int start, int end, int i, int l, int r){
        //No overlap
        if(l>end || r<start){
            return isMinTree ? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }

        //complete overlap
        if(l>= start && r<= end)
            return segmentTree[i];
        
        int mid = l + (r-l)/2;

        int a = querySegmentTree(start, end, 2*i+1, l, mid);
        int b = querySegmentTree(start, end, 2*i+2, mid+1, r);

        if(isMinTree)
            return Math.min(a,b);
        
        return Math.max(a,b);
    }

    int query (int l, int r, int n){
        return querySegmentTree(l, r, 0, 0, n-1);
    }
}
class Solution {

    public long getVal(int l, int r, SegmentTree minST, SegmentTree maxST, int n){
        int minEl = minST.query(l, r, n);
        int maxEl = maxST.query(l, r, n);

        return (long)maxEl - minEl;
    }
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        SegmentTree minST = new SegmentTree(nums, true);
        SegmentTree maxST = new SegmentTree(nums, false);

        //val, l, r
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(b[0], a[0]));

        //Step 1 --> Initialize the pq with first best vals
        for(int l=0; l<n; l++){
            long val = getVal(l, n-1, minST, maxST, n);
            pq.offer(new long[]{val, l, n-1});
        }

        //Step 2 --> Find top K
        long res = 0;

        while(k-- >0){
            long curr[] = pq.poll();
            long val = curr[0];
            int l = (int)curr[1];
            int r = (int)curr[2];

            res += val;

            long nxtBestVal = getVal(l, r-1, minST, maxST, n);
            pq.offer(new long[] {nxtBestVal, l, r-1});
        }

        return res;


    }
}