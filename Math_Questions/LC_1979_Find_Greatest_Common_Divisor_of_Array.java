class Solution {
    public int gcd(int a, int b){
        return b==0 ? a : gcd(b, a%b);
    }

    public int findGCD(int[] nums) {
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;

        for(int num: nums){
            small = Math.min(small, num);
            large = Math.max(large, num);
        }

        return gcd(small, large);
    }
}