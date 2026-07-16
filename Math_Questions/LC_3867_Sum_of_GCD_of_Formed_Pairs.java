class Solution {
    public int gcd(int a, int b){
        return b==0? a : gcd(b, a%b);
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        int prefixGcd[] = new int [n];

        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }

        Arrays.sort(prefixGcd);

        long sum = 0;
        int i = 0;
        int j = n-1;
        while(i<j){
            sum += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }

        return sum;
    }
}