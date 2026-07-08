class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        String num = Integer.toString(n);
        for(char ch: num.toCharArray()){
            if(ch-'0' != 0) x = x*10 + ch-'0';
            sum += ch-'0';
        }
        return sum * x;
    }
}